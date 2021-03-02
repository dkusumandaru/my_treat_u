
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
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "stress_level")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StressLevel.findAll", query = "SELECT s FROM StressLevel s")
    , @NamedQuery(name = "StressLevel.findByIdStressLevel", query = "SELECT s FROM StressLevel s WHERE s.idStressLevel = :idStressLevel")
    , @NamedQuery(name = "StressLevel.findByActive", query = "SELECT s FROM StressLevel s WHERE s.active = :active")})
public class StressLevel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_stress_level")
    private Integer idStressLevel;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "active")
    private String active;
    @OneToMany(mappedBy = "idStressLevel", fetch = FetchType.LAZY)
    private List<Consultation> consultationList;

    public StressLevel() {
    }

    public StressLevel(Integer idStressLevel) {
        this.idStressLevel = idStressLevel;
    }

    public StressLevel(Integer idStressLevel, String name, String active) {
        this.idStressLevel = idStressLevel;
        this.name = name;
        this.active = active;
    }

    public Integer getIdStressLevel() {
        return idStressLevel;
    }

    public void setIdStressLevel(Integer idStressLevel) {
        this.idStressLevel = idStressLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
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
        hash += (idStressLevel != null ? idStressLevel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StressLevel)) {
            return false;
        }
        StressLevel other = (StressLevel) object;
        if ((this.idStressLevel == null && other.idStressLevel != null) || (this.idStressLevel != null && !this.idStressLevel.equals(other.idStressLevel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.treatu.TreatUArtifact.entity.StressLevel[ idStressLevel=" + idStressLevel + " ]";
    }
    
}
