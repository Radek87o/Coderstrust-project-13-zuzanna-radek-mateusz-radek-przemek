package pl.coderstrust.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import pl.coderstrust.generators.InvoiceGenerator;
import pl.coderstrust.model.Invoice;
import pl.coderstrust.service.InvoiceService;
import pl.coderstrust.service.ServiceOperationException;

@ExtendWith(SpringExtension.class)
@WebMvcTest(InvoiceController.class)
class InvoiceControllerTest {

    @MockBean
    private InvoiceService invoiceService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    @WithMockUser(username = "user", password = "pass")
    public void shouldReturnAllInvoices() throws Exception {
        Collection<Invoice> invoices = Arrays.asList(InvoiceGenerator.getRandomInvoice(), InvoiceGenerator.getRandomInvoice());
        when(invoiceService.getAllInvoices()).thenReturn(invoices);

        String url = "/invoices";

        mockMvc.perform(get(url)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().json(mapper.writeValueAsString(invoices)));

        verify(invoiceService).getAllInvoices();
    }

    @Test
    @WithMockUser(username = "user", password = "pass")
    public void shouldReturnEmptyListOfInvoicesWhenThereAreNoInvoicesInTheDatabase() throws Exception {
        Collection<Invoice> invoices = new ArrayList<>();
        when(invoiceService.getAllInvoices()).thenReturn(invoices);

        String url = "/invoices";

        mockMvc.perform(get(url)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().json(mapper.writeValueAsString(invoices)));

        verify(invoiceService).getAllInvoices();
    }

    @Test
    @WithMockUser(username = "user", password = "pass")
    public void shouldReturnInternalServerErrorDuringGettingAllInvoicesWhenSomethingWentWrongOnServer() throws Exception {
        when(invoiceService.getAllInvoices()).thenThrow(new ServiceOperationException());

        String url = "/invoices";

        mockMvc.perform(get(url)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isInternalServerError());

        verify(invoiceService).getAllInvoices();
    }

    @Test
    @WithMockUser(username = "user", password = "pass")
    public void shouldReturnInvoiceById() throws Exception {
        Invoice invoice = InvoiceGenerator.getRandomInvoice();
        when(invoiceService.getInvoiceById(invoice.getId())).thenReturn(Optional.of(invoice));

        String url = String.format("/invoices/%d", invoice.getId());

        mockMvc.perform(get(url)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().json(mapper.writeValueAsString(invoice)));

        verify(invoiceService).getInvoiceById(invoice.getId());
    }

    @Test
    @WithMockUser(username = "user", password = "pass")
    public void shouldReturnNotFoundStatusDuringGettingInvoiceByIdWhenInvoiceWithSpecificIdDoesNotExist() throws Exception {
        Long id = 1L;
        when(invoiceService.getInvoiceById(id)).thenReturn(Optional.empty());

        String url = String.format("/invoices/%d", id);

        mockMvc.perform(get(url)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound());

        verify(invoiceService).getInvoiceById(id);
    }

    @Test
    @WithMockUser(username = "user", password = "pass")
    public void shouldReturnInternalServerErrorDuringGettingInvoiceByIdWhenSomethingWentWrongOnServer() throws Exception {
        Long id = 1L;
        when(invoiceService.getInvoiceById(id)).thenThrow(new ServiceOperationException());

        String url = String.format("/invoices/%d", id);

        mockMvc.perform(get(url)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isInternalServerError());

        verify(invoiceService).getInvoiceById(id);
    }

    @Test
    @WithMockUser(username = "user", password = "pass")
    public void shouldReturnBadRequestStatusDuringGettingInvoiceByNumberWhenNumberIsNull() throws Exception {
        String url = "/invoices/byNumber";

        mockMvc.perform(get(url)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest());

        verify(invoiceService, never()).getInvoiceByNumber(any());
    }

    @Test
    @WithMockUser(username = "user", password = "pass")
    public void shouldReturnInvoiceByNumber() throws Exception {
        Invoice invoice = InvoiceGenerator.getRandomInvoice();
        when(invoiceService.getInvoiceByNumber(invoice.getNumber())).thenReturn(Optional.of(invoice));

        String url = String.format("/invoices/byNumber?number=%s", invoice.getNumber());

        mockMvc.perform(get(url)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().json(mapper.writeValueAsString(invoice)));

        verify(invoiceService).getInvoiceByNumber(invoice.getNumber());
    }

    @Test
    @WithMockUser(username = "user", password = "pass")
    public void shouldReturnNotFoundStatusDuringGettingInvoiceByNumberWhenInvoiceWithSpecificNumberDoesNotExist() throws Exception {
        String number = "1a";
        when(invoiceService.getInvoiceByNumber(number)).thenReturn(Optional.empty());

        String url = String.format("/invoices/byNumber?number=%s", number);

        mockMvc.perform(get(url)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound());

        verify(invoiceService).getInvoiceByNumber(number);
    }

    @Test
    @WithMockUser(username = "user", password = "pass")
    public void shouldReturnInternalServerErrorDuringGettingInvoiceByNumberWhenSomethingWentWrongOnServer() throws Exception {
        String number = "1a";
        when(invoiceService.getInvoiceByNumber(number)).thenThrow(new ServiceOperationException());

        String url = String.format("/invoices/byNumber?number=%s", number);

        mockMvc.perform(get(url)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isInternalServerError());

        verify(invoiceService).getInvoiceByNumber(number);
    }

    @Test
    @WithMockUser(username = "user", password = "pass")
    public void shouldAddInvoice() throws Exception {
        Invoice invoiceToAdd = InvoiceGenerator.getRandomInvoice();
        Invoice addedInvoice = InvoiceGenerator.getRandomInvoice();
        when(invoiceService.invoiceExists(invoiceToAdd.getId())).thenReturn(false);
        when(invoiceService.addInvoice(invoiceToAdd)).thenReturn(addedInvoice);

        String url = "/invoices";

        mockMvc.perform(post(url).with(csrf().asHeader())
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsBytes(invoiceToAdd))
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isCreated())
            .andExpect(header().stringValues("location", String.format("/invoices/%d", addedInvoice.getId())))
            .andExpect(content().json(mapper.writeValueAsString(addedInvoice)));

        verify(invoiceService).invoiceExists(invoiceToAdd.getId());
        verify(invoiceService).addInvoice(invoiceToAdd);
    }

    @Test
    @WithMockUser(username = "user", password = "pass")
    public void shouldReturnConflictStatusDuringAddingInvoiceWhenInvoiceExistsInDatabase() throws Exception {
        Invoice invoice = InvoiceGenerator.getRandomInvoice();
        when(invoiceService.invoiceExists(invoice.getId())).thenReturn(true);

        String url = "/invoices";

        mockMvc.perform(post(url).with(csrf().asHeader())
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsBytes(invoice))
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isConflict());

        verify(invoiceService).invoiceExists(invoice.getId());
        verify(invoiceService, never()).addInvoice(invoice);
    }

    @Test
    @WithMockUser(username = "user", password = "pass")
    public void shouldReturnBadRequestStatusDuringAddingNullAsInvoice() throws Exception {
        String url = "/invoices";

        mockMvc.perform(post(url).with(csrf().asHeader())
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsBytes(null))
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest());

        verify(invoiceService, never()).invoiceExists(any());
        verify(invoiceService, never()).addInvoice(any());
    }

    @Test
    @WithMockUser(username = "user", password = "pass")
    public void shouldReturnInternalServerErrorDuringAddingInvoiceWhenSomethingWentWrongOnServer() throws Exception {
        Invoice invoice = InvoiceGenerator.getRandomInvoice();
        when(invoiceService.invoiceExists(invoice.getId())).thenReturn(false);
        when(invoiceService.addInvoice(invoice)).thenThrow(new ServiceOperationException());

        String url = "/invoices";

        mockMvc.perform(post(url).with(csrf().asHeader())
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsBytes(invoice))
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isInternalServerError());

        verify(invoiceService).invoiceExists(invoice.getId());
        verify(invoiceService).addInvoice(invoice);
    }

    @Test
    @WithMockUser(username = "user", password = "pass")
    public void shouldUpdateInvoice() throws Exception {
        Invoice invoice = InvoiceGenerator.getRandomInvoice();
        when(invoiceService.invoiceExists(invoice.getId())).thenReturn(true);
        when(invoiceService.updateInvoice(invoice)).thenReturn(invoice);

        String url = String.format("/invoices/%d", invoice.getId());

        mockMvc.perform(put(url).with(csrf().asHeader())
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsBytes(invoice))
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().json(mapper.writeValueAsString(invoice)));

        verify(invoiceService).invoiceExists(invoice.getId());
        verify(invoiceService).updateInvoice(invoice);
    }

    @Test
    @WithMockUser(username = "user", password = "pass")
    public void shouldReturnBadRequestStatusDuringUpdatingNullAsInvoice() throws Exception {
        String url = "/invoices/1";

        mockMvc.perform(put(url).with(csrf().asHeader())
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsBytes(null))
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest());

        verify(invoiceService, never()).invoiceExists(any());
        verify(invoiceService, never()).invoiceExists(any());
    }

    @Test
    @WithMockUser(username = "user", password = "pass")
    public void shouldReturnBadRequestStatusDuringUpdatingInvoiceWhenPassedIdIsDifferentThanInvoiceId() throws Exception {
        Invoice invoice = InvoiceGenerator.getRandomInvoice();

        String url = String.format("/invoices/%d", Long.valueOf(invoice.getId() + "1"));

        mockMvc.perform(put(url).with(csrf().asHeader())
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsBytes(invoice))
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest());

        verify(invoiceService, never()).invoiceExists(any());
        verify(invoiceService, never()).updateInvoice(any());
    }

    @Test
    @WithMockUser(username = "user", password = "pass")
    public void shouldReturnNotFoundStatusDuringUpdatingInvoiceWhenInvoiceDoesNotExistInDatabase() throws Exception {
        Invoice invoice = InvoiceGenerator.getRandomInvoice();
        when(invoiceService.invoiceExists(invoice.getId())).thenReturn(false);

        String url = String.format("/invoices/%d", invoice.getId());

        mockMvc.perform(put(url).with(csrf().asHeader())
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsBytes(invoice))
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound());

        verify(invoiceService).invoiceExists(invoice.getId());
        verify(invoiceService, never()).updateInvoice(invoice);
    }

    @Test
    @WithMockUser(username = "user", password = "pass")
    public void shouldReturnInternalServerErrorDuringUpdatingInvoiceWhenSomethingWentWrongOnServer() throws Exception {
        Invoice invoice = InvoiceGenerator.getRandomInvoice();
        when(invoiceService.invoiceExists(invoice.getId())).thenReturn(true);
        when(invoiceService.updateInvoice(invoice)).thenThrow(new ServiceOperationException());

        String url = String.format("/invoices/%d", invoice.getId());

        mockMvc.perform(put(url).with(csrf().asHeader())
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsBytes(invoice))
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isInternalServerError());

        verify(invoiceService).invoiceExists(invoice.getId());
        verify(invoiceService).updateInvoice(invoice);
    }

    @Test
    @WithMockUser(username = "user", password = "pass")
    public void shouldRemoveInvoice() throws Exception {
        Invoice invoice = InvoiceGenerator.getRandomInvoice();
        when(invoiceService.invoiceExists(invoice.getId())).thenReturn(true);
        doNothing().when(invoiceService).deleteInvoiceById(invoice.getId());

        String url = String.format("/invoices/%d", invoice.getId());

        mockMvc.perform(delete(url).with(csrf().asHeader())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        verify(invoiceService).invoiceExists(invoice.getId());
        verify(invoiceService).deleteInvoiceById(invoice.getId());
    }

    @Test
    @WithMockUser(username = "user", password = "pass")
    public void shouldReturnNotFoundStatusDuringRemovingInvoiceWhenInvoiceDoesNotExistInDatabase() throws Exception {
        when(invoiceService.invoiceExists(1L)).thenReturn(false);

        String url = "/invoices/1";

        mockMvc.perform(delete(url).with(csrf().asHeader())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound());

        verify(invoiceService).invoiceExists(1L);
        verify(invoiceService, never()).deleteInvoiceById(1L);
    }

    @Test
    @WithMockUser(username = "user", password = "pass")
    public void shouldReturnInternalServerErrorDuringRemovingInvoiceWhenSomethingWentWrongOnServer() throws Exception {
        Long invoiceId = 1L;
        when(invoiceService.invoiceExists(invoiceId)).thenReturn(true);
        doThrow(ServiceOperationException.class).when(invoiceService).deleteInvoiceById(invoiceId);

        String url = String.format("/invoices/%d", invoiceId);

        mockMvc.perform(delete(url).with(csrf().asHeader())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isInternalServerError());

        verify(invoiceService).invoiceExists(invoiceId);
        verify(invoiceService).deleteInvoiceById(invoiceId);
    }
}