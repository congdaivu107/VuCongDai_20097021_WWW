/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.dao;

import com.service.entity.GioHang;
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
public class GioHangDAO implements GioHangInterfaceDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<GioHang> getListGioHang() {
        Session session = null;
        String sqlString = "SELECT * FROM [dbo].[GioHang]";
        try {
            session = sessionFactory.getCurrentSession();
            return session.createNativeQuery(sqlString, GioHang.class).getResultList();
        } catch (HibernateException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
                session = sessionFactory.openSession();
            }
            return session.createNativeQuery(sqlString, GioHang.class).getResultList();
        }
    }

    @Override
    public List<GioHang> getGioHang(int id) {
        Session session = null;
        String sqlString = "SELECT * FROM [dbo].[GioHang] WHERE [maKhacHang] = " + id;
        try {
            session = sessionFactory.getCurrentSession();
            return session.createNativeQuery(sqlString, GioHang.class).getResultList();
        } catch (HibernateException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
                session = sessionFactory.openSession();
            }
            return session.createNativeQuery(sqlString, GioHang.class).getResultList();
        }

    }

    @Override
    public void saveGioHang(GioHang gh) {
        int maKH = gh.getMaKhachHang().getMaKhachHang();
        int maSach = gh.getMaSach().getMaSach();
        GioHang gh1 = null;
        try {
            gh1 = getGioHang(maKH, maSach);
        } catch (Exception e) {
        }
        Session session = null;
        String sqlString = "INSERT INTO [dbo].[GioHang]([maKhacHang],[maSach],[SoLuong],[ghiChu])\n"
                + "VALUES (" + maKH + "," + maSach + "," + gh.getSoLuong() + ",'" + gh.getGhiChu() + "')";
        String sqlString2 = "UPDATE [dbo].[GioHang] SET [SoLuong] = " + gh.getSoLuong() + " ,[ghiChu] = '" + gh.getGhiChu() + "'\n"
                + "WHERE [maKhacHang] = " + maKH + " AND [maSach] = " + maSach;
        try {
            session = sessionFactory.getCurrentSession();
            if (gh1 == null) {
                System.out.println("***com.service.dao.GioHangDAO.saveGioHang() 1:" + sqlString);
                session.createNativeQuery(sqlString, GioHang.class).executeUpdate();
            } else {
                System.out.println("***com.service.dao.GioHangDAO.saveGioHang() 2:" + sqlString2);
                session.createNativeQuery(sqlString2, GioHang.class).executeUpdate();
            }
        } catch (HibernateException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
                session = sessionFactory.openSession();
                Transaction trans = session.beginTransaction();
                if (gh1 == null) {
                    System.out.println("***com.service.dao.GioHangDAO.saveGioHang() 3:" + sqlString);
                    session.createNativeQuery(sqlString, GioHang.class).executeUpdate();
                } else {
                    System.out.println("***com.service.dao.GioHangDAO.saveGioHang() 4:" + sqlString2);
                    session.createNativeQuery(sqlString2, GioHang.class).executeUpdate();
                }
                trans.commit();
            }
        }

    }
    
    @Override
    public void deleteGioHang(int maSach){
        Session session = null;
        String sqlString = "DELETE FROM [dbo].[GioHang] WHERE [maSach] = "+maSach;
        try {
            session = sessionFactory.getCurrentSession();
            session.createNativeQuery(sqlString, GioHang.class).executeUpdate();
        } catch (HibernateException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
                session = sessionFactory.openSession();
            }
            Transaction trans = session.beginTransaction();
            session.createNativeQuery(sqlString, GioHang.class).executeUpdate();
            trans.commit();
        }
    }

    @Override
    public void deleteGioHang(GioHang gh) {
        Session session = null;
        String sqlString = "DELETE FROM [dbo].[GioHang] WHERE [maKhacHang] = " + gh.getMaKhachHang().getMaKhachHang() + " AND [maSach] = " + gh.getMaSach().getMaSach();
        try {
            session = sessionFactory.getCurrentSession();
            session.createNativeQuery(sqlString, GioHang.class).executeUpdate();
        } catch (HibernateException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
                session = sessionFactory.openSession();
            }
            Transaction trans = session.beginTransaction();
            session.createNativeQuery(sqlString, GioHang.class).executeUpdate();
            trans.commit();
        }
    }

    @Override
    public GioHang getGioHang(int id, int maSach) {
        Session session = null;
        String sqlString = "SELECT * FROM [dbo].[GioHang] WHERE [maKhacHang] = " + id + " AND [maSach] = " + maSach;
        try {
            session = sessionFactory.getCurrentSession();
            return session.createNativeQuery(sqlString, GioHang.class).getSingleResult();
        } catch (HibernateException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
                session = sessionFactory.openSession();
            }
            return session.createNativeQuery(sqlString, GioHang.class).getSingleResult();
        }

    }

}
