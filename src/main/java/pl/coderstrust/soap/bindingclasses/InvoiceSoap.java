//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.08.23 at 11:22:32 PM CEST 
//


package pl.coderstrust.soap.bindingclasses;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import org.jvnet.jaxb2_commons.lang.CopyStrategy;
import org.jvnet.jaxb2_commons.lang.CopyTo;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBCopyStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * <p>Java class for invoiceSoap complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="invoiceSoap"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0" form="qualified"/&gt;
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="issuedDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="dueDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="seller" type="{http://project-13-zuzanna-radek-mateusz-radek-przemek}companySoap"/&gt;
 *         &lt;element name="buyer" type="{http://project-13-zuzanna-radek-mateusz-radek-przemek}companySoap"/&gt;
 *         &lt;element name="entries" type="{http://project-13-zuzanna-radek-mateusz-radek-przemek}entriesList"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "invoiceSoap", propOrder = {
    "id",
    "number",
    "issuedDate",
    "dueDate",
    "seller",
    "buyer",
    "entries"
})
public class InvoiceSoap
    implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    @XmlElementRef(name = "id", namespace = "http://project-13-zuzanna-radek-mateusz-radek-przemek", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> id;
    @XmlElement(required = true)
    protected String number;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar issuedDate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dueDate;
    @XmlElement(required = true)
    protected CompanySoap seller;
    @XmlElement(required = true)
    protected CompanySoap buyer;
    @XmlElement(required = true)
    protected EntriesList entries;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setId(JAXBElement<Long> value) {
        this.id = value;
    }

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumber(String value) {
        this.number = value;
    }

    /**
     * Gets the value of the issuedDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getIssuedDate() {
        return issuedDate;
    }

    /**
     * Sets the value of the issuedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setIssuedDate(XMLGregorianCalendar value) {
        this.issuedDate = value;
    }

    /**
     * Gets the value of the dueDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDueDate() {
        return dueDate;
    }

    /**
     * Sets the value of the dueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDueDate(XMLGregorianCalendar value) {
        this.dueDate = value;
    }

    /**
     * Gets the value of the seller property.
     * 
     * @return
     *     possible object is
     *     {@link CompanySoap }
     *     
     */
    public CompanySoap getSeller() {
        return seller;
    }

    /**
     * Sets the value of the seller property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanySoap }
     *     
     */
    public void setSeller(CompanySoap value) {
        this.seller = value;
    }

    /**
     * Gets the value of the buyer property.
     * 
     * @return
     *     possible object is
     *     {@link CompanySoap }
     *     
     */
    public CompanySoap getBuyer() {
        return buyer;
    }

    /**
     * Sets the value of the buyer property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanySoap }
     *     
     */
    public void setBuyer(CompanySoap value) {
        this.buyer = value;
    }

    /**
     * Gets the value of the entries property.
     * 
     * @return
     *     possible object is
     *     {@link EntriesList }
     *     
     */
    public EntriesList getEntries() {
        return entries;
    }

    /**
     * Sets the value of the entries property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntriesList }
     *     
     */
    public void setEntries(EntriesList value) {
        this.entries = value;
    }

    public String toString() {
        final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        {
            JAXBElement<Long> theId;
            theId = this.getId();
            strategy.appendField(locator, this, "id", buffer, theId);
        }
        {
            String theNumber;
            theNumber = this.getNumber();
            strategy.appendField(locator, this, "number", buffer, theNumber);
        }
        {
            XMLGregorianCalendar theIssuedDate;
            theIssuedDate = this.getIssuedDate();
            strategy.appendField(locator, this, "issuedDate", buffer, theIssuedDate);
        }
        {
            XMLGregorianCalendar theDueDate;
            theDueDate = this.getDueDate();
            strategy.appendField(locator, this, "dueDate", buffer, theDueDate);
        }
        {
            CompanySoap theSeller;
            theSeller = this.getSeller();
            strategy.appendField(locator, this, "seller", buffer, theSeller);
        }
        {
            CompanySoap theBuyer;
            theBuyer = this.getBuyer();
            strategy.appendField(locator, this, "buyer", buffer, theBuyer);
        }
        {
            EntriesList theEntries;
            theEntries = this.getEntries();
            strategy.appendField(locator, this, "entries", buffer, theEntries);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof InvoiceSoap)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final InvoiceSoap that = ((InvoiceSoap) object);
        {
            JAXBElement<Long> lhsId;
            lhsId = this.getId();
            JAXBElement<Long> rhsId;
            rhsId = that.getId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "id", lhsId), LocatorUtils.property(thatLocator, "id", rhsId), lhsId, rhsId)) {
                return false;
            }
        }
        {
            String lhsNumber;
            lhsNumber = this.getNumber();
            String rhsNumber;
            rhsNumber = that.getNumber();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "number", lhsNumber), LocatorUtils.property(thatLocator, "number", rhsNumber), lhsNumber, rhsNumber)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsIssuedDate;
            lhsIssuedDate = this.getIssuedDate();
            XMLGregorianCalendar rhsIssuedDate;
            rhsIssuedDate = that.getIssuedDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "issuedDate", lhsIssuedDate), LocatorUtils.property(thatLocator, "issuedDate", rhsIssuedDate), lhsIssuedDate, rhsIssuedDate)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsDueDate;
            lhsDueDate = this.getDueDate();
            XMLGregorianCalendar rhsDueDate;
            rhsDueDate = that.getDueDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "dueDate", lhsDueDate), LocatorUtils.property(thatLocator, "dueDate", rhsDueDate), lhsDueDate, rhsDueDate)) {
                return false;
            }
        }
        {
            CompanySoap lhsSeller;
            lhsSeller = this.getSeller();
            CompanySoap rhsSeller;
            rhsSeller = that.getSeller();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "seller", lhsSeller), LocatorUtils.property(thatLocator, "seller", rhsSeller), lhsSeller, rhsSeller)) {
                return false;
            }
        }
        {
            CompanySoap lhsBuyer;
            lhsBuyer = this.getBuyer();
            CompanySoap rhsBuyer;
            rhsBuyer = that.getBuyer();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "buyer", lhsBuyer), LocatorUtils.property(thatLocator, "buyer", rhsBuyer), lhsBuyer, rhsBuyer)) {
                return false;
            }
        }
        {
            EntriesList lhsEntries;
            lhsEntries = this.getEntries();
            EntriesList rhsEntries;
            rhsEntries = that.getEntries();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "entries", lhsEntries), LocatorUtils.property(thatLocator, "entries", rhsEntries), lhsEntries, rhsEntries)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            JAXBElement<Long> theId;
            theId = this.getId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "id", theId), currentHashCode, theId);
        }
        {
            String theNumber;
            theNumber = this.getNumber();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "number", theNumber), currentHashCode, theNumber);
        }
        {
            XMLGregorianCalendar theIssuedDate;
            theIssuedDate = this.getIssuedDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "issuedDate", theIssuedDate), currentHashCode, theIssuedDate);
        }
        {
            XMLGregorianCalendar theDueDate;
            theDueDate = this.getDueDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "dueDate", theDueDate), currentHashCode, theDueDate);
        }
        {
            CompanySoap theSeller;
            theSeller = this.getSeller();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "seller", theSeller), currentHashCode, theSeller);
        }
        {
            CompanySoap theBuyer;
            theBuyer = this.getBuyer();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "buyer", theBuyer), currentHashCode, theBuyer);
        }
        {
            EntriesList theEntries;
            theEntries = this.getEntries();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "entries", theEntries), currentHashCode, theEntries);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public Object clone() {
        return copyTo(createNewInstance());
    }

    public Object copyTo(Object target) {
        final CopyStrategy strategy = JAXBCopyStrategy.INSTANCE;
        return copyTo(null, target, strategy);
    }

    public Object copyTo(ObjectLocator locator, Object target, CopyStrategy strategy) {
        final Object draftCopy = ((target == null)?createNewInstance():target);
        if (draftCopy instanceof InvoiceSoap) {
            final InvoiceSoap copy = ((InvoiceSoap) draftCopy);
            if (this.id!= null) {
                JAXBElement<Long> sourceId;
                sourceId = this.getId();
                @SuppressWarnings("unchecked")
                JAXBElement<Long> copyId = ((JAXBElement<Long> ) strategy.copy(LocatorUtils.property(locator, "id", sourceId), sourceId));
                copy.setId(copyId);
            } else {
                copy.id = null;
            }
            if (this.number!= null) {
                String sourceNumber;
                sourceNumber = this.getNumber();
                String copyNumber = ((String) strategy.copy(LocatorUtils.property(locator, "number", sourceNumber), sourceNumber));
                copy.setNumber(copyNumber);
            } else {
                copy.number = null;
            }
            if (this.issuedDate!= null) {
                XMLGregorianCalendar sourceIssuedDate;
                sourceIssuedDate = this.getIssuedDate();
                XMLGregorianCalendar copyIssuedDate = ((XMLGregorianCalendar) strategy.copy(LocatorUtils.property(locator, "issuedDate", sourceIssuedDate), sourceIssuedDate));
                copy.setIssuedDate(copyIssuedDate);
            } else {
                copy.issuedDate = null;
            }
            if (this.dueDate!= null) {
                XMLGregorianCalendar sourceDueDate;
                sourceDueDate = this.getDueDate();
                XMLGregorianCalendar copyDueDate = ((XMLGregorianCalendar) strategy.copy(LocatorUtils.property(locator, "dueDate", sourceDueDate), sourceDueDate));
                copy.setDueDate(copyDueDate);
            } else {
                copy.dueDate = null;
            }
            if (this.seller!= null) {
                CompanySoap sourceSeller;
                sourceSeller = this.getSeller();
                CompanySoap copySeller = ((CompanySoap) strategy.copy(LocatorUtils.property(locator, "seller", sourceSeller), sourceSeller));
                copy.setSeller(copySeller);
            } else {
                copy.seller = null;
            }
            if (this.buyer!= null) {
                CompanySoap sourceBuyer;
                sourceBuyer = this.getBuyer();
                CompanySoap copyBuyer = ((CompanySoap) strategy.copy(LocatorUtils.property(locator, "buyer", sourceBuyer), sourceBuyer));
                copy.setBuyer(copyBuyer);
            } else {
                copy.buyer = null;
            }
            if (this.entries!= null) {
                EntriesList sourceEntries;
                sourceEntries = this.getEntries();
                EntriesList copyEntries = ((EntriesList) strategy.copy(LocatorUtils.property(locator, "entries", sourceEntries), sourceEntries));
                copy.setEntries(copyEntries);
            } else {
                copy.entries = null;
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new InvoiceSoap();
    }

}
