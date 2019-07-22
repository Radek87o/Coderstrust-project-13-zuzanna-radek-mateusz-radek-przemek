//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.07.23 at 01:12:00 AM CEST 
//


package pl.coderstrust.soap.bindingclasses;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pl.coderstrust.soap.bindingclasses package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.coderstrust.soap.bindingclasses
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllInvoicesRequest }
     * 
     */
    public GetAllInvoicesRequest createGetAllInvoicesRequest() {
        return new GetAllInvoicesRequest();
    }

    /**
     * Create an instance of {@link AddInvoiceRequest }
     * 
     */
    public AddInvoiceRequest createAddInvoiceRequest() {
        return new AddInvoiceRequest();
    }

    /**
     * Create an instance of {@link InvoiceSoap }
     * 
     */
    public InvoiceSoap createInvoiceSoap() {
        return new InvoiceSoap();
    }

    /**
     * Create an instance of {@link GetInvoiceByIdRequest }
     * 
     */
    public GetInvoiceByIdRequest createGetInvoiceByIdRequest() {
        return new GetInvoiceByIdRequest();
    }

    /**
     * Create an instance of {@link UpdateInvoiceRequest }
     * 
     */
    public UpdateInvoiceRequest createUpdateInvoiceRequest() {
        return new UpdateInvoiceRequest();
    }

    /**
     * Create an instance of {@link DeleteInvoiceByIdRequest }
     * 
     */
    public DeleteInvoiceByIdRequest createDeleteInvoiceByIdRequest() {
        return new DeleteInvoiceByIdRequest();
    }

    /**
     * Create an instance of {@link DeleteAllInvoicesRequest }
     * 
     */
    public DeleteAllInvoicesRequest createDeleteAllInvoicesRequest() {
        return new DeleteAllInvoicesRequest();
    }

    /**
     * Create an instance of {@link InvoiceExistsRequest }
     * 
     */
    public InvoiceExistsRequest createInvoiceExistsRequest() {
        return new InvoiceExistsRequest();
    }

    /**
     * Create an instance of {@link GetInvoiceByNumberRequest }
     * 
     */
    public GetInvoiceByNumberRequest createGetInvoiceByNumberRequest() {
        return new GetInvoiceByNumberRequest();
    }

    /**
     * Create an instance of {@link InvoicesCountRequest }
     * 
     */
    public InvoicesCountRequest createInvoicesCountRequest() {
        return new InvoicesCountRequest();
    }

    /**
     * Create an instance of {@link InvoiceResponse }
     * 
     */
    public InvoiceResponse createInvoiceResponse() {
        return new InvoiceResponse();
    }

    /**
     * Create an instance of {@link InvoiceExistsResponse }
     * 
     */
    public InvoiceExistsResponse createInvoiceExistsResponse() {
        return new InvoiceExistsResponse();
    }

    /**
     * Create an instance of {@link InvoicesCountResponse }
     * 
     */
    public InvoicesCountResponse createInvoicesCountResponse() {
        return new InvoicesCountResponse();
    }

    /**
     * Create an instance of {@link InvoicesResponse }
     * 
     */
    public InvoicesResponse createInvoicesResponse() {
        return new InvoicesResponse();
    }

    /**
     * Create an instance of {@link EntriesList }
     * 
     */
    public EntriesList createEntriesList() {
        return new EntriesList();
    }

    /**
     * Create an instance of {@link CompanySoap }
     * 
     */
    public CompanySoap createCompanySoap() {
        return new CompanySoap();
    }

    /**
     * Create an instance of {@link InvoiceEntrySoap }
     * 
     */
    public InvoiceEntrySoap createInvoiceEntrySoap() {
        return new InvoiceEntrySoap();
    }

}