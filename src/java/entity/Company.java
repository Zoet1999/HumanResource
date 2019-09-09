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
@Table(name = "company")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c")
    , @NamedQuery(name = "Company.findByCompanyNo", query = "SELECT c FROM Company c WHERE c.companyNo = :companyNo")
    , @NamedQuery(name = "Company.findByCompanyName", query = "SELECT c FROM Company c WHERE c.companyName = :companyName")
    , @NamedQuery(name = "Company.findByAddress", query = "SELECT c FROM Company c WHERE c.address = :address")
    , @NamedQuery(name = "Company.findByRemark", query = "SELECT c FROM Company c WHERE c.remark = :remark")})
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "companyNo")
    private Integer companyNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "companyName")
    private String companyName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "address")
    private String address;
    @Size(max = 200)
    @Column(name = "remark")
    private String remark;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companycompanyNo")
    private Collection<Ccollection> ccollectionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companycompanyNo")
    private Collection<Position> positionCollection;

    public Company() {
        this.address="UnKnown";
        this.remark="UnKnown";
    }

    public Company(Integer companyNo) {
        this.companyNo = companyNo;
    }

    public Company(Integer companyNo, String companyName, String address) {
        this.companyNo = companyNo;
        this.companyName = companyName;
        this.address = address;
    }

    public Integer getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(Integer companyNo) {
        this.companyNo = companyNo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @XmlTransient
    public Collection<Ccollection> getCcollectionCollection() {
        return ccollectionCollection;
    }

    public void setCcollectionCollection(Collection<Ccollection> ccollectionCollection) {
        this.ccollectionCollection = ccollectionCollection;
    }

    @XmlTransient
    public Collection<Position> getPositionCollection() {
        return positionCollection;
    }

    public void setPositionCollection(Collection<Position> positionCollection) {
        this.positionCollection = positionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyNo != null ? companyNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        if ((this.companyNo == null && other.companyNo != null) || (this.companyNo != null && !this.companyNo.equals(other.companyNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Company[ companyNo=" + companyNo + " ]";
    }
    
}
