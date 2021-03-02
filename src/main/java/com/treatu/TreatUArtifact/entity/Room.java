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
@Table(name = "room")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Room.findAll", query = "SELECT r FROM Room r")
    , @NamedQuery(name = "Room.findByIdRoom", query = "SELECT r FROM Room r WHERE r.idRoom = :idRoom")
    , @NamedQuery(name = "Room.findByCapacityRoom", query = "SELECT r FROM Room r WHERE r.capacityRoom = :capacityRoom")
    , @NamedQuery(name = "Room.findByUrlRoom", query = "SELECT r FROM Room r WHERE r.urlRoom = :urlRoom")
    , @NamedQuery(name = "Room.findByCreateDateRoom", query = "SELECT r FROM Room r WHERE r.createDateRoom = :createDateRoom")
    , @NamedQuery(name = "Room.findByUpdateDateRoom", query = "SELECT r FROM Room r WHERE r.updateDateRoom = :updateDateRoom")})
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "id_room")
    private String idRoom;
    @Column(name = "capacity_room")
    private Integer capacityRoom;
    @Size(max = 100)
    @Column(name = "url_room")
    private String urlRoom;
    @Column(name = "create_date_room")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDateRoom;
    @Column(name = "update_date_room")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDateRoom;
    @JoinColumn(name = "id_docter", referencedColumnName = "id_user")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users idDocter;
    @JoinColumn(name = "create_by", referencedColumnName = "id_user")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users createBy;
    @JoinColumn(name = "update_by", referencedColumnName = "id_user")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users updateBy;

    public Room() {
    }

    public Room(String idRoom) {
        this.idRoom = idRoom;
    }

    public String getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(String idRoom) {
        this.idRoom = idRoom;
    }

    public Integer getCapacityRoom() {
        return capacityRoom;
    }

    public void setCapacityRoom(Integer capacityRoom) {
        this.capacityRoom = capacityRoom;
    }

    public String getUrlRoom() {
        return urlRoom;
    }

    public void setUrlRoom(String urlRoom) {
        this.urlRoom = urlRoom;
    }

    public Date getCreateDateRoom() {
        return createDateRoom;
    }

    public void setCreateDateRoom(Date createDateRoom) {
        this.createDateRoom = createDateRoom;
    }

    public Date getUpdateDateRoom() {
        return updateDateRoom;
    }

    public void setUpdateDateRoom(Date updateDateRoom) {
        this.updateDateRoom = updateDateRoom;
    }

    public Users getIdDocter() {
        return idDocter;
    }

    public void setIdDocter(Users idDocter) {
        this.idDocter = idDocter;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRoom != null ? idRoom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Room)) {
            return false;
        }
        Room other = (Room) object;
        if ((this.idRoom == null && other.idRoom != null) || (this.idRoom != null && !this.idRoom.equals(other.idRoom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.treatu.TreatUArtifact.entity.Room[ idRoom=" + idRoom + " ]";
    }
    
}
