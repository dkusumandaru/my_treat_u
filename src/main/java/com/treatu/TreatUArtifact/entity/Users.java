/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.treatu.TreatUArtifact.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findByIdUser", query = "SELECT u FROM Users u WHERE u.idUser = :idUser")
    , @NamedQuery(name = "Users.findByFirstName", query = "SELECT u FROM Users u WHERE u.firstName = :firstName")
    , @NamedQuery(name = "Users.findByLastName", query = "SELECT u FROM Users u WHERE u.lastName = :lastName")
    , @NamedQuery(name = "Users.findByEmailUser", query = "SELECT u FROM Users u WHERE u.emailUser = :emailUser")
    , @NamedQuery(name = "Users.findByPasswordUser", query = "SELECT u FROM Users u WHERE u.passwordUser = :passwordUser")
    , @NamedQuery(name = "Users.findByActiveUser", query = "SELECT u FROM Users u WHERE u.activeUser = :activeUser")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_user")
    private String idUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "first_name")
    private String firstName;
    @Size(max = 255)
    @Column(name = "last_name")
    private String lastName;
    @Size(max = 255)
    @Column(name = "email_user")
    private String emailUser;
    @Size(max = 255)
    @Column(name = "password_user")
    private String passwordUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "active_user")
    private String activeUser;
    @OneToMany(mappedBy = "idUser", fetch = FetchType.LAZY)
    private List<Log> logList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDoctor", fetch = FetchType.LAZY)
    private List<ScheduleDetail> scheduleDetailList;
    @OneToMany(mappedBy = "idEmployee", fetch = FetchType.LAZY)
    private List<QuestionAnswer> questionAnswerList;
    @OneToMany(mappedBy = "idDocter", fetch = FetchType.LAZY)
    private List<Room> roomList;
    @OneToMany(mappedBy = "createBy", fetch = FetchType.LAZY)
    private List<Room> roomList1;
    @OneToMany(mappedBy = "updateBy", fetch = FetchType.LAZY)
    private List<Room> roomList2;
    @JoinColumn(name = "id_role", referencedColumnName = "id_role")
    @ManyToOne(fetch = FetchType.LAZY)
    private Role idRole;
    @JoinColumn(name = "id_department", referencedColumnName = "id_department")
    @ManyToOne(fetch = FetchType.LAZY)
    private Department idDepartment;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "createBy", fetch = FetchType.LAZY)
    private List<Questioner> questionerList;
    @OneToMany(mappedBy = "updateBy", fetch = FetchType.LAZY)
    private List<Questioner> questionerList1;
    @OneToMany(mappedBy = "createBy", fetch = FetchType.LAZY)
    private List<QuestionerDetail> questionerDetailList;
    @OneToMany(mappedBy = "updateBy", fetch = FetchType.LAZY)
    private List<QuestionerDetail> questionerDetailList1;
    @OneToMany(mappedBy = "idDoctor", fetch = FetchType.LAZY)
    private List<Consultation> consultationList;
    @OneToMany(mappedBy = "idEmployee", fetch = FetchType.LAZY)
    private List<Consultation> consultationList1;

    public Users() {
    }

    public Users(String idUser) {
        this.idUser = idUser;
    }

    public Users(String idUser, String firstName, String activeUser) {
        this.idUser = idUser;
        this.firstName = firstName;
        this.activeUser = activeUser;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(String activeUser) {
        this.activeUser = activeUser;
    }

    @XmlTransient
    public List<Log> getLogList() {
        return logList;
    }

    public void setLogList(List<Log> logList) {
        this.logList = logList;
    }

    @XmlTransient
    public List<ScheduleDetail> getScheduleDetailList() {
        return scheduleDetailList;
    }

    public void setScheduleDetailList(List<ScheduleDetail> scheduleDetailList) {
        this.scheduleDetailList = scheduleDetailList;
    }

    @XmlTransient
    public List<QuestionAnswer> getQuestionAnswerList() {
        return questionAnswerList;
    }

    public void setQuestionAnswerList(List<QuestionAnswer> questionAnswerList) {
        this.questionAnswerList = questionAnswerList;
    }

    @XmlTransient
    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    @XmlTransient
    public List<Room> getRoomList1() {
        return roomList1;
    }

    public void setRoomList1(List<Room> roomList1) {
        this.roomList1 = roomList1;
    }

    @XmlTransient
    public List<Room> getRoomList2() {
        return roomList2;
    }

    public void setRoomList2(List<Room> roomList2) {
        this.roomList2 = roomList2;
    }

    public Role getIdRole() {
        return idRole;
    }

    public void setIdRole(Role idRole) {
        this.idRole = idRole;
    }

    public Department getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(Department idDepartment) {
        this.idDepartment = idDepartment;
    }

    @XmlTransient
    public List<Questioner> getQuestionerList() {
        return questionerList;
    }

    public void setQuestionerList(List<Questioner> questionerList) {
        this.questionerList = questionerList;
    }

    @XmlTransient
    public List<Questioner> getQuestionerList1() {
        return questionerList1;
    }

    public void setQuestionerList1(List<Questioner> questionerList1) {
        this.questionerList1 = questionerList1;
    }

    @XmlTransient
    public List<QuestionerDetail> getQuestionerDetailList() {
        return questionerDetailList;
    }

    public void setQuestionerDetailList(List<QuestionerDetail> questionerDetailList) {
        this.questionerDetailList = questionerDetailList;
    }

    @XmlTransient
    public List<QuestionerDetail> getQuestionerDetailList1() {
        return questionerDetailList1;
    }

    public void setQuestionerDetailList1(List<QuestionerDetail> questionerDetailList1) {
        this.questionerDetailList1 = questionerDetailList1;
    }

    @XmlTransient
    public List<Consultation> getConsultationList() {
        return consultationList;
    }

    public void setConsultationList(List<Consultation> consultationList) {
        this.consultationList = consultationList;
    }

    @XmlTransient
    public List<Consultation> getConsultationList1() {
        return consultationList1;
    }

    public void setConsultationList1(List<Consultation> consultationList1) {
        this.consultationList1 = consultationList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.treatu.TreatUArtifact.entity.Users[ idUser=" + idUser + " ]";
    }
    
}
