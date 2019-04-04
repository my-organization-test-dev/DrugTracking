/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "owner")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Owner_1.findAll", query = "SELECT o FROM Owner_1 o")
    , @NamedQuery(name = "Owner_1.findByOwnerId", query = "SELECT o FROM Owner_1 o WHERE o.ownerId = :ownerId")
    , @NamedQuery(name = "Owner_1.findByFirstName", query = "SELECT o FROM Owner_1 o WHERE o.firstName = :firstName")
    , @NamedQuery(name = "Owner_1.findByMiddleName", query = "SELECT o FROM Owner_1 o WHERE o.middleName = :middleName")
    , @NamedQuery(name = "Owner_1.findByLastName", query = "SELECT o FROM Owner_1 o WHERE o.lastName = :lastName")
    , @NamedQuery(name = "Owner_1.findByRegion", query = "SELECT o FROM Owner_1 o WHERE o.region = :region")
    , @NamedQuery(name = "Owner_1.findByCity", query = "SELECT o FROM Owner_1 o WHERE o.city = :city")
    , @NamedQuery(name = "Owner_1.findByKebele", query = "SELECT o FROM Owner_1 o WHERE o.kebele = :kebele")
    , @NamedQuery(name = "Owner_1.findByStatus", query = "SELECT o FROM Owner_1 o WHERE o.status = :status")})
public class Owner_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "owner_id")
    private String ownerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "middle_name")
    private String middleName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "last_name")
    private String lastName;
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
    @Size(min = 1, max = 10)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Collection<Organization> organizationCollection;

    public Owner_1() {
    }

    public Owner_1(String ownerId) {
        this.ownerId = ownerId;
    }

    public Owner_1(String ownerId, String firstName, String middleName, String lastName, String region, String city, String kebele, String status) {
        this.ownerId = ownerId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.region = region;
        this.city = city;
        this.kebele = kebele;
        this.status = status;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Organization> getOrganizationCollection() {
        return organizationCollection;
    }

    public void setOrganizationCollection(Collection<Organization> organizationCollection) {
        this.organizationCollection = organizationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ownerId != null ? ownerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Owner_1)) {
            return false;
        }
        Owner_1 other = (Owner_1) object;
        if ((this.ownerId == null && other.ownerId != null) || (this.ownerId != null && !this.ownerId.equals(other.ownerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Owner_1[ ownerId=" + ownerId + " ]";
    }
    
}
