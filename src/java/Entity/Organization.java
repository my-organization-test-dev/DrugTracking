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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "organization")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Organization.findAll", query = "SELECT o FROM Organization o")
    , @NamedQuery(name = "Organization.findByOrgId", query = "SELECT o FROM Organization o WHERE o.orgId = :orgId")
    , @NamedQuery(name = "Organization.findByOrgName", query = "SELECT o FROM Organization o WHERE o.orgName = :orgName")
    , @NamedQuery(name = "Organization.findByRegion", query = "SELECT o FROM Organization o WHERE o.region = :region")
    , @NamedQuery(name = "Organization.findByCity", query = "SELECT o FROM Organization o WHERE o.city = :city")
    , @NamedQuery(name = "Organization.findByKebele", query = "SELECT o FROM Organization o WHERE o.kebele = :kebele")
    , @NamedQuery(name = "Organization.findByHealthProfessionalName", query = "SELECT o FROM Organization o WHERE o.healthProfessionalName = :healthProfessionalName")
    , @NamedQuery(name = "Organization.findByRegisterDate", query = "SELECT o FROM Organization o WHERE o.registerDate = :registerDate")
    , @NamedQuery(name = "Organization.findByTypeOgOrganzation", query = "SELECT o FROM Organization o WHERE o.typeOgOrganzation = :typeOgOrganzation")
    , @NamedQuery(name = "Organization.findByLevel", query = "SELECT o FROM Organization o WHERE o.level = :level")
    , @NamedQuery(name = "Organization.findByStatus", query = "SELECT o FROM Organization o WHERE o.status = :status")})
public class Organization implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "org_id")
    private String orgId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "org_name")
    private String orgName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "region")
    private String region;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "kebele")
    private String kebele;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "healthProfessionalName")
    private String healthProfessionalName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "registerDate")
    @Temporal(TemporalType.DATE)
    private Date registerDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "typeOgOrganzation")
    private String typeOgOrganzation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "level")
    private String level;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "owner", referencedColumnName = "owner_id")
    @ManyToOne(optional = false)
    private Owner owner;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bayer")
    private Collection<Tranizaction> tranizactionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seller")
    private Collection<Tranizaction> tranizactionCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resiver")
    private Collection<Requesst> requesstCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sender")
    private Collection<Requesst> requesstCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organization")
    private Collection<Employee> employeeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuerntOwner")
    private Collection<Drug> drugCollection;

    public Organization() {
    }

    public Organization(String orgId) {
        this.orgId = orgId;
    }

    public Organization(String orgId, String orgName, String region, String city, String kebele, String healthProfessionalName, Date registerDate, String typeOgOrganzation, String level, String status) {
        this.orgId = orgId;
        this.orgName = orgName;
        this.region = region;
        this.city = city;
        this.kebele = kebele;
        this.healthProfessionalName = healthProfessionalName;
        this.registerDate = registerDate;
        this.typeOgOrganzation = typeOgOrganzation;
        this.level = level;
        this.status = status;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getKebele() {
        return kebele;
    }

    public void setKebele(String kebele) {
        this.kebele = kebele;
    }

    public String getHealthProfessionalName() {
        return healthProfessionalName;
    }

    public void setHealthProfessionalName(String healthProfessionalName) {
        this.healthProfessionalName = healthProfessionalName;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getTypeOgOrganzation() {
        return typeOgOrganzation;
    }

    public void setTypeOgOrganzation(String typeOgOrganzation) {
        this.typeOgOrganzation = typeOgOrganzation;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @XmlTransient
    public Collection<Tranizaction> getTranizactionCollection() {
        return tranizactionCollection;
    }

    public void setTranizactionCollection(Collection<Tranizaction> tranizactionCollection) {
        this.tranizactionCollection = tranizactionCollection;
    }

    @XmlTransient
    public Collection<Tranizaction> getTranizactionCollection1() {
        return tranizactionCollection1;
    }

    public void setTranizactionCollection1(Collection<Tranizaction> tranizactionCollection1) {
        this.tranizactionCollection1 = tranizactionCollection1;
    }

    @XmlTransient
    public Collection<Requesst> getRequesstCollection() {
        return requesstCollection;
    }

    public void setRequesstCollection(Collection<Requesst> requesstCollection) {
        this.requesstCollection = requesstCollection;
    }

    @XmlTransient
    public Collection<Requesst> getRequesstCollection1() {
        return requesstCollection1;
    }

    public void setRequesstCollection1(Collection<Requesst> requesstCollection1) {
        this.requesstCollection1 = requesstCollection1;
    }

    @XmlTransient
    public Collection<Employee> getEmployeeCollection() {
        return employeeCollection;
    }

    public void setEmployeeCollection(Collection<Employee> employeeCollection) {
        this.employeeCollection = employeeCollection;
    }

    @XmlTransient
    public Collection<Drug> getDrugCollection() {
        return drugCollection;
    }

    public void setDrugCollection(Collection<Drug> drugCollection) {
        this.drugCollection = drugCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orgId != null ? orgId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Organization)) {
            return false;
        }
        Organization other = (Organization) object;
        if ((this.orgId == null && other.orgId != null) || (this.orgId != null && !this.orgId.equals(other.orgId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Organization[ orgId=" + orgId + " ]";
    }
    
}
