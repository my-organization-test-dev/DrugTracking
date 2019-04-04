/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "fmhacamanager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fmhacamanager.findAll", query = "SELECT f FROM Fmhacamanager f")
    , @NamedQuery(name = "Fmhacamanager.findByManagerId", query = "SELECT f FROM Fmhacamanager f WHERE f.managerId = :managerId")
    , @NamedQuery(name = "Fmhacamanager.findByFirstName", query = "SELECT f FROM Fmhacamanager f WHERE f.firstName = :firstName")
    , @NamedQuery(name = "Fmhacamanager.findByMiddleName", query = "SELECT f FROM Fmhacamanager f WHERE f.middleName = :middleName")
    , @NamedQuery(name = "Fmhacamanager.findByLastName", query = "SELECT f FROM Fmhacamanager f WHERE f.lastName = :lastName")
    , @NamedQuery(name = "Fmhacamanager.findByRegion", query = "SELECT f FROM Fmhacamanager f WHERE f.region = :region")
    , @NamedQuery(name = "Fmhacamanager.findByCity", query = "SELECT f FROM Fmhacamanager f WHERE f.city = :city")
    , @NamedQuery(name = "Fmhacamanager.findByKebele", query = "SELECT f FROM Fmhacamanager f WHERE f.kebele = :kebele")
    , @NamedQuery(name = "Fmhacamanager.findByStatus", query = "SELECT f FROM Fmhacamanager f WHERE f.status = :status")})
public class Fmhacamanager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "manager_id")
    private String managerId;
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

    public Fmhacamanager() {
    }

    public Fmhacamanager(String managerId) {
        this.managerId = managerId;
    }

    public Fmhacamanager(String managerId, String firstName, String middleName, String lastName, String region, String city, String kebele, String status) {
        this.managerId = managerId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.region = region;
        this.city = city;
        this.kebele = kebele;
        this.status = status;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (managerId != null ? managerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fmhacamanager)) {
            return false;
        }
        Fmhacamanager other = (Fmhacamanager) object;
        if ((this.managerId == null && other.managerId != null) || (this.managerId != null && !this.managerId.equals(other.managerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Fmhacamanager[ managerId=" + managerId + " ]";
    }
    
}
