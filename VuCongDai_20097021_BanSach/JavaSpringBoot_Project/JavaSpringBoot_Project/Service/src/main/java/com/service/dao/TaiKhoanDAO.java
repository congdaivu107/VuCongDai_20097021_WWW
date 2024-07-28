/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.dao;

import com.service.entity.TaiKhoan;
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
public class TaiKhoanDAO implements TaiKhoanInterfaceDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<TaiKhoan> getListTaiKhoan() {
        Session session = null;
        String sqlString = "SELECT * FROM [dbo].[TaiKhoan]";
        try {
            session = sessionFactory.getCurrentSession();
            return session.createNativeQuery(sqlString, TaiKhoan.class).getResultList();
        } catch (HibernateException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
                session = sessionFactory.openSession();
            }
            return session.createNativeQuery(sqlString, TaiKhoan.class).getResultList();
        }
    }

    @Override
    public TaiKhoan getTaiKhoan(int id) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            return session.find(TaiKhoan.class, id);
        } catch (Exception e) {
            if(session!=null&&session.isOpen()){
                session.close();
                session = sessionFactory.openSession();                
            }
            return session.find(TaiKhoan.class, id);
        }        
    }

    @Override
    public TaiKhoan saveTaiKhoan(TaiKhoan taiKhoan) {
        Session session = null;
        String sqlString2 = "UPDATE [dbo].[TaiKhoan]\n"
                + "   SET [password] = '" + taiKhoan.getPassword() + "',[role] = '" + taiKhoan.getRole() + "' ,[status] = " + (taiKhoan.isStatus() ? 1 : 0) + " ,[taiKhoan] = '" + taiKhoan.getTaiKhoan() + "',[maKhachHang] = " + taiKhoan.getKhachHang().getMaKhachHang()
                + " WHERE [idTaiKhoan] = " + taiKhoan.getIdTaiKhoan();
        try {
            session = sessionFactory.getCurrentSession();
            if (taiKhoan.getIdTaiKhoan() == 0) {
//                insert
                session.saveOrUpdate(taiKhoan);
            } else {
//                update
                if (!session.isOpen()) {
                    session = sessionFactory.openSession();
                }
                Transaction trans = session.beginTransaction();
                session.createNativeQuery(sqlString2).executeUpdate();
                trans.commit();
            }
        } catch (HibernateException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
                session = sessionFactory.openSession();
            }
            if (taiKhoan.getIdTaiKhoan() == 0) {
//                insert
                session.saveOrUpdate(taiKhoan);
            } else {
//                update
                if (!session.isOpen()) {
                    session = sessionFactory.openSession();
                }
                Transaction trans = session.beginTransaction();
                session.createNativeQuery(sqlString2).executeUpdate();
                trans.commit();
            }
        }
        return taiKhoan;
    }

    @Override
    public void deleteTaiKhoan(TaiKhoan taiKhoan) {
        Session session = null;
        String sqlString = "DELETE FROM [dbo].[TaiKhoan] WHERE idTaiKhoan = "+taiKhoan.getIdTaiKhoan();
        try {
            session = sessionFactory.getCurrentSession();
            session.createNativeQuery(sqlString).executeUpdate();
        } catch (HibernateException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
                session = sessionFactory.openSession();
            }
            if (!session.isOpen()) {
                session = sessionFactory.openSession();
            }
            Transaction trans = session.beginTransaction();
            session.createNativeQuery(sqlString).executeUpdate();
            trans.commit();
        }
    }

    @Override
    public boolean checkTaiKhoan(String username) {
        Session session = null;
        TaiKhoan TK = null;
        String sqlString = "SELECT * FROM [dbo].[TaiKhoan] WHERE [taiKhoan] = '" + username + "'";
        System.out.println("*****SERVER " + sqlString);
        try {
            session = sessionFactory.getCurrentSession();
            TK = session.createNativeQuery(sqlString, TaiKhoan.class).getResultList().get(0);
        } catch (HibernateException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
                session = sessionFactory.openSession();
                try {
                    TK = session.createNativeQuery(sqlString, TaiKhoan.class).getResultList().get(0);
                } catch (Exception e) {
                }
            }
        }
        return TK != null;
    }
}
