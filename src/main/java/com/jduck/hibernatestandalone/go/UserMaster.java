/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jduck.hibernatestandalone.go;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author msdeveloper
 */
@Entity
@Table(name = "user_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserMaster.findAll", query = "SELECT u FROM UserMaster u")
    , @NamedQuery(name = "UserMaster.findByUserid", query = "SELECT u FROM UserMaster u WHERE u.userid = :userid")
    , @NamedQuery(name = "UserMaster.findByFirstname", query = "SELECT u FROM UserMaster u WHERE u.firstname = :firstname")
    , @NamedQuery(name = "UserMaster.findByLastname", query = "SELECT u FROM UserMaster u WHERE u.lastname = :lastname")
    , @NamedQuery(name = "UserMaster.findByMobile", query = "SELECT u FROM UserMaster u WHERE u.mobile = :mobile")})
public class UserMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userid")
    private Integer userid;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "mobile")
    private String mobile;

    public UserMaster() {
    }

    public UserMaster(  String firstname, String lastname, String mobile) {
      
        this.firstname = firstname;
        this.lastname = lastname;
        this.mobile = mobile;
    }

    public UserMaster(Integer userid) {
        this.userid = userid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserMaster)) {
            return false;
        }
        UserMaster other = (UserMaster) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jduck.hibernatestandalone.go.UserMaster[ userid=" + userid + " ]";
    }
    
}
