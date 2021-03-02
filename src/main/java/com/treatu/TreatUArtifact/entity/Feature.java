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
@Table(name = "feature")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Feature.findAll", query = "SELECT f FROM Feature f")
    , @NamedQuery(name = "Feature.findByIdFeature", query = "SELECT f FROM Feature f WHERE f.idFeature = :idFeature")
    , @NamedQuery(name = "Feature.findByNameFeature", query = "SELECT f FROM Feature f WHERE f.nameFeature = :nameFeature")
    , @NamedQuery(name = "Feature.findByActiveFeature", query = "SELECT f FROM Feature f WHERE f.activeFeature = :activeFeature")})
public class Feature implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_feature")
    private Integer idFeature;
    @Size(max = 255)
    @Column(name = "name_feature")
    private String nameFeature;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "active_feature")
    private String activeFeature;
    @OneToMany(mappedBy = "idFeature", fetch = FetchType.LAZY)
    private List<Log> logList;

    public Feature() {
    }

    public Feature(Integer idFeature) {
        this.idFeature = idFeature;
    }

    public Feature(Integer idFeature, String activeFeature) {
        this.idFeature = idFeature;
        this.activeFeature = activeFeature;
    }

    public Integer getIdFeature() {
        return idFeature;
    }

    public void setIdFeature(Integer idFeature) {
        this.idFeature = idFeature;
    }

    public String getNameFeature() {
        return nameFeature;
    }

    public void setNameFeature(String nameFeature) {
        this.nameFeature = nameFeature;
    }

    public String getActiveFeature() {
        return activeFeature;
    }

    public void setActiveFeature(String activeFeature) {
        this.activeFeature = activeFeature;
    }

    @XmlTransient
    public List<Log> getLogList() {
        return logList;
    }

    public void setLogList(List<Log> logList) {
        this.logList = logList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFeature != null ? idFeature.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Feature)) {
            return false;
        }
        Feature other = (Feature) object;
        if ((this.idFeature == null && other.idFeature != null) || (this.idFeature != null && !this.idFeature.equals(other.idFeature))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.treatu.TreatUArtifact.entity.Feature[ idFeature=" + idFeature + " ]";
    }
    
}
