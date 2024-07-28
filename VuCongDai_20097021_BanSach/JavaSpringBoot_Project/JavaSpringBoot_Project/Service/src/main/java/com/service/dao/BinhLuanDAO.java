/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.dao;

import com.service.entity.BinhLuan;
import com.service.exception.CustomNotFoundException;
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
public class BinhLuanDAO implements BinhLuanInterfaceDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public BinhLuan getBinhLuan(int id) {
        Session session;
        BinhLuan binhLuan = null;
        try {
            session = sessionFactory.getCurrentSession();
            binhLuan = session.find(BinhLuan.class, id);
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        try {
            binhLuan = session.find(BinhLuan.class, id);            
        } catch (Exception e) {
            throw new CustomNotFoundException("Khong tim thay binh luan (ID:"+id+")");
        }
        return binhLuan;
    }

    @Override
    public void saveBinhLuan(BinhLuan binhLuan) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(binhLuan);
        } catch (Exception e) {
            if(session != null&& session.isOpen()){
                session = sessionFactory.openSession();
            }
            Transaction trans = session.beginTransaction();
            session.saveOrUpdate(binhLuan);
            trans.commit();
        }        
    }

    @Override
    public void deleteBinhLuan(BinhLuan binhLuan) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.delete(binhLuan);
        } catch (Exception e) {
            if(session != null&& session.isOpen()){
                session = sessionFactory.openSession();
            }
            Transaction trans = session.beginTransaction();
            session.delete(binhLuan);
            trans.commit();
        }
    }

    public List<BinhLuan> getLitBinhLuan() {
        Session session = null;
        String sqlString = "SELECT * FROM [dbo].[BinhLuan]";
        try {
            session = sessionFactory.getCurrentSession();
            return session.createNativeQuery(sqlString, BinhLuan.class).getResultList();
        } catch (Exception e) {
            if(session != null&& session.isOpen()){
                session = sessionFactory.openSession();
            }
            return session.createNativeQuery(sqlString, BinhLuan.class).getResultList();
        }
    }

}
