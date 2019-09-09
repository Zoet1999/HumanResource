/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author Zoet
 */
@Entity
@Table(name = "account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a")
    , @NamedQuery(name = "Account.findByAccountNo", query = "SELECT a FROM Account a WHERE a.accountNo = :accountNo")
    , @NamedQuery(name = "Account.findByTelNo", query = "SELECT a FROM Account a WHERE a.telNo = :telNo")
    , @NamedQuery(name = "Account.findByName", query = "SELECT a FROM Account a WHERE a.name = :name")
    , @NamedQuery(name = "Account.findByPwd", query = "SELECT a FROM Account a WHERE a.pwd = :pwd")
    , @NamedQuery(name = "Account.findByAuthority", query = "SELECT a FROM Account a WHERE a.authority = :authority")})
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "accountNo")
    private Integer accountNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "telNo")
    private String telNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pwd")
    private String pwd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "authority")
    private String authority;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountaccountNo")
    private Collection<Ecollection> ecollectionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountaccountNo")
    private Collection<Ccollection> ccollectionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountaccountNo")
    private Collection<Operation> operationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountaccountNo")
    private Collection<Notice> noticeCollection;

    public Account() {
        this.authority = "normal";
    }

    public Account(Integer accountNo) {
        this.accountNo = accountNo;
    }

    public Account(Integer accountNo, String telNo, String name, String pwd, String authority) {
        this.accountNo = accountNo;
        this.telNo = telNo;
        this.name = name;
        this.pwd = pwd;
        this.authority = authority;
    }

    public Integer getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Integer accountNo) {
        this.accountNo = accountNo;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @XmlTransient
    public Collection<Ecollection> getEcollectionCollection() {
        return ecollectionCollection;
    }

    public void setEcollectionCollection(Collection<Ecollection> ecollectionCollection) {
        this.ecollectionCollection = ecollectionCollection;
    }

    @XmlTransient
    public Collection<Ccollection> getCcollectionCollection() {
        return ccollectionCollection;
    }

    public void setCcollectionCollection(Collection<Ccollection> ccollectionCollection) {
        this.ccollectionCollection = ccollectionCollection;
    }

    @XmlTransient
    public Collection<Operation> getOperationCollection() {
        return operationCollection;
    }

    public void setOperationCollection(Collection<Operation> operationCollection) {
        this.operationCollection = operationCollection;
    }

    @XmlTransient
    public Collection<Notice> getNoticeCollection() {
        return noticeCollection;
    }

    public void setNoticeCollection(Collection<Notice> noticeCollection) {
        this.noticeCollection = noticeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountNo != null ? accountNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.accountNo == null && other.accountNo != null) || (this.accountNo != null && !this.accountNo.equals(other.accountNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Account[ accountNo=" + accountNo + " ]";
    }
    
}
