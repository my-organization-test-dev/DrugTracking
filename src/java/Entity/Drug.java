/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "drug")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Drug.findAll", query = "SELECT d FROM Drug d")
    , @NamedQuery(name = "Drug.findByDrugId", query = "SELECT d FROM Drug d WHERE d.drugId = :drugId")
    , @NamedQuery(name = "Drug.findByDrugIdDactive", query = "UPDATE Drug d SET d.status='deactive'  WHERE d.drugId = :drugId")
    , @NamedQuery(name = "Drug.findByBatchNumber", query = "SELECT d FROM Drug d WHERE d.batchNumber = :batchNumber")
    , @NamedQuery(name = "Drug.findByBrandName", query = "SELECT d FROM Drug d WHERE d.brandName = :brandName")
    , @NamedQuery(name = "Drug.findByGenericName", query = "SELECT d FROM Drug d WHERE d.genericName = :genericName")
    , @NamedQuery(name = "Drug.findByTGroup", query = "SELECT d FROM Drug d WHERE d.tGroup = :tGroup")
    , @NamedQuery(name = "Drug.findBySubTGroup", query = "SELECT d FROM Drug d WHERE d.subTGroup = :subTGroup")
    , @NamedQuery(name = "Drug.findByManufacturer", query = "SELECT d FROM Drug d WHERE d.manufacturer = :manufacturer")
    , @NamedQuery(name = "Drug.findByCountryOfOrgin", query = "SELECT d FROM Drug d WHERE d.countryOfOrgin = :countryOfOrgin")
    , @NamedQuery(name = "Drug.findByRegisterDate", query = "SELECT d FROM Drug d WHERE d.registerDate = :registerDate")
    , @NamedQuery(name = "Drug.findByExpirDate", query = "SELECT d FROM Drug d WHERE d.expirDate = :expirDate")
    , @NamedQuery(name = "Drug.findByAmount", query = "SELECT a.amount FROM Drug a WHERE a.drugId=:drugId")
    , @NamedQuery(name = "Drug.findByDosageForm", query = "SELECT d FROM Drug d WHERE d.dosageForm = :dosageForm")
    , @NamedQuery(name = "Drug.findByStrength", query = "SELECT d FROM Drug d WHERE d.strength = :strength")
    , @NamedQuery(name = "Drug.findByStatus", query = "SELECT d FROM Drug d WHERE d.status = :status")
     , @NamedQuery(name = "Drug.findDrugIdToCast", query = "SELECT a.drugId FROM Drug a WHERE a.drugId=:drugId")
   , @NamedQuery(name = "Drug.findOldOwner", query = "    SELECT a.cuerntOwner FROM Drug a WHERE a.drugId=:drugId")})
public class Drug implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "drug_id")
    private Integer drugId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "batchNumber")
    private String batchNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "brandName")
    private String brandName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "genericName")
    private String genericName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "TGroup")
    private String tGroup;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "subTGroup")
    private String subTGroup;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "manufacturer")
    private String manufacturer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "countryOfOrgin")
    private String countryOfOrgin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "registerDate")
    @Temporal(TemporalType.DATE)
    private Date registerDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expirDate")
    @Temporal(TemporalType.DATE)
    private Date expirDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private float amount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "dosageForm")
    private String dosageForm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "strength")
    private String strength;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "drugInfo")
    private String drugInfo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "status")
    private String status;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "drugId")
//    private Collection<Tranizaction> tranizactionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "drugId")
    private Collection<Requesst> requesstCollection;
    @JoinColumn(name = "cuernt_owner", referencedColumnName = "org_id")
    @ManyToOne(optional = false)
    private Organization cuerntOwner;

    public Drug() {
    }

    public Drug(Integer drugId) {
        this.drugId = drugId;
    }

    public Drug(Integer drugId, String batchNumber, String brandName, String genericName, String tGroup, String subTGroup, String manufacturer, String countryOfOrgin, Date registerDate, Date expirDate, float amount, String dosageForm, String strength, String drugInfo, String status) {
        this.drugId = drugId;
        this.batchNumber = batchNumber;
        this.brandName = brandName;
        this.genericName = genericName;
        this.tGroup = tGroup;
        this.subTGroup = subTGroup;
        this.manufacturer = manufacturer;
        this.countryOfOrgin = countryOfOrgin;
        this.registerDate = registerDate;
        this.expirDate = expirDate;
        this.amount = amount;
        this.dosageForm = dosageForm;
        this.strength = strength;
        this.drugInfo = drugInfo;
        this.status = status;
    }

    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
        this.drugId = drugId;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public String getTGroup() {
        return tGroup;
    }

    public void setTGroup(String tGroup) {
        this.tGroup = tGroup;
    }

    public String getSubTGroup() {
        return subTGroup;
    }

    public void setSubTGroup(String subTGroup) {
        this.subTGroup = subTGroup;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCountryOfOrgin() {
        return countryOfOrgin;
    }

    public void setCountryOfOrgin(String countryOfOrgin) {
        this.countryOfOrgin = countryOfOrgin;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getExpirDate() {
        return expirDate;
    }

    public void setExpirDate(Date expirDate) {
        this.expirDate = expirDate;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getDosageForm() {
        return dosageForm;
    }

    public void setDosageForm(String dosageForm) {
        this.dosageForm = dosageForm;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getDrugInfo() {
        return drugInfo;
    }

    public void setDrugInfo(String drugInfo) {
        this.drugInfo = drugInfo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    @XmlTransient
//    public Collection<Tranizaction> getTranizactionCollection() {
//        return tranizactionCollection;
//    }
//
//    public void setTranizactionCollection(Collection<Tranizaction> tranizactionCollection) {
//        this.tranizactionCollection = tranizactionCollection;
//    }

    @XmlTransient
    public Collection<Requesst> getRequesstCollection() {
        return requesstCollection;
    }

    public void setRequesstCollection(Collection<Requesst> requesstCollection) {
        this.requesstCollection = requesstCollection;
    }

    public Organization getCuerntOwner() {
        return cuerntOwner;
    }

    public void setCuerntOwner(Organization cuerntOwner) {
        this.cuerntOwner = cuerntOwner;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (drugId != null ? drugId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Drug)) {
            return false;
        }
        Drug other = (Drug) object;
        if ((this.drugId == null && other.drugId != null) || (this.drugId != null && !this.drugId.equals(other.drugId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Drug[ drugId=" + drugId + " ]";
    }
    
}
