/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.dao;

import com.service.entity.Image;
import com.service.entity.Photo;
import java.util.List;
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
public class PhotoVsImageDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Photo> getListPhoto(int maKH) {
        Session session = null;
        String sqlString = "SELECT * FROM [dbo].[Photo] WHERE [maKhachHang] = " + maKH;
        try {
            session = sessionFactory.getCurrentSession();
            return session.createNativeQuery(sqlString, Photo.class).getResultList();
        } catch (Exception e) {
            if (session != null && session.isOpen()) {
                session.close();
                session = sessionFactory.openSession();
            }
            return session.createNativeQuery(sqlString, Photo.class).getResultList();
        }
    }

    public List<Image> getListImage(int maSach) {
        Session session = null;
        String sqlString = "SELECT * FROM [dbo].[Image] WHERE [maSach] = " + maSach;
        try {
            session = sessionFactory.getCurrentSession();
            return session.createNativeQuery(sqlString, Image.class).getResultList();
        } catch (Exception e) {
            if (session != null && session.isOpen()) {
                session.close();
                session = sessionFactory.openSession();
            }
            if(!session.isOpen()){
                session =sessionFactory.openSession();
            }
            return session.createNativeQuery(sqlString, Image.class).getResultList();
        }
    }

    public void savePhoto(Photo photo) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(photo);
        } catch (Exception e) {
            if (session != null && session.isOpen()) {
                session.close();
                session = sessionFactory.openSession();
            }
            Transaction trans = session.beginTransaction();
            session.saveOrUpdate(photo);
            trans.commit();
        }
    }

    public void saveImage(Image image) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(image);
        } catch (Exception e) {
            if (session != null && session.isOpen()) {
                session.close();
                session = sessionFactory.openSession();
            }
            Transaction trans = session.beginTransaction();
            session.saveOrUpdate(image);
            trans.commit();
        }
    }

    public Photo getPhoto(int id) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            return session.find(Photo.class, id);
        } catch (Exception e) {
            if (session != null && session.isOpen()) {
                session.close();
                session = sessionFactory.openSession();
            }
            return session.find(Photo.class, id);
        }
    }

    public void deletePhoto(Photo photo) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.delete(photo);
        } catch (Exception e) {
            if (session != null && session.isOpen()) {
                session.close();
                session = sessionFactory.openSession();
            }
            Transaction trans = session.beginTransaction();
            session.delete(photo);
            trans.commit();
        }
    }

    public Image getImage(int id) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            return session.find(Image.class, id);
        } catch (Exception e) {
            if (session != null && session.isOpen()) {
                session.close();
                session = sessionFactory.openSession();
            }
            return session.find(Image.class, id);
        }
    }

    public void deleteImage(Image image) {
        Session session = null;
        String sqlString = "";
        try {
            session = sessionFactory.getCurrentSession();
            session.delete(image);
        } catch (Exception e) {
            if (session != null && session.isOpen()) {
                session.close();
                session = sessionFactory.openSession();
            }
            Transaction trans = session.beginTransaction();
            session.delete(image);
            trans.commit();
        }
    }

    public void deleteImageByIdBook(int id) {
        Session session = null;
        String sqlString = "DELETE FROM [dbo].[Image] WHERE [maSach] = " + id;
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

    public void deletePhotoByIdKhachHang(int id) {
        Session session = null;
        String sqlString = "DELETE FROM [dbo].[Photo] WHERE [maKhachHang] = " + id;
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
