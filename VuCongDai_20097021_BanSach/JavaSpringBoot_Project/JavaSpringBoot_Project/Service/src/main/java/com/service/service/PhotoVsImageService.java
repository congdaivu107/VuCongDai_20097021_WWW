/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.service;

import com.service.dao.PhotoVsImageDAO;
import com.service.entity.Image;
import com.service.entity.Photo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author longt
 */
@Service
public class PhotoVsImageService {
    
    @Autowired
    private PhotoVsImageDAO dao;

    public List<Photo> getListPhoto(int maKH) {
        return dao.getListPhoto(maKH);
    }

    public List<Image> getListImage(int maSach) {
        return dao.getListImage(maSach);
    }

    public void savePhoto(Photo photo) {
        dao.savePhoto(photo);
    }

    public void saveImage(Image image) {
        dao.saveImage(image);
    }

    public Photo getPhoto(int id) {
        return dao.getPhoto(id);
    }

    public void deletePhoto(Photo photo) {
        dao.deletePhoto(photo);
    }
    
    public void deletePhotoByIdKhachHang(int id){
        dao.deletePhotoByIdKhachHang(id);
    }

    public Image getImage(int id) {
        return dao.getImage(id);
    }

    public void deleteImage(Image image) {
        dao.deleteImage(image);
    }
    
    public void deleteImageByIdBook(int id){
        dao.deleteImageByIdBook(id);
    }
}
