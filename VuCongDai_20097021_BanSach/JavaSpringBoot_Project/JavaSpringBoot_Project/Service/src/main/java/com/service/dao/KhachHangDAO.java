/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.dao;

import com.service.entity.KhachHang;
import java.util.List;
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
public class KhachHangDAO implements KhachHangInterfaceDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<KhachHang> getListKhachHang() {
        Session session = null;
        String sqlString = "SELECT * FROM [dbo].[KhachHang]";
        try {
            session = sessionFactory.getCurrentSession();
            return session.createNativeQuery(sqlString, KhachHang.class).getResultList();
        } catch (HibernateException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
                session = sessionFactory.openSession();
            }
        }
        return session.createNativeQuery(sqlString, KhachHang.class).getResultList();
    }

    @Override
    public KhachHang getKhachHang(int id) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            return session.find(KhachHang.class, id);
        } catch (Exception e) {
            if (session != null && session.isOpen()) {
                session.close();
                session = sessionFactory.openSession();
            }
            return session.find(KhachHang.class, id);
        }        
    }

    @Override
    public KhachHang saveKhachHang(KhachHang khachHang) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(khachHang);
        } catch (Exception e) {
            if (session != null && session.isOpen()) {
                session.close();
                session = sessionFactory.openSession();
            }
            Transaction trans = session.beginTransaction();
            session.saveOrUpdate(khachHang);
            trans.commit();
        }
        return khachHang;
    }

    @Override
    public void deleteKhachHang(KhachHang khachHang) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.delete(khachHang);
        } catch (Exception e) {
            if (session != null && session.isOpen()) {
                session.close();
                session = sessionFactory.openSession();
            }
            session.delete(khachHang);
        }        
    }

    @Override
    public KhachHang getKhachHangByTaiKhoan(String user) {
        Session session = null;
        String sqlString = "SELECT * FROM [dbo].[KhachHang]\n"
                + "WHERE [maKhachHang] = ( SELECT [maKhachHang] FROM [dbo].[TaiKhoan] WHERE [taiKhoan] like '" + user + "')";
        try {
            session = sessionFactory.getCurrentSession();
            return session.createNativeQuery(sqlString, KhachHang.class).getResultList().get(0);
        } catch (HibernateException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
                session = sessionFactory.openSession();
            }
            return session.createNativeQuery(sqlString, KhachHang.class).getResultList().get(0);
        }
    }

}
