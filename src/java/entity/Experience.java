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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zoet
 */
@Entity
@Table(name = "experience")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Experience.findAll", query = "SELECT e FROM Experience e")
    , @NamedQuery(name = "Experience.findByExpNo", query = "SELECT e FROM Experience e WHERE e.expNo = :expNo")
    , @NamedQuery(name = "Experience.findByIniDate", query = "SELECT e FROM Experience e WHERE e.iniDate = :iniDate")
    , @NamedQuery(name = "Experience.findByDepDate", query = "SELECT e FROM Experience e WHERE e.depDate = :depDate")})
public class Experience implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "expNo")
    private Integer expNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IniDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date iniDate;
    @Column(name = "DepDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date depDate;
    @JoinColumn(name = "Position_positionNo", referencedColumnName = "positionNo")
    @ManyToOne(optional = false)
    private Position positionpositionNo;
    @JoinColumn(name = "Staff_staffNo", referencedColumnName = "staffNo")
    @ManyToOne(optional = false)
    private Staff staffstaffNo;

    public Experience() {
    }

    public Experience(Integer expNo) {
        this.expNo = expNo;
    }

    public Experience(Integer expNo, Date iniDate) {
        this.expNo = expNo;
        this.iniDate = iniDate;
    }

    public Integer getExpNo() {
        return expNo;
    }

    public void setExpNo(Integer expNo) {
        this.expNo = expNo;
    }

    public Date getIniDate() {
        return iniDate;
    }

    public void setIniDate(Date iniDate) {
        this.iniDate = iniDate;
    }

    public Date getDepDate() {
        return depDate;
    }

    public void setDepDate(Date depDate) {
        this.depDate = depDate;
    }

    public Position getPositionpositionNo() {
        return positionpositionNo;
    }

    public void setPositionpositionNo(Position positionpositionNo) {
        this.positionpositionNo = positionpositionNo;
    }

    public Staff getStaffstaffNo() {
        return staffstaffNo;
    }

    public void setStaffstaffNo(Staff staffstaffNo) {
        this.staffstaffNo = staffstaffNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (expNo != null ? expNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Experience)) {
            return false;
        }
        Experience other = (Experience) object;
        if ((this.expNo == null && other.expNo != null) || (this.expNo != null && !this.expNo.equals(other.expNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Experience[ expNo=" + expNo + " ]";
    }
    
}
