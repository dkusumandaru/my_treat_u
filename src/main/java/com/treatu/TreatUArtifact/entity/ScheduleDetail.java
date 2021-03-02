/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.treatu.TreatUArtifact.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author D
 */
@Entity
@Table(name = "schedule_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScheduleDetail.findAll", query = "SELECT s FROM ScheduleDetail s")
    , @NamedQuery(name = "ScheduleDetail.findByIdScheduleDetail", query = "SELECT s FROM ScheduleDetail s WHERE s.idScheduleDetail = :idScheduleDetail")})
public class ScheduleDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "id_schedule_detail")
    private String idScheduleDetail;
    @JoinColumn(name = "id_doctor", referencedColumnName = "id_user")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Users idDoctor;
    @JoinColumn(name = "id_schedule", referencedColumnName = "id_schedule")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Schedule idSchedule;

    public ScheduleDetail() {
    }

    public ScheduleDetail(String idScheduleDetail) {
        this.idScheduleDetail = idScheduleDetail;
    }

    public String getIdScheduleDetail() {
        return idScheduleDetail;
    }

    public void setIdScheduleDetail(String idScheduleDetail) {
        this.idScheduleDetail = idScheduleDetail;
    }

    public Users getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Users idDoctor) {
        this.idDoctor = idDoctor;
    }

    public Schedule getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(Schedule idSchedule) {
        this.idSchedule = idSchedule;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idScheduleDetail != null ? idScheduleDetail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ScheduleDetail)) {
            return false;
        }
        ScheduleDetail other = (ScheduleDetail) object;
        if ((this.idScheduleDetail == null && other.idScheduleDetail != null) || (this.idScheduleDetail != null && !this.idScheduleDetail.equals(other.idScheduleDetail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.treatu.TreatUArtifact.entity.ScheduleDetail[ idScheduleDetail=" + idScheduleDetail + " ]";
    }
    
}
