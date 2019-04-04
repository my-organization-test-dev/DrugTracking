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
@Table(name = "tranizaction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tranizaction.findAll", query = "SELECT t FROM Tranizaction t")
    , @NamedQuery(name = "Tranizaction.findByNo", query = "SELECT t FROM Tranizaction t WHERE t.no = :no")
    , @NamedQuery(name = "Tranizaction.findByDrugId", query = "SELECT t FROM Tranizaction t WHERE t.drugId = :drugId")
    , @NamedQuery(name = "Tranizaction.findByBatchNo", query = "SELECT t FROM Tranizaction t WHERE t.batchNo = :batchNo")
    , @NamedQuery(name = "Tranizaction.findByAmount", query = "SELECT t FROM Tranizaction t WHERE t.amount = :amount")
    , @NamedQuery(name = "Tranizaction.findByStatus", query = "SELECT t FROM Tranizaction t WHERE t.status = :status")})
public class Tranizaction implements Serializable {

    @JoinColumn(name = "seller", referencedColumnName = "org_id")
    @ManyToOne(optional = false)
    private Organization seller;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "no")
    private Integer no;
    @Basic(optional = false)
    @NotNull
    @Column(name = "drug_id")
    private int drugId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "batch_no")
    private String batchNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private float amount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "bayer", referencedColumnName = "org_id")
    @ManyToOne(optional = false)
    private Organization bayer;

    public Tranizaction() {
    }

    public Tranizaction(Integer no) {
        this.no = no;
    }

    public Tranizaction(Integer no, int drugId, String batchNo, float amount, String status) {
        this.no = no;
        this.drugId = drugId;
        this.batchNo = batchNo;
        this.amount = amount;
        this.status = status;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public int getDrugId() {
        return drugId;
    }

    public void setDrugId(int drugId) {
        this.drugId = drugId;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Organization getBayer() {
        return bayer;
    }

    public void setBayer(Organization bayer) {
        this.bayer = bayer;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (no != null ? no.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tranizaction)) {
            return false;
        }
        Tranizaction other = (Tranizaction) object;
        if ((this.no == null && other.no != null) || (this.no != null && !this.no.equals(other.no))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Tranizaction[ no=" + no + " ]";
    }

    public Organization getSeller() {
        return seller;
    }

    public void setSeller(Organization seller) {
        this.seller = seller;
    }
    
}
