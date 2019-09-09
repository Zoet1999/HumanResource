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
@Table(name = "staff")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Staff.findAll", query = "SELECT s FROM Staff s")
    , @NamedQuery(name = "Staff.findByStaffNo", query = "SELECT s FROM Staff s WHERE s.staffNo = :staffNo")
    , @NamedQuery(name = "Staff.findByName", query = "SELECT s FROM Staff s WHERE s.name = :name")
    , @NamedQuery(name = "Staff.findBySex", query = "SELECT s FROM Staff s WHERE s.sex = :sex")
    , @NamedQuery(name = "Staff.findByAge", query = "SELECT s FROM Staff s WHERE s.age = :age")
    , @NamedQuery(name = "Staff.findByAddress", query = "SELECT s FROM Staff s WHERE s.address = :address")
    , @NamedQuery(name = "Staff.findByTel", query = "SELECT s FROM Staff s WHERE s.tel = :tel")
    , @NamedQuery(name = "Staff.findByMail", query = "SELECT s FROM Staff s WHERE s.mail = :mail")
    , @NamedQuery(name = "Staff.findByWorkingYears", query = "SELECT s FROM Staff s WHERE s.workingYears = :workingYears")})
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "staffNo")
    private Integer staffNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sex")
    private String sex;
    @Basic(optional = false)
    @NotNull
    @Column(name = "age")
    private int age;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "address")
    private String address;
    @Size(max = 11)
    @Column(name = "tel")
    private String tel;
    @Size(max = 45)
    @Column(name = "mail")
    private String mail;
    @Size(max = 45)
    @Column(name = "workingYears")
    private String workingYears;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "staffstaffNo")
    private Collection<Ecollection> ecollectionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "staffstaffNo")
    private Collection<Experience> experienceCollection;

    public Staff() {
    }

    public Staff(Integer staffNo) {
        this.staffNo = staffNo;
    }

    public Staff(Integer staffNo, String name, String sex, int age, String address) {
        this.staffNo = staffNo;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.address = address;
    }

    public Integer getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(Integer staffNo) {
        this.staffNo = staffNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getWorkingYears() {
        return workingYears;
    }

    public void setWorkingYears(String workingYears) {
        this.workingYears = workingYears;
    }

    @XmlTransient
    public Collection<Ecollection> getEcollectionCollection() {
        return ecollectionCollection;
    }

    public void setEcollectionCollection(Collection<Ecollection> ecollectionCollection) {
        this.ecollectionCollection = ecollectionCollection;
    }

    @XmlTransient
    public Collection<Experience> getExperienceCollection() {
        return experienceCollection;
    }

    public void setExperienceCollection(Collection<Experience> experienceCollection) {
        this.experienceCollection = experienceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (staffNo != null ? staffNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Staff)) {
            return false;
        }
        Staff other = (Staff) object;
        if ((this.staffNo == null && other.staffNo != null) || (this.staffNo != null && !this.staffNo.equals(other.staffNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Staff[ staffNo=" + staffNo + " ]";
    }
    
}
