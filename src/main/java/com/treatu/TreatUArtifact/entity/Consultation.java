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
@Table(name = "consultation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultation.findAll", query = "SELECT c FROM Consultation c")
    , @NamedQuery(name = "Consultation.findByIdConsultation", query = "SELECT c FROM Consultation c WHERE c.idConsultation = :idConsultation")
    , @NamedQuery(name = "Consultation.findByQueueConsultation", query = "SELECT c FROM Consultation c WHERE c.queueConsultation = :queueConsultation")
    , @NamedQuery(name = "Consultation.findByDateConsultation", query = "SELECT c FROM Consultation c WHERE c.dateConsultation = :dateConsultation")
    , @NamedQuery(name = "Consultation.findByCreateDateConsultation", query = "SELECT c FROM Consultation c WHERE c.createDateConsultation = :createDateConsultation")
    , @NamedQuery(name = "Consultation.findByUpdateDateConsultation", query = "SELECT c FROM Consultation c WHERE c.updateDateConsultation = :updateDateConsultation")
    , @NamedQuery(name = "Consultation.findByUpdateBy", query = "SELECT c FROM Consultation c WHERE c.updateBy = :updateBy")
    , @NamedQuery(name = "Consultation.findByIdSchedule", query = "SELECT c FROM Consultation c WHERE c.idSchedule = :idSchedule")
    , @NamedQuery(name = "Consultation.findByCounterConsultation", query = "SELECT c FROM Consultation c WHERE c.counterConsultation = :counterConsultation")
    , @NamedQuery(name = "Consultation.findByResponseEmployee", query = "SELECT c FROM Consultation c WHERE c.responseEmployee = :responseEmployee")})
public class Consultation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "id_consultation")
    private String idConsultation;
    @Column(name = "queue_consultation")
    private Integer queueConsultation;
    @Column(name = "date_consultation")
    @Temporal(TemporalType.DATE)
    private Date dateConsultation;
    @Column(name = "create_date_consultation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDateConsultation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "update_date_consultation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDateConsultation;
    @Size(max = 10)
    @Column(name = "update_by")
    private String updateBy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "id_schedule")
    private String idSchedule;
    @Column(name = "counter_consultation")
    private Integer counterConsultation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "response_employee")
    private String responseEmployee;
    @Lob
    @Size(max = 65535)
    @Column(name = "review_consultation")
    private String reviewConsultation;
    @JoinColumn(name = "id_doctor", referencedColumnName = "id_user")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users idDoctor;
    @JoinColumn(name = "id_employee", referencedColumnName = "id_user")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users idEmployee;
    @JoinColumn(name = "id_problem", referencedColumnName = "id_problem")
    @ManyToOne(fetch = FetchType.LAZY)
    private Problem idProblem;
    @JoinColumn(name = "id_stress_level", referencedColumnName = "id_stress_level")
    @ManyToOne(fetch = FetchType.LAZY)
    private StressLevel idStressLevel;
    @JoinColumn(name = "id_consultation_status", referencedColumnName = "id_consultation_status")
    @ManyToOne(fetch = FetchType.LAZY)
    private ConsultationStatus idConsultationStatus;

    public Consultation() {
    }

    public Consultation(String idConsultation) {
        this.idConsultation = idConsultation;
    }

    public Consultation(String idConsultation, Date updateDateConsultation, String idSchedule, String responseEmployee) {
        this.idConsultation = idConsultation;
        this.updateDateConsultation = updateDateConsultation;
        this.idSchedule = idSchedule;
        this.responseEmployee = responseEmployee;
    }

    public String getIdConsultation() {
        return idConsultation;
    }

    public void setIdConsultation(String idConsultation) {
        this.idConsultation = idConsultation;
    }

    public Integer getQueueConsultation() {
        return queueConsultation;
    }

    public void setQueueConsultation(Integer queueConsultation) {
        this.queueConsultation = queueConsultation;
    }

    public Date getDateConsultation() {
        return dateConsultation;
    }

    public void setDateConsultation(Date dateConsultation) {
        this.dateConsultation = dateConsultation;
    }

    public Date getCreateDateConsultation() {
        return createDateConsultation;
    }

    public void setCreateDateConsultation(Date createDateConsultation) {
        this.createDateConsultation = createDateConsultation;
    }

    public Date getUpdateDateConsultation() {
        return updateDateConsultation;
    }

    public void setUpdateDateConsultation(Date updateDateConsultation) {
        this.updateDateConsultation = updateDateConsultation;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(String idSchedule) {
        this.idSchedule = idSchedule;
    }

    public Integer getCounterConsultation() {
        return counterConsultation;
    }

    public void setCounterConsultation(Integer counterConsultation) {
        this.counterConsultation = counterConsultation;
    }

    public String getResponseEmployee() {
        return responseEmployee;
    }

    public void setResponseEmployee(String responseEmployee) {
        this.responseEmployee = responseEmployee;
    }

    public String getReviewConsultation() {
        return reviewConsultation;
    }

    public void setReviewConsultation(String reviewConsultation) {
        this.reviewConsultation = reviewConsultation;
    }

    public Users getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Users idDoctor) {
        this.idDoctor = idDoctor;
    }

    public Users getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Users idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Problem getIdProblem() {
        return idProblem;
    }

    public void setIdProblem(Problem idProblem) {
        this.idProblem = idProblem;
    }

    public StressLevel getIdStressLevel() {
        return idStressLevel;
    }

    public void setIdStressLevel(StressLevel idStressLevel) {
        this.idStressLevel = idStressLevel;
    }

    public ConsultationStatus getIdConsultationStatus() {
        return idConsultationStatus;
    }

    public void setIdConsultationStatus(ConsultationStatus idConsultationStatus) {
        this.idConsultationStatus = idConsultationStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConsultation != null ? idConsultation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultation)) {
            return false;
        }
        Consultation other = (Consultation) object;
        if ((this.idConsultation == null && other.idConsultation != null) || (this.idConsultation != null && !this.idConsultation.equals(other.idConsultation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.treatu.TreatUArtifact.entity.Consultation[ idConsultation=" + idConsultation + " ]";
    }
    
}
