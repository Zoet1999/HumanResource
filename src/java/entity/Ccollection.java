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
@Table(name = "ccollection")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ccollection.findAll", query = "SELECT c FROM Ccollection c")
    , @NamedQuery(name = "Ccollection.findByCollectNo", query = "SELECT c FROM Ccollection c WHERE c.collectNo = :collectNo")
    , @NamedQuery(name = "Ccollection.findByAccountNo", query = "SELECT c FROM Ccollection c WHERE c.accountNo = :accountNo")
    , @NamedQuery(name = "Ccollection.findByCompanyNo", query = "SELECT c FROM Ccollection c WHERE c.companyNo = :companyNo")})
public class Ccollection implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Column(name = "companyNo")
    private int companyNo;
    @JoinColumn(name = "Company_companyNo", referencedColumnName = "companyNo")
    @ManyToOne(optional = false)
    private Company companycompanyNo;
    @JoinColumn(name = "account_accountNo", referencedColumnName = "accountNo")
    @ManyToOne(optional = false)
    private Account accountaccountNo;

    public Ccollection() {
    }

    public Ccollection(Integer collectNo) {
        this.collectNo = collectNo;
    }

    public Ccollection(Integer collectNo, int accountNo, int companyNo) {
        this.collectNo = collectNo;
        this.accountNo = accountNo;
        this.companyNo = companyNo;
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

    public int getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(int companyNo) {
        this.companyNo = companyNo;
    }

    public Company getCompanycompanyNo() {
        return companycompanyNo;
    }

    public void setCompanycompanyNo(Company companycompanyNo) {
        this.companycompanyNo = companycompanyNo;
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
        if (!(object instanceof Ccollection)) {
            return false;
        }
        Ccollection other = (Ccollection) object;
        if ((this.collectNo == null && other.collectNo != null) || (this.collectNo != null && !this.collectNo.equals(other.collectNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Ccollection[ collectNo=" + collectNo + " ]";
    }
    
}
