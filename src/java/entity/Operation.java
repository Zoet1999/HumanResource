/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zoet
 */
@Entity
@Table(name = "operation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operation.findAll", query = "SELECT o FROM Operation o")
    , @NamedQuery(name = "Operation.findByOptNo", query = "SELECT o FROM Operation o WHERE o.optNo = :optNo")
    , @NamedQuery(name = "Operation.findByOptType", query = "SELECT o FROM Operation o WHERE o.optType = :optType")
    , @NamedQuery(name = "Operation.findByOptTime", query = "SELECT o FROM Operation o WHERE o.optTime = :optTime")
    , @NamedQuery(name = "Operation.findByOptContent", query = "SELECT o FROM Operation o WHERE o.optContent = :optContent")})
public class Operation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "optNo")
    private Integer optNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "optType")
    private String optType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "optTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date optTime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "optContent")
    private String optContent;
    @JoinColumn(name = "account_accountNo", referencedColumnName = "accountNo")
    @ManyToOne(optional = false)
    private Account accountaccountNo;

    public Operation() {
    }

    public Operation(Integer optNo) {
        this.optNo = optNo;
    }

    public Operation(Integer optNo, String optType, Date optTime, String optContent) {
        this.optNo = optNo;
        this.optType = optType;
        this.optTime = optTime;
        this.optContent = optContent;
    }

    public Integer getOptNo() {
        return optNo;
    }

    public void setOptNo(Integer optNo) {
        this.optNo = optNo;
    }

    public String getOptType() {
        return optType;
    }

    public void setOptType(String optType) {
        this.optType = optType;
    }

    public Date getOptTime() {
        return optTime;
    }

    public void setOptTime(Date optTime) {
        this.optTime = optTime;
    }

    public String getOptContent() {
        return optContent;
    }

    public void setOptContent(String optContent) {
        this.optContent = optContent;
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
        hash += (optNo != null ? optNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operation)) {
            return false;
        }
        Operation other = (Operation) object;
        if ((this.optNo == null && other.optNo != null) || (this.optNo != null && !this.optNo.equals(other.optNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Operation[ optNo=" + optNo + " ]";
    }
    
}
