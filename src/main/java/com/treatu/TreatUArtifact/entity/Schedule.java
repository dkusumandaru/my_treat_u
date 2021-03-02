/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.treatu.TreatUArtifact.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
 * @author D
 */
@Entity
@Table(name = "schedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Schedule.findAll", query = "SELECT s FROM Schedule s")
    , @NamedQuery(name = "Schedule.findByIdSchedule", query = "SELECT s FROM Schedule s WHERE s.idSchedule = :idSchedule")
    , @NamedQuery(name = "Schedule.findByNameSchedule", query = "SELECT s FROM Schedule s WHERE s.nameSchedule = :nameSchedule")
    , @NamedQuery(name = "Schedule.findByStartTimeSchedule", query = "SELECT s FROM Schedule s WHERE s.startTimeSchedule = :startTimeSchedule")
    , @NamedQuery(name = "Schedule.findByEndTimeSchedule", query = "SELECT s FROM Schedule s WHERE s.endTimeSchedule = :endTimeSchedule")
    , @NamedQuery(name = "Schedule.findByActiveSchedule", query = "SELECT s FROM Schedule s WHERE s.activeSchedule = :activeSchedule")})
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "id_schedule")
    private String idSchedule;
    @Size(max = 50)
    @Column(name = "name_schedule")
    private String nameSchedule;
    @Column(name = "start_time_schedule")
    @Temporal(TemporalType.TIME)
    private Date startTimeSchedule;
    @Column(name = "end_time_schedule")
    @Temporal(TemporalType.TIME)
    private Date endTimeSchedule;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "active_schedule")
    private String activeSchedule;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSchedule", fetch = FetchType.LAZY)
    private List<ScheduleDetail> scheduleDetailList;

    public Schedule() {
    }

    public Schedule(String idSchedule) {
        this.idSchedule = idSchedule;
    }

    public Schedule(String idSchedule, String activeSchedule) {
        this.idSchedule = idSchedule;
        this.activeSchedule = activeSchedule;
    }

    public String getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(String idSchedule) {
        this.idSchedule = idSchedule;
    }

    public String getNameSchedule() {
        return nameSchedule;
    }

    public void setNameSchedule(String nameSchedule) {
        this.nameSchedule = nameSchedule;
    }

    public Date getStartTimeSchedule() {
        return startTimeSchedule;
    }

    public void setStartTimeSchedule(Date startTimeSchedule) {
        this.startTimeSchedule = startTimeSchedule;
    }

    public Date getEndTimeSchedule() {
        return endTimeSchedule;
    }

    public void setEndTimeSchedule(Date endTimeSchedule) {
        this.endTimeSchedule = endTimeSchedule;
    }

    public String getActiveSchedule() {
        return activeSchedule;
    }

    public void setActiveSchedule(String activeSchedule) {
        this.activeSchedule = activeSchedule;
    }

    @XmlTransient
    public List<ScheduleDetail> getScheduleDetailList() {
        return scheduleDetailList;
    }

    public void setScheduleDetailList(List<ScheduleDetail> scheduleDetailList) {
        this.scheduleDetailList = scheduleDetailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSchedule != null ? idSchedule.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Schedule)) {
            return false;
        }
        Schedule other = (Schedule) object;
        if ((this.idSchedule == null && other.idSchedule != null) || (this.idSchedule != null && !this.idSchedule.equals(other.idSchedule))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.treatu.TreatUArtifact.entity.Schedule[ idSchedule=" + idSchedule + " ]";
    }
    
}
