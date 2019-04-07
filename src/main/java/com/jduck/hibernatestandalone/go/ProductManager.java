/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jduck.hibernatestandalone.go;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author msdeveloper
 */
public class ProductManager {

    public static void main(String[] args) {
        for (int i = 10; i < 100000; i++) {
            addProduct(i);
        }
    }

    private static void addProduct(int i) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            Product prod = new Product(UUID.randomUUID().toString(), "Product_Name" + i,
                    "Product_desc_" + i, Math.round(Math.sqrt(i * 10)));
            session.save(prod);
            tx.commit();
            session.flush();
            session.close();
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(GoDestination.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
