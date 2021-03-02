
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
@Table(name = "questioner_detail", catalog = "treatUfinal", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QuestionerDetail.findAll", query = "SELECT q FROM QuestionerDetail q"),
    @NamedQuery(name = "QuestionerDetail.findByIdQuestionerDetail", query = "SELECT q FROM QuestionerDetail q WHERE q.idQuestionerDetail = :idQuestionerDetail"),
    @NamedQuery(name = "QuestionerDetail.findByCreateDateQuestionerDetail", query = "SELECT q FROM QuestionerDetail q WHERE q.createDateQuestionerDetail = :createDateQuestionerDetail"),
    @NamedQuery(name = "QuestionerDetail.findByUpdateDateQuestionerDetail", query = "SELECT q FROM QuestionerDetail q WHERE q.updateDateQuestionerDetail = :updateDateQuestionerDetail"),
    @NamedQuery(name = "QuestionerDetail.findByActiveQuestionerDetail", query = "SELECT q FROM QuestionerDetail q WHERE q.activeQuestionerDetail = :activeQuestionerDetail")})
public class QuestionerDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 24)
    @Column(name = "id_questioner_detail")
    private String idQuestionerDetail;
    @Lob
    @Size(max = 65535)
    @Column(name = "question_questioner_detail")
    private String questionQuestionerDetail;
    @Lob
    @Size(max = 65535)
    @Column(name = "answer_questioner_detail")
    private String answerQuestionerDetail;
    @Column(name = "create_date_questioner_detail")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDateQuestionerDetail;
    @Column(name = "update_date_questioner_detail")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDateQuestionerDetail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "active_questioner_detail")
    private String activeQuestionerDetail;
    @OneToMany(mappedBy = "idQuestionerDetail")
    private Collection<QuestionAnswer> questionAnswerCollection;
    @JoinColumn(name = "create_by", referencedColumnName = "id_user")
    @ManyToOne
    private Users createBy;
    @JoinColumn(name = "update_by", referencedColumnName = "id_user")
    @ManyToOne
    private Users updateBy;
    @JoinColumn(name = "id_questioner", referencedColumnName = "id_questioner")
    @ManyToOne
    private Questioner idQuestioner;

    public QuestionerDetail() {
    }

    public QuestionerDetail(String idQuestionerDetail) {
        this.idQuestionerDetail = idQuestionerDetail;
    }

    public QuestionerDetail(String idQuestionerDetail, String activeQuestionerDetail) {
        this.idQuestionerDetail = idQuestionerDetail;
        this.activeQuestionerDetail = activeQuestionerDetail;
    }

    public String getIdQuestionerDetail() {
        return idQuestionerDetail;
    }

    public void setIdQuestionerDetail(String idQuestionerDetail) {
        this.idQuestionerDetail = idQuestionerDetail;
    }

    public String getQuestionQuestionerDetail() {
        return questionQuestionerDetail;
    }

    public void setQuestionQuestionerDetail(String questionQuestionerDetail) {
        this.questionQuestionerDetail = questionQuestionerDetail;
    }

    public String getAnswerQuestionerDetail() {
        return answerQuestionerDetail;
    }

    public void setAnswerQuestionerDetail(String answerQuestionerDetail) {
        this.answerQuestionerDetail = answerQuestionerDetail;
    }

    public Date getCreateDateQuestionerDetail() {
        return createDateQuestionerDetail;
    }

    public void setCreateDateQuestionerDetail(Date createDateQuestionerDetail) {
        this.createDateQuestionerDetail = createDateQuestionerDetail;
    }

    public Date getUpdateDateQuestionerDetail() {
        return updateDateQuestionerDetail;
    }

    public void setUpdateDateQuestionerDetail(Date updateDateQuestionerDetail) {
        this.updateDateQuestionerDetail = updateDateQuestionerDetail;
    }

    public String getActiveQuestionerDetail() {
        return activeQuestionerDetail;
    }

    public void setActiveQuestionerDetail(String activeQuestionerDetail) {
        this.activeQuestionerDetail = activeQuestionerDetail;
    }

    @XmlTransient
    public Collection<QuestionAnswer> getQuestionAnswerCollection() {
        return questionAnswerCollection;
    }

    public void setQuestionAnswerCollection(Collection<QuestionAnswer> questionAnswerCollection) {
        this.questionAnswerCollection = questionAnswerCollection;
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

    public Questioner getIdQuestioner() {
        return idQuestioner;
    }

    public void setIdQuestioner(Questioner idQuestioner) {
        this.idQuestioner = idQuestioner;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQuestionerDetail != null ? idQuestionerDetail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuestionerDetail)) {
            return false;
        }
        QuestionerDetail other = (QuestionerDetail) object;
        if ((this.idQuestionerDetail == null && other.idQuestionerDetail != null) || (this.idQuestionerDetail != null && !this.idQuestionerDetail.equals(other.idQuestionerDetail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.treatu.TreatUArtifact.entity.QuestionerDetail[ idQuestionerDetail=" + idQuestionerDetail + " ]";
    }
    
}
