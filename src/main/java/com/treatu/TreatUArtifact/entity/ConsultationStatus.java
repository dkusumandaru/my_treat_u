/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.treatu.TreatUArtifact.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author D
 */
@Entity
@Table(name = "consultation_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConsultationStatus.findAll", query = "SELECT c FROM ConsultationStatus c")
    , @NamedQuery(name = "ConsultationStatus.findByIdConsultationStatus", query = "SELECT c FROM ConsultationStatus c WHERE c.idConsultationStatus = :idConsultationStatus")
    , @NamedQuery(name = "ConsultationStatus.findByNameConsultationStatus", query = "SELECT c FROM ConsultationStatus c WHERE c.nameConsultationStatus = :nameConsultationStatus")
    , @NamedQuery(name = "ConsultationStatus.findByActiveConsultationStatus", query = "SELECT c FROM ConsultationStatus c WHERE c.activeConsultationStatus = :activeConsultationStatus")})
public class ConsultationStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_consultation_status")
    private Integer idConsultationStatus;
    @Size(max = 255)
    @Column(name = "name_consultation_status")
    private String nameConsultationStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "active_consultation_status")
    private String activeConsultationStatus;
    @OneToMany(mappedBy = "idConsultationStatus", fetch = FetchType.LAZY)
    private List<Consultation> consultationList;

    public ConsultationStatus() {
    }

    public ConsultationStatus(Integer idConsultationStatus) {
        this.idConsultationStatus = idConsultationStatus;
    }

    public ConsultationStatus(Integer idConsultationStatus, String activeConsultationStatus) {
        this.idConsultationStatus = idConsultationStatus;
        this.activeConsultationStatus = activeConsultationStatus;
    }

    public Integer getIdConsultationStatus() {
        return idConsultationStatus;
    }

    public void setIdConsultationStatus(Integer idConsultationStatus) {
        this.idConsultationStatus = idConsultationStatus;
    }

    public String getNameConsultationStatus() {
        return nameConsultationStatus;
    }

    public void setNameConsultationStatus(String nameConsultationStatus) {
        this.nameConsultationStatus = nameConsultationStatus;
    }

    public String getActiveConsultationStatus() {
        return activeConsultationStatus;
    }

    public void setActiveConsultationStatus(String activeConsultationStatus) {
        this.activeConsultationStatus = activeConsultationStatus;
    }

    @XmlTransient
    public List<Consultation> getConsultationList() {
        return consultationList;
    }

    public void setConsultationList(List<Consultation> consultationList) {
        this.consultationList = consultationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConsultationStatus != null ? idConsultationStatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsultationStatus)) {
            return false;
        }
        ConsultationStatus other = (ConsultationStatus) object;
        if ((this.idConsultationStatus == null && other.idConsultationStatus != null) || (this.idConsultationStatus != null && !this.idConsultationStatus.equals(other.idConsultationStatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.treatu.TreatUArtifact.entity.ConsultationStatus[ idConsultationStatus=" + idConsultationStatus + " ]";
    }
    
}
