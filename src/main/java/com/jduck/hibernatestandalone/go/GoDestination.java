/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jduck.hibernatestandalone.go;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author msdeveloper
 */
public class GoDestination {

    /* public static void main(String[] args) {
         select().subList(1, select().size() - 1).forEach((userMaster) -> {
            System.out.println(userMaster.getUserid() + ">>" + userMaster.getFirstname()+ ">>" + userMaster.getLastname()
                    + " >> " + userMaster.getMobile());
        });

        for (int i = 11000; i < 50000; i++) {
            add(i);
        }

        UserMaster userMaster = getSelectById(48000);
        if (userMaster != null) {
            System.out.println(userMaster.getUserid() + ">>" + userMaster.getFirstname() + ">>" + userMaster.getLastname()
                    + " >> " + userMaster.getMobile());
        }

    }*/

    private static void add(int i) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            UserMaster um = new UserMaster("Your First Name " + i, "Your Last Name " + i, "111110000" + i);
            session.save(um);
            tx.commit();
            session.flush();
            session.close();
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(GoDestination.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void edit(int id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            UserMaster umOld = (UserMaster) session.load(UserMaster.class, id);
            if (umOld != null && umOld.getUserid() > 0) {
                UserMaster umNew = new UserMaster();
                umNew.setUserid(umOld.getUserid());
                umNew.setFirstname("Updated First Name-> " + id);
                umNew.setLastname("Updated Last Name-> " + id);
                umNew.setMobile("9867653XXX" + id);
                session.merge(umNew);
            }

            tx.commit();
            session.flush();
            session.close();
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(GoDestination.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void delete(int id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            UserMaster umOld = (UserMaster) session.load(UserMaster.class, id);
            if (umOld != null && umOld.getUserid() > 0) {

                session.delete(umOld);
            }

            tx.commit();
            session.flush();
            session.close();
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(GoDestination.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static List<UserMaster> select() {
        List<UserMaster> umFinal = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            umFinal = session.createQuery("From UserMaster").list();
            session.flush();
            session.close();

            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(GoDestination.class.getName()).log(Level.SEVERE, null, ex);
        }
        return umFinal;
    }

    private static UserMaster getSelectById(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        UserMaster umFinal = (UserMaster) session.get(UserMaster.class, id);
        session.flush();
        session.close();

        // Thread.sleep(100);
        return umFinal;
    }
}
