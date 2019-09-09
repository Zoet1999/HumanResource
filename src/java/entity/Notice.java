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
@Table(name = "notice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notice.findAll", query = "SELECT n FROM Notice n")
    , @NamedQuery(name = "Notice.findByNoticeNo", query = "SELECT n FROM Notice n WHERE n.noticeNo = :noticeNo")
    , @NamedQuery(name = "Notice.findByTitle", query = "SELECT n FROM Notice n WHERE n.title = :title")
    , @NamedQuery(name = "Notice.findByContent", query = "SELECT n FROM Notice n WHERE n.content = :content")
    , @NamedQuery(name = "Notice.findByCreateDate", query = "SELECT n FROM Notice n WHERE n.createDate = :createDate")
    , @NamedQuery(name = "Notice.findByChangeDate", query = "SELECT n FROM Notice n WHERE n.changeDate = :changeDate")})
public class Notice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "noticeNo")
    private Integer noticeNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "changeDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date changeDate;
    @JoinColumn(name = "account_accountNo", referencedColumnName = "accountNo")
    @ManyToOne(optional = false)
    private Account accountaccountNo;

    public Notice() {
    }

    public Notice(Integer noticeNo) {
        this.noticeNo = noticeNo;
    }

    public Notice(Integer noticeNo, String title, String content, Date createDate) {
        this.noticeNo = noticeNo;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
    }

    public Integer getNoticeNo() {
        return noticeNo;
    }

    public void setNoticeNo(Integer noticeNo) {
        this.noticeNo = noticeNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
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
        hash += (noticeNo != null ? noticeNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notice)) {
            return false;
        }
        Notice other = (Notice) object;
        if ((this.noticeNo == null && other.noticeNo != null) || (this.noticeNo != null && !this.noticeNo.equals(other.noticeNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Notice[ noticeNo=" + noticeNo + " ]";
    }
    
}
