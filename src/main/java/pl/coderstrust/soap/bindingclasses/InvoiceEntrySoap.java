//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.08.17 at 09:23:33 PM CEST 
//


package pl.coderstrust.soap.bindingclasses;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
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
 * <p>Java class for invoiceEntrySoap complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="invoiceEntrySoap"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="netValue" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="grossValue" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="vatRate" type="{http://project-13-zuzanna-radek-mateusz-radek-przemek}vatSoap"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "invoiceEntrySoap", propOrder = {
    "id",
    "description",
    "quantity",
    "price",
    "netValue",
    "grossValue",
    "vatRate"
})
public class InvoiceEntrySoap
    implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    protected long id;
    @XmlElement(required = true)
    protected String description;
    protected long quantity;
    @XmlElement(required = true)
    protected BigDecimal price;
    @XmlElement(required = true)
    protected BigDecimal netValue;
    @XmlElement(required = true)
    protected BigDecimal grossValue;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected VatSoap vatRate;

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     */
    public long getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     */
    public void setQuantity(long value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrice(BigDecimal value) {
        this.price = value;
    }

    /**
     * Gets the value of the netValue property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNetValue() {
        return netValue;
    }

    /**
     * Sets the value of the netValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNetValue(BigDecimal value) {
        this.netValue = value;
    }

    /**
     * Gets the value of the grossValue property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getGrossValue() {
        return grossValue;
    }

    /**
     * Sets the value of the grossValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setGrossValue(BigDecimal value) {
        this.grossValue = value;
    }

    /**
     * Gets the value of the vatRate property.
     * 
     * @return
     *     possible object is
     *     {@link VatSoap }
     *     
     */
    public VatSoap getVatRate() {
        return vatRate;
    }

    /**
     * Sets the value of the vatRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link VatSoap }
     *     
     */
    public void setVatRate(VatSoap value) {
        this.vatRate = value;
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
            long theId;
            theId = (true?this.getId(): 0L);
            strategy.appendField(locator, this, "id", buffer, theId);
        }
        {
            String theDescription;
            theDescription = this.getDescription();
            strategy.appendField(locator, this, "description", buffer, theDescription);
        }
        {
            long theQuantity;
            theQuantity = (true?this.getQuantity(): 0L);
            strategy.appendField(locator, this, "quantity", buffer, theQuantity);
        }
        {
            BigDecimal thePrice;
            thePrice = this.getPrice();
            strategy.appendField(locator, this, "price", buffer, thePrice);
        }
        {
            BigDecimal theNetValue;
            theNetValue = this.getNetValue();
            strategy.appendField(locator, this, "netValue", buffer, theNetValue);
        }
        {
            BigDecimal theGrossValue;
            theGrossValue = this.getGrossValue();
            strategy.appendField(locator, this, "grossValue", buffer, theGrossValue);
        }
        {
            VatSoap theVatRate;
            theVatRate = this.getVatRate();
            strategy.appendField(locator, this, "vatRate", buffer, theVatRate);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof InvoiceEntrySoap)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final InvoiceEntrySoap that = ((InvoiceEntrySoap) object);
        {
            long lhsId;
            lhsId = (true?this.getId(): 0L);
            long rhsId;
            rhsId = (true?that.getId(): 0L);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "id", lhsId), LocatorUtils.property(thatLocator, "id", rhsId), lhsId, rhsId)) {
                return false;
            }
        }
        {
            String lhsDescription;
            lhsDescription = this.getDescription();
            String rhsDescription;
            rhsDescription = that.getDescription();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "description", lhsDescription), LocatorUtils.property(thatLocator, "description", rhsDescription), lhsDescription, rhsDescription)) {
                return false;
            }
        }
        {
            long lhsQuantity;
            lhsQuantity = (true?this.getQuantity(): 0L);
            long rhsQuantity;
            rhsQuantity = (true?that.getQuantity(): 0L);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "quantity", lhsQuantity), LocatorUtils.property(thatLocator, "quantity", rhsQuantity), lhsQuantity, rhsQuantity)) {
                return false;
            }
        }
        {
            BigDecimal lhsPrice;
            lhsPrice = this.getPrice();
            BigDecimal rhsPrice;
            rhsPrice = that.getPrice();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "price", lhsPrice), LocatorUtils.property(thatLocator, "price", rhsPrice), lhsPrice, rhsPrice)) {
                return false;
            }
        }
        {
            BigDecimal lhsNetValue;
            lhsNetValue = this.getNetValue();
            BigDecimal rhsNetValue;
            rhsNetValue = that.getNetValue();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "netValue", lhsNetValue), LocatorUtils.property(thatLocator, "netValue", rhsNetValue), lhsNetValue, rhsNetValue)) {
                return false;
            }
        }
        {
            BigDecimal lhsGrossValue;
            lhsGrossValue = this.getGrossValue();
            BigDecimal rhsGrossValue;
            rhsGrossValue = that.getGrossValue();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "grossValue", lhsGrossValue), LocatorUtils.property(thatLocator, "grossValue", rhsGrossValue), lhsGrossValue, rhsGrossValue)) {
                return false;
            }
        }
        {
            VatSoap lhsVatRate;
            lhsVatRate = this.getVatRate();
            VatSoap rhsVatRate;
            rhsVatRate = that.getVatRate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "vatRate", lhsVatRate), LocatorUtils.property(thatLocator, "vatRate", rhsVatRate), lhsVatRate, rhsVatRate)) {
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
            long theId;
            theId = (true?this.getId(): 0L);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "id", theId), currentHashCode, theId);
        }
        {
            String theDescription;
            theDescription = this.getDescription();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "description", theDescription), currentHashCode, theDescription);
        }
        {
            long theQuantity;
            theQuantity = (true?this.getQuantity(): 0L);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "quantity", theQuantity), currentHashCode, theQuantity);
        }
        {
            BigDecimal thePrice;
            thePrice = this.getPrice();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "price", thePrice), currentHashCode, thePrice);
        }
        {
            BigDecimal theNetValue;
            theNetValue = this.getNetValue();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "netValue", theNetValue), currentHashCode, theNetValue);
        }
        {
            BigDecimal theGrossValue;
            theGrossValue = this.getGrossValue();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "grossValue", theGrossValue), currentHashCode, theGrossValue);
        }
        {
            VatSoap theVatRate;
            theVatRate = this.getVatRate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "vatRate", theVatRate), currentHashCode, theVatRate);
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
        if (draftCopy instanceof InvoiceEntrySoap) {
            final InvoiceEntrySoap copy = ((InvoiceEntrySoap) draftCopy);
            long sourceId;
            sourceId = (true?this.getId(): 0L);
            long copyId = strategy.copy(LocatorUtils.property(locator, "id", sourceId), sourceId);
            copy.setId(copyId);
            if (this.description!= null) {
                String sourceDescription;
                sourceDescription = this.getDescription();
                String copyDescription = ((String) strategy.copy(LocatorUtils.property(locator, "description", sourceDescription), sourceDescription));
                copy.setDescription(copyDescription);
            } else {
                copy.description = null;
            }
            long sourceQuantity;
            sourceQuantity = (true?this.getQuantity(): 0L);
            long copyQuantity = strategy.copy(LocatorUtils.property(locator, "quantity", sourceQuantity), sourceQuantity);
            copy.setQuantity(copyQuantity);
            if (this.price!= null) {
                BigDecimal sourcePrice;
                sourcePrice = this.getPrice();
                BigDecimal copyPrice = ((BigDecimal) strategy.copy(LocatorUtils.property(locator, "price", sourcePrice), sourcePrice));
                copy.setPrice(copyPrice);
            } else {
                copy.price = null;
            }
            if (this.netValue!= null) {
                BigDecimal sourceNetValue;
                sourceNetValue = this.getNetValue();
                BigDecimal copyNetValue = ((BigDecimal) strategy.copy(LocatorUtils.property(locator, "netValue", sourceNetValue), sourceNetValue));
                copy.setNetValue(copyNetValue);
            } else {
                copy.netValue = null;
            }
            if (this.grossValue!= null) {
                BigDecimal sourceGrossValue;
                sourceGrossValue = this.getGrossValue();
                BigDecimal copyGrossValue = ((BigDecimal) strategy.copy(LocatorUtils.property(locator, "grossValue", sourceGrossValue), sourceGrossValue));
                copy.setGrossValue(copyGrossValue);
            } else {
                copy.grossValue = null;
            }
            if (this.vatRate!= null) {
                VatSoap sourceVatRate;
                sourceVatRate = this.getVatRate();
                VatSoap copyVatRate = ((VatSoap) strategy.copy(LocatorUtils.property(locator, "vatRate", sourceVatRate), sourceVatRate));
                copy.setVatRate(copyVatRate);
            } else {
                copy.vatRate = null;
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new InvoiceEntrySoap();
    }

}
