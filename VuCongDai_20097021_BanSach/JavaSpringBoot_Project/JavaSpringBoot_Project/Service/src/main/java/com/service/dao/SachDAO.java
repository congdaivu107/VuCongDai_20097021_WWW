/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.dao;

import com.service.entity.Sach;
import java.util.List;
import java.util.Set;
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
public class SachDAO implements SachInterfaceDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Sach> getListSach() {
        Session session = null;
        String sqlString = "SELECT * FROM [dbo].[Sach]";
        try {
            session = sessionFactory.getCurrentSession();
            return session.createNativeQuery(sqlString, Sach.class).getResultList();
        } catch (Exception e) {
            if (session != null && session.isOpen()) {
                session.close();
                session = sessionFactory.openSession();
            }
            return session.createNativeQuery(sqlString, Sach.class).getResultList();
        }
    }

    @Override
    public Sach getSach(int id) {
        Session session = null;
        Sach sach = null;
        try {
            session = sessionFactory.getCurrentSession();
            sach = session.find(Sach.class, id);
        } catch (Exception e) {
            if (session != null && session.isOpen()) {
                session.close();
                session = sessionFactory.openSession();
            }
            sach = session.find(Sach.class, id);
        }
        return sach;
    }

    @Override
    public Sach saveSach(Sach s) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(s);
        } catch (Exception e) {
            if (session != null && session.isOpen()) {
                session.close();
                session = sessionFactory.openSession();
            }
            Transaction trans = session.beginTransaction();
            session.saveOrUpdate(s);
            trans.commit();
        }
        return s;
    }

    @Override
    public void deleteSach(Sach sach) {
        Session session = null;
        String sqlString = "DELETE FROM [dbo].[Sach] WHERE [maSach] = " + sach.getMaSach();
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

    @Override
    public List<Sach> getListSach(String q) {
        Session session = null;
        String sqlString = "SELECT * FROM [dbo].[Sach] \n"
                + "WHERE CHARINDEX('" + q + "',[tenSach]) > 0 \n"
                + "OR CHARINDEX('" + q + "',[tacGia]) > 0 \n"
                + "OR CHARINDEX('" + q + "',[mieuTa]) > 0\n"
                + "OR [maSach] in (SELECT [maSach] FROM [dbo].[ThongTinKhac] WHERE CHARINDEX('" + q + "',[thongTinThem]) >0 )";
        try {
            session = sessionFactory.getCurrentSession();
            return session.createNativeQuery(sqlString, Sach.class).getResultList();
        } catch (HibernateException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
                session = sessionFactory.openSession();
            }
            return session.createNativeQuery(sqlString, Sach.class).getResultList();
        }
    }

}
