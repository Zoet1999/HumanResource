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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "position")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Position.findAll", query = "SELECT p FROM Position p")
    , @NamedQuery(name = "Position.findByPositionNo", query = "SELECT p FROM Position p WHERE p.positionNo = :positionNo")
    , @NamedQuery(name = "Position.findByPosition", query = "SELECT p FROM Position p WHERE p.position = :position")
    , @NamedQuery(name = "Position.findByDepartment", query = "SELECT p FROM Position p WHERE p.department = :department")
    , @NamedQuery(name = "Position.findByLevel", query = "SELECT p FROM Position p WHERE p.level = :level")})
public class Position implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "positionNo")
    private Integer positionNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "position")
    private String position;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "department")
    private String department;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "level")
    private String level;
    @JoinColumn(name = "Company_companyNo", referencedColumnName = "companyNo")
    @ManyToOne(optional = false)
    private Company companycompanyNo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "positionpositionNo")
    private Collection<Experience> experienceCollection;

    public Position() {
        this.level="UnKnown";
    }

    public Position(Integer positionNo) {
        this.positionNo = positionNo;
    }

    public Position(Integer positionNo, String position, String department, String level) {
        this.positionNo = positionNo;
        this.position = position;
        this.department = department;
        this.level = level;
    }

    public Integer getPositionNo() {
        return positionNo;
    }

    public void setPositionNo(Integer positionNo) {
        this.positionNo = positionNo;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Company getCompanycompanyNo() {
        return companycompanyNo;
    }

    public void setCompanycompanyNo(Company companycompanyNo) {
        this.companycompanyNo = companycompanyNo;
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
        hash += (positionNo != null ? positionNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Position)) {
            return false;
        }
        Position other = (Position) object;
        if ((this.positionNo == null && other.positionNo != null) || (this.positionNo != null && !this.positionNo.equals(other.positionNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Position[ positionNo=" + positionNo + " ]";
    }
    
}
