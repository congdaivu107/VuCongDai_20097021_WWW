/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.dao;

import com.service.entity.Sach;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author longt
 */
@Repository
public class InfoDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveInfo(int maSach, String string) {
        Session session = null;
        String sqlString = "INSERT INTO [dbo].[ThongTinKhac]([Sach_maSach],[thongTinThem])\n"
                + "VALUES (" + maSach + " ,'" + string + "')";
        try {
            session = sessionFactory.getCurrentSession();
            session.createNativeQuery(sqlString).executeUpdate();
        } catch (Exception e) {
            if (session != null && session.isOpen()) {
                session.close();
                session = sessionFactory.openSession();
            }
            Transaction trans = session.beginTransaction();
            session.createNativeQuery(sqlString).executeUpdate();
            trans.commit();
        }
    }

    public Sach getLastBook() {
        Session session = null;
        String sqlString = "SELECT TOP (1) * FROM [dbo].[Sach] ORDER BY [maSach] DESC";
        try {
            session = sessionFactory.getCurrentSession();
            return session.createNativeQuery(sqlString, Sach.class).getSingleResult();
        } catch (HibernateException e) {
            if (session != null && session.isOpen()) {
                session.close();
                session = sessionFactory.openSession();
            }
            return session.createNativeQuery(sqlString, Sach.class).getSingleResult();
        }
    }

    public void deleteSach(int maSach) {
        Session session = null;
        String sqlString = "DELETE FROM [dbo].[ThongTinKhac] WHERE [Sach_maSach] = " + maSach;
        try {
            session = sessionFactory.getCurrentSession();
            session.createNativeQuery(sqlString).executeUpdate();
        } catch (Exception e) {
            if (session != null && session.isOpen()) {
                session.close();
                session = sessionFactory.openSession();
            }
            Transaction trans = session.beginTransaction();
            session.createNativeQuery(sqlString).executeUpdate();
            trans.commit();
        }
    }
}
