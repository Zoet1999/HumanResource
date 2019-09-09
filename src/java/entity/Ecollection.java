/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zoet
 */
@Entity
@Table(name = "ecollection")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ecollection.findAll", query = "SELECT e FROM Ecollection e")
    , @NamedQuery(name = "Ecollection.findByCollectNo", query = "SELECT e FROM Ecollection e WHERE e.collectNo = :collectNo")
    , @NamedQuery(name = "Ecollection.findByAccountNo", query = "SELECT e FROM Ecollection e WHERE e.accountNo = :accountNo")
    , @NamedQuery(name = "Ecollection.findByStaffNo", query = "SELECT e FROM Ecollection e WHERE e.staffNo = :staffNo")})
public class Ecollection implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "collectNo")
    private Integer collectNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "accountNo")
    private int accountNo;
    @Column(name = "staffNo")
    private Integer staffNo;
    @JoinColumn(name = "Staff_staffNo", referencedColumnName = "staffNo")
    @ManyToOne(optional = false)
    private Staff staffstaffNo;
    @JoinColumn(name = "account_accountNo", referencedColumnName = "accountNo")
    @ManyToOne(optional = false)
    private Account accountaccountNo;

    public Ecollection() {
    }

    public Ecollection(Integer collectNo) {
        this.collectNo = collectNo;
    }

    public Ecollection(Integer collectNo, int accountNo) {
        this.collectNo = collectNo;
        this.accountNo = accountNo;
    }

    public Integer getCollectNo() {
        return collectNo;
    }

    public void setCollectNo(Integer collectNo) {
        this.collectNo = collectNo;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public Integer getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(Integer staffNo) {
        this.staffNo = staffNo;
    }

    public Staff getStaffstaffNo() {
        return staffstaffNo;
    }

    public void setStaffstaffNo(Staff staffstaffNo) {
        this.staffstaffNo = staffstaffNo;
    }

    public Account getAccountaccountNo() {
        return accountaccountNo;
    }

    public void setAccountaccountNo(Account accountaccountNo) {
        this.accountaccountNo = accountaccountNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (collectNo != null ? collectNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ecollection)) {
            return false;
        }
        Ecollection other = (Ecollection) object;
        if ((this.collectNo == null && other.collectNo != null) || (this.collectNo != null && !this.collectNo.equals(other.collectNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Ecollection[ collectNo=" + collectNo + " ]";
    }
    
}
