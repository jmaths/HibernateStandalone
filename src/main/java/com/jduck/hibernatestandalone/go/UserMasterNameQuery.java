/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jduck.hibernatestandalone.go;

import org.hibernate.Session;

/**
 *
 * @author msdeveloper
 */
public class UserMasterNameQuery {

    public static void main(String[] args) {
        for (int i = 3000; i < 4010; i++) {
            UserMaster userMaster = findByUserid(i);
        if (userMaster != null) {
            System.out.println(userMaster.getUserid() + ">>" + userMaster.getFirstname() + ">>" + userMaster.getLastname()
                    + " >> " + userMaster.getMobile());
        }
        }
        
    }

    public static UserMaster findByUserid(int userId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        UserMaster um = (UserMaster) session.getNamedQuery("UserMaster.findByUserid").setParameter("userid", userId).uniqueResult();
        session.close();
        return um;
    }

}
