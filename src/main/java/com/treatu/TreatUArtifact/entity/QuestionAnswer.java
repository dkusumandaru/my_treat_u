/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.treatu.TreatUArtifact.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
 * @author D
 */
@Entity
@Table(name = "question_answer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QuestionAnswer.findAll", query = "SELECT q FROM QuestionAnswer q")
    , @NamedQuery(name = "QuestionAnswer.findByIdQuestionAnswer", query = "SELECT q FROM QuestionAnswer q WHERE q.idQuestionAnswer = :idQuestionAnswer")
    , @NamedQuery(name = "QuestionAnswer.findByCreateDateQuestionAnswer", query = "SELECT q FROM QuestionAnswer q WHERE q.createDateQuestionAnswer = :createDateQuestionAnswer")
    , @NamedQuery(name = "QuestionAnswer.findByUpdateDateQuestionAnswer", query = "SELECT q FROM QuestionAnswer q WHERE q.updateDateQuestionAnswer = :updateDateQuestionAnswer")})
public class QuestionAnswer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 34)
    @Column(name = "id_question_answer")
    private String idQuestionAnswer;
    @Lob
    @Size(max = 65535)
    @Column(name = "answer_question_answer")
    private String answerQuestionAnswer;
    @Column(name = "create_date_question_answer")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDateQuestionAnswer;
    @Column(name = "update_date_question_answer")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDateQuestionAnswer;
    @JoinColumn(name = "id_questioner_detail", referencedColumnName = "id_questioner_detail")
    @ManyToOne(fetch = FetchType.LAZY)
    private QuestionerDetail idQuestionerDetail;
    @JoinColumn(name = "id_employee", referencedColumnName = "id_user")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users idEmployee;

    public QuestionAnswer() {
    }

    public QuestionAnswer(String idQuestionAnswer) {
        this.idQuestionAnswer = idQuestionAnswer;
    }

    public String getIdQuestionAnswer() {
        return idQuestionAnswer;
    }

    public void setIdQuestionAnswer(String idQuestionAnswer) {
        this.idQuestionAnswer = idQuestionAnswer;
    }

    public String getAnswerQuestionAnswer() {
        return answerQuestionAnswer;
    }

    public void setAnswerQuestionAnswer(String answerQuestionAnswer) {
        this.answerQuestionAnswer = answerQuestionAnswer;
    }

    public Date getCreateDateQuestionAnswer() {
        return createDateQuestionAnswer;
    }

    public void setCreateDateQuestionAnswer(Date createDateQuestionAnswer) {
        this.createDateQuestionAnswer = createDateQuestionAnswer;
    }

    public Date getUpdateDateQuestionAnswer() {
        return updateDateQuestionAnswer;
    }

    public void setUpdateDateQuestionAnswer(Date updateDateQuestionAnswer) {
        this.updateDateQuestionAnswer = updateDateQuestionAnswer;
    }

    public QuestionerDetail getIdQuestionerDetail() {
        return idQuestionerDetail;
    }

    public void setIdQuestionerDetail(QuestionerDetail idQuestionerDetail) {
        this.idQuestionerDetail = idQuestionerDetail;
    }

    public Users getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Users idEmployee) {
        this.idEmployee = idEmployee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQuestionAnswer != null ? idQuestionAnswer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuestionAnswer)) {
            return false;
        }
        QuestionAnswer other = (QuestionAnswer) object;
        if ((this.idQuestionAnswer == null && other.idQuestionAnswer != null) || (this.idQuestionAnswer != null && !this.idQuestionAnswer.equals(other.idQuestionAnswer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.treatu.TreatUArtifact.entity.QuestionAnswer[ idQuestionAnswer=" + idQuestionAnswer + " ]";
    }
    
}
