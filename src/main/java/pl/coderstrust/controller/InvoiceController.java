package pl.coderstrust.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.net.URI;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.coderstrust.model.Invoice;
import pl.coderstrust.service.InvoiceEmailService;
import pl.coderstrust.service.InvoicePdfService;
import pl.coderstrust.service.InvoiceService;

@RestController
@RequestMapping("/invoices")
@Api(value = "/invoices")
public class InvoiceController {

    private Logger logger = LoggerFactory.getLogger(InvoiceController.class);

    private final InvoiceService invoiceService;
    private final InvoiceEmailService invoiceEmailService;
    private final InvoicePdfService invoicePdfService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService, InvoiceEmailService invoiceEmailService, InvoicePdfService invoicePdfService) {
        this.invoiceService = invoiceService;
        this.invoiceEmailService = invoiceEmailService;
        this.invoicePdfService = invoicePdfService;
    }

    @GetMapping
    @ApiOperation(value = "Get all invoices", notes = "Retrieving the collection of all invoices in database", response = Invoice[].class)
    @ApiResponses({
        @ApiResponse(code = 200, message = "OK", response = Invoice[].class),
        @ApiResponse(code = 500, message = "Internal server error", response = ErrorMessage.class)
    })
    public ResponseEntity<?> getAll() {
        try {
            return new ResponseEntity<>(invoiceService.getAllInvoices(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("An error occurred during getting all invoices.", e);
            return new ResponseEntity<>(new ErrorMessage("Something went wrong, we are working hard to fix it. Please try again."),
                HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get invoice by id", notes = "Retrieving the invoice by provided id", response = Invoice.class)
    @ApiResponses({
        @ApiResponse(code = 200, message = "OK", response = Invoice.class),
        @ApiResponse(code = 404, message = "Invoice not found", response = ErrorMessage.class),
        @ApiResponse(code = 500, message = "Internal server error", response = ErrorMessage.class)
    })
    @ApiImplicitParam(required = true, name = "id", value = "Id of the invoice to get", dataType = "Long")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        try {
            Optional<Invoice> invoice = invoiceService.getInvoiceById(id);
            if (invoice.isPresent()) {
                return new ResponseEntity<>(invoice.get(), HttpStatus.OK);
            }
            logger.error("Attempt to get invoice by id that does not exist in database.");
            return new ResponseEntity<>(new ErrorMessage("Invoice does not exist in database."), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("An error occurred during getting invoice by id.", e);
            return new ResponseEntity<>(new ErrorMessage("Something went wrong, we are working hard to fix it. Please try again."),
                HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/byNumber")
    @ApiOperation(value = "Get invoice by number", notes = "Retrieving the invoice by provided number", response = Invoice.class)
    @ApiResponses({
        @ApiResponse(code = 200, message = "OK", response = Invoice.class),
        @ApiResponse(code = 400, message = "Bad request", response = ErrorMessage.class),
        @ApiResponse(code = 404, message = "Invoice not found", response = ErrorMessage.class),
        @ApiResponse(code = 500, message = "Internal server error", response = ErrorMessage.class)
    })
    @ApiImplicitParam(required = true, name = "number", value = "Number of the invoice to get", dataType = "String")
    public ResponseEntity<?> getByNumber(@RequestParam String number) {
        if (number == null) {
            logger.error("Attempt to get invoice providing null number.");
            return new ResponseEntity<>(new ErrorMessage("Number cannot be null."), HttpStatus.BAD_REQUEST);
        }
        try {
            Optional<Invoice> invoice = invoiceService.getInvoiceByNumber(number);
            if (invoice.isPresent()) {
                return new ResponseEntity<>(invoice.get(), HttpStatus.OK);
            }
            logger.debug("Attempt to get invoice by id that does not exist in database.");
            return new ResponseEntity<>(new ErrorMessage("Invoice does not exist in database."), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("An error occurred during getting invoice by name.", e);
            return new ResponseEntity<>(new ErrorMessage("Something went wrong, we are working hard to fix it. Please try again."),
                HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    @ApiOperation(value = "Add new invoice", notes = "Add new invoice to database", response = Invoice.class)
    @ApiResponses({
        @ApiResponse(code = 201, message = "Created", response = Invoice.class),
        @ApiResponse(code = 400, message = "Bad request", response = ErrorMessage.class),
        @ApiResponse(code = 409, message = "Invoice exists", response = ErrorMessage.class),
        @ApiResponse(code = 500, message = "Internal server error", response = ErrorMessage.class)
    })
    @ApiImplicitParam(required = true, name = "invoice", value = "New invoice data", dataType = "Invoice")
    public ResponseEntity<?> add(@RequestBody Invoice invoice) {
        if (invoice == null) {
            logger.error("Attempt to add null invoice.");
            return new ResponseEntity<>(new ErrorMessage("Invoice cannot be null."), HttpStatus.BAD_REQUEST);
        }
        try {
            if (invoice.getId() != null && invoiceService.invoiceExists(invoice.getId())) {
                logger.error("Attempt to add invoice already existing in database.");
                return new ResponseEntity<>(new ErrorMessage("Invoice already exists in database."), HttpStatus.CONFLICT);
            }
            Invoice addedInvoice = invoiceService.addInvoice(invoice);
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.setLocation(URI.create(String.format("/invoices/%d", addedInvoice.getId())));
            invoiceEmailService.sendMailWithInvoice(addedInvoice);
            logger.debug(String.format("New invoice added with id %d.", invoice.getId()));
            return new ResponseEntity<>(addedInvoice, responseHeaders, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("An error occurred during adding new invoice.", e);
            return new ResponseEntity<>(new ErrorMessage("Something went wrong, we are working hard to fix it. Please try again."),
                HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update invoice", notes = "Update invoice with provided id", response = Invoice.class)
    @ApiResponses({
        @ApiResponse(code = 200, message = "OK", response = Invoice.class),
        @ApiResponse(code = 400, message = "Bad request", response = ErrorMessage.class),
        @ApiResponse(code = 404, message = "Invoice not found", response = ErrorMessage.class),
        @ApiResponse(code = 500, message = "Internal server error", response = ErrorMessage.class)
    })
    @ApiImplicitParams({
        @ApiImplicitParam(required = true, name = "id", value = "Id of invoice to update", dataType = "Long"),
        @ApiImplicitParam(required = true, name = "invoice", value = "Invoice with updated data", dataType = "Invoice")
    })
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Invoice invoice) {
        if (invoice == null) {
            logger.error("Attempt to update invoice providing null invoice.");
            return new ResponseEntity<>(new ErrorMessage("Invoice cannot be null."), HttpStatus.BAD_REQUEST);
        }
        try {
            if (!id.equals(invoice.getId())) {
                logger.error("Attempt to update invoice providing different invoice id.");
                return new ResponseEntity<>(new ErrorMessage("Id is different than given invoice's id."), HttpStatus.BAD_REQUEST);
            }
            if (!invoiceService.invoiceExists(id)) {
                logger.error("Attempt to update not existing invoice.");
                return new ResponseEntity<>(new ErrorMessage("Given invoice cannot be updated because it does not exist in database."),
                    HttpStatus.NOT_FOUND);
            }
            logger.debug(String.format("Updated invoice with id %d.", invoice.getId()));
            return new ResponseEntity<>(invoiceService.updateInvoice(invoice), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("An error occurred during updating invoice.", e);
            return new ResponseEntity<>(new ErrorMessage("Something went wrong, we are working hard to fix it. Please try again."),
                HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete invoice", notes = "Delete invoice with provided id")
    @ApiResponses({
        @ApiResponse(code = 204, message = "No content"),
        @ApiResponse(code = 404, message = "Invoice not found", response = ErrorMessage.class),
        @ApiResponse(code = 500, message = "Internal server error", response = ErrorMessage.class)
    })
    @ApiImplicitParam(required = true, name = "id", value = "Id of invoice to delete", dataType = "Long")
    public ResponseEntity<?> remove(@PathVariable("id") Long id) {
        try {
            if (!invoiceService.invoiceExists(id)) {
                logger.error("Attempt to delete not existing invoice.");
                return new ResponseEntity<>(new ErrorMessage("Given invoice cannot be deleted because it does not exist in database."),
                    HttpStatus.NOT_FOUND);
            }
            invoiceService.deleteInvoiceById(id);
            logger.debug(String.format("Deleted invoice with id %d.", id));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorMessage("Something went wrong, we are working hard to fix it. Please try again."),
                HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/pdf/{id}")
    @ApiOperation(value = "Get invoice as PDF", notes = "Retrieving the invoice by provided id to create pdf")
    @ApiResponses({
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 404, message = "Invoice not found", response = ErrorMessage.class),
        @ApiResponse(code = 500, message = "Internal server error", response = ErrorMessage.class)
    })
    @ApiImplicitParam(required = true, name = "id", value = "Id of the invoice to get", dataType = "Long")
    public ResponseEntity<?> createPdf(@PathVariable("id") Long id) {
        try {
            Optional<Invoice> invoice = invoiceService.getInvoiceById(id);
            if (invoice.isPresent()) {
                byte[] byteArray = (invoicePdfService.createPdf(invoice.get()));
                HttpHeaders responseHeaders = new HttpHeaders();
                responseHeaders.setContentType(MediaType.APPLICATION_PDF);
                return new ResponseEntity<>(byteArray, responseHeaders, HttpStatus.OK);
            }
            return new ResponseEntity<>(new ErrorMessage("Invoice does not exist in database."), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("An error occurred during deleting invoice.", e);
            return new ResponseEntity<>(new ErrorMessage("Something went wrong, we are working hard to fix it. Please try again."),
                HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private class ErrorMessage {

        private String message;

        public ErrorMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
