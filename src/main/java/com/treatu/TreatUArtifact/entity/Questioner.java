
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.treatu.TreatUArtifact.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author creative
 */
@Entity
@Table(name = "questioner", catalog = "treatUfinal", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Questioner.findAll", query = "SELECT q FROM Questioner q"),
    @NamedQuery(name = "Questioner.findByIdQuestioner", query = "SELECT q FROM Questioner q WHERE q.idQuestioner = :idQuestioner"),
    @NamedQuery(name = "Questioner.findByTitleQuestioner", query = "SELECT q FROM Questioner q WHERE q.titleQuestioner = :titleQuestioner"),
    @NamedQuery(name = "Questioner.findByCreateDateQuestioner", query = "SELECT q FROM Questioner q WHERE q.createDateQuestioner = :createDateQuestioner"),
    @NamedQuery(name = "Questioner.findByUpdateDateQuestioner", query = "SELECT q FROM Questioner q WHERE q.updateDateQuestioner = :updateDateQuestioner"),
    @NamedQuery(name = "Questioner.findByActiveQuestioner", query = "SELECT q FROM Questioner q WHERE q.activeQuestioner = :activeQuestioner")})
public class Questioner implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "id_questioner")
    private String idQuestioner;
    @Size(max = 50)
    @Column(name = "title_questioner")
    private String titleQuestioner;
    @Lob
    @Size(max = 65535)
    @Column(name = "description_questioner")
    private String descriptionQuestioner;
    @Column(name = "create_date_questioner")
    @Temporal(TemporalType.DATE)
    private Date createDateQuestioner;
    @Column(name = "update_date_questioner")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDateQuestioner;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "active_questioner")
    private String activeQuestioner;
    @JoinColumn(name = "create_by", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private Users createBy;
    @JoinColumn(name = "update_by", referencedColumnName = "id_user")
    @ManyToOne
    private Users updateBy;
    @OneToMany(mappedBy = "idQuestioner")
    private Collection<QuestionerDetail> questionerDetailCollection;

    public Questioner() {
    }

    public Questioner(String idQuestioner) {
        this.idQuestioner = idQuestioner;
    }

    public Questioner(String idQuestioner, String activeQuestioner) {
        this.idQuestioner = idQuestioner;
        this.activeQuestioner = activeQuestioner;
    }

    public String getIdQuestioner() {
        return idQuestioner;
    }

    public void setIdQuestioner(String idQuestioner) {
        this.idQuestioner = idQuestioner;
    }

    public String getTitleQuestioner() {
        return titleQuestioner;
    }

    public void setTitleQuestioner(String titleQuestioner) {
        this.titleQuestioner = titleQuestioner;
    }

    public String getDescriptionQuestioner() {
        return descriptionQuestioner;
    }

    public void setDescriptionQuestioner(String descriptionQuestioner) {
        this.descriptionQuestioner = descriptionQuestioner;
    }

    public Date getCreateDateQuestioner() {
        return createDateQuestioner;
    }

    public void setCreateDateQuestioner(Date createDateQuestioner) {
        this.createDateQuestioner = createDateQuestioner;
    }

    public Date getUpdateDateQuestioner() {
        return updateDateQuestioner;
    }

    public void setUpdateDateQuestioner(Date updateDateQuestioner) {
        this.updateDateQuestioner = updateDateQuestioner;
    }

    public String getActiveQuestioner() {
        return activeQuestioner;
    }

    public void setActiveQuestioner(String activeQuestioner) {
        this.activeQuestioner = activeQuestioner;
    }

    public Users getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Users createBy) {
        this.createBy = createBy;
    }

    public Users getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Users updateBy) {
        this.updateBy = updateBy;
    }

    @XmlTransient
    public Collection<QuestionerDetail> getQuestionerDetailCollection() {
        return questionerDetailCollection;
    }

    public void setQuestionerDetailCollection(Collection<QuestionerDetail> questionerDetailCollection) {
        this.questionerDetailCollection = questionerDetailCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQuestioner != null ? idQuestioner.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questioner)) {
            return false;
        }
        Questioner other = (Questioner) object;
        if ((this.idQuestioner == null && other.idQuestioner != null) || (this.idQuestioner != null && !this.idQuestioner.equals(other.idQuestioner))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.treatu.TreatUArtifact.entity.Questioner[ idQuestioner=" + idQuestioner + " ]";
    }
    

}