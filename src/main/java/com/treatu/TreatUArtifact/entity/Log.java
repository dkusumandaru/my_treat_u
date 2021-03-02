
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
 * @author creative
 */
@Entity
@Table(name = "log", catalog = "treatUfinal", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Log.findAll", query = "SELECT l FROM Log l"),
    @NamedQuery(name = "Log.findByIdLog", query = "SELECT l FROM Log l WHERE l.idLog = :idLog"),
    @NamedQuery(name = "Log.findByDateLog", query = "SELECT l FROM Log l WHERE l.dateLog = :dateLog")})
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 22)
    @Column(name = "id_log")
    private String idLog;
    @Lob
    @Size(max = 65535)
    @Column(name = "describe_log")
    private String describeLog;
    @Column(name = "date_log")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLog;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne
    private Users idUser;
    @JoinColumn(name = "id_action", referencedColumnName = "id_action")
    @ManyToOne
    private Action idAction;
    @JoinColumn(name = "id_feature", referencedColumnName = "id_feature")
    @ManyToOne
    private Feature idFeature;

    public Log() {
    }

    public Log(String idLog) {
        this.idLog = idLog;
    }

    public String getIdLog() {
        return idLog;
    }

    public void setIdLog(String idLog) {
        this.idLog = idLog;
    }

    public String getDescribeLog() {
        return describeLog;
    }

    public void setDescribeLog(String describeLog) {
        this.describeLog = describeLog;
    }

    public Date getDateLog() {
        return dateLog;
    }

    public void setDateLog(Date dateLog) {
        this.dateLog = dateLog;
    }

    public Users getIdUser() {
        return idUser;
    }

    public void setIdUser(Users idUser) {
        this.idUser = idUser;
    }

    public Action getIdAction() {
        return idAction;
    }

    public void setIdAction(Action idAction) {
        this.idAction = idAction;
    }

    public Feature getIdFeature() {
        return idFeature;
    }

    public void setIdFeature(Feature idFeature) {
        this.idFeature = idFeature;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLog != null ? idLog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Log)) {
            return false;
        }
        Log other = (Log) object;
        if ((this.idLog == null && other.idLog != null) || (this.idLog != null && !this.idLog.equals(other.idLog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.treatu.TreatUArtifact.entity.Log[ idLog=" + idLog + " ]";
    }
    

}
