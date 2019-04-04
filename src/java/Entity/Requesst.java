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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "requesst")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requesst.findAll", query = "SELECT r FROM Requesst r")
    , @NamedQuery(name = "Requesst.findById", query = "SELECT r FROM Requesst r WHERE r.id = :id")
    , @NamedQuery(name = "Requesst.findByStatus", query = "SELECT r FROM Requesst r WHERE r.status = :status")})
public class Requesst implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "resiver", referencedColumnName = "org_id")
    @ManyToOne(optional = false)
    private Organization resiver;
    @JoinColumn(name = "sender", referencedColumnName = "org_id")
    @ManyToOne(optional = false)
    private Organization sender;
    @JoinColumn(name = "drugId", referencedColumnName = "drug_id")
    @ManyToOne(optional = false)
    private Drug drugId;

    public Requesst() {
    }

    public Requesst(Integer id) {
        this.id = id;
    }

    public Requesst(Integer id, String status) {
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Organization getResiver() {
        return resiver;
    }

    public void setResiver(Organization resiver) {
        this.resiver = resiver;
    }

    public Organization getSender() {
        return sender;
    }

    public void setSender(Organization sender) {
        this.sender = sender;
    }

    public Drug getDrugId() {
        return drugId;
    }

    public void setDrugId(Drug drugId) {
        this.drugId = drugId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requesst)) {
            return false;
        }
        Requesst other = (Requesst) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Requesst[ id=" + id + " ]";
    }
    
}
