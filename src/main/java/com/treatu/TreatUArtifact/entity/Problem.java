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
@Table(name = "problem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Problem.findAll", query = "SELECT p FROM Problem p")
    , @NamedQuery(name = "Problem.findByIdProblem", query = "SELECT p FROM Problem p WHERE p.idProblem = :idProblem")
    , @NamedQuery(name = "Problem.findByNameProblem", query = "SELECT p FROM Problem p WHERE p.nameProblem = :nameProblem")
    , @NamedQuery(name = "Problem.findByActiveProblem", query = "SELECT p FROM Problem p WHERE p.activeProblem = :activeProblem")})
public class Problem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_problem")
    private Integer idProblem;
    @Size(max = 255)
    @Column(name = "name_problem")
    private String nameProblem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "active_problem")
    private String activeProblem;
    @OneToMany(mappedBy = "idProblem", fetch = FetchType.LAZY)
    private List<Consultation> consultationList;

    public Problem() {
    }

    public Problem(Integer idProblem) {
        this.idProblem = idProblem;
    }

    public Problem(Integer idProblem, String activeProblem) {
        this.idProblem = idProblem;
        this.activeProblem = activeProblem;
    }

    public Integer getIdProblem() {
        return idProblem;
    }

    public void setIdProblem(Integer idProblem) {
        this.idProblem = idProblem;
    }

    public String getNameProblem() {
        return nameProblem;
    }

    public void setNameProblem(String nameProblem) {
        this.nameProblem = nameProblem;
    }

    public String getActiveProblem() {
        return activeProblem;
    }

    public void setActiveProblem(String activeProblem) {
        this.activeProblem = activeProblem;
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
        hash += (idProblem != null ? idProblem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Problem)) {
            return false;
        }
        Problem other = (Problem) object;
        if ((this.idProblem == null && other.idProblem != null) || (this.idProblem != null && !this.idProblem.equals(other.idProblem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.treatu.TreatUArtifact.entity.Problem[ idProblem=" + idProblem + " ]";
    }
    
}
