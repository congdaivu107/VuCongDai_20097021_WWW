/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.rest;

import com.service.entity.Image;
import com.service.entity.Photo;
import com.service.exception.CustomNotFoundException;
import com.service.service.PhotoVsImageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author longt
 */
@RestController
@RequestMapping("/api")
public class PhotoVsImageRestController {
    
    @Autowired
    private PhotoVsImageService service;
    
    @GetMapping("/photovsimage/photos/{maKhachHang}")
    public List<Photo> getListPhoto(@PathVariable int maKhachHang){
        List<Photo> list = null;
        try {
            list = service.getListPhoto(maKhachHang);
        } catch (Exception e) {
        }
        return list;
    }
    
    @GetMapping("/photovsimage/images/{maSach}")
    public List<Image> getListImages(@PathVariable int maSach){
        List<Image> list = null;
        try {
            list = service.getListImage(maSach);
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return list;
    }
    
    @PostMapping("/photovsimage/photos")
    public Photo addPhoto(@RequestBody Photo photo){
        photo.setIdPhoto(0);
        service.savePhoto(photo);
        return photo;
    }
    
    @PostMapping("/photovsimage/images")
    public Image addImage(@RequestBody Image image){
        image.setIdPhoto(0);
        service.saveImage(image);
        return image;
    }
    
    @PutMapping("/photovsimage/photos")
    public Photo updatePhoto(@RequestBody Photo photo){
        service.savePhoto(photo);
        return photo;
    }
    
    @PutMapping("/photovsimage/images")
    public Image updatePhoto(@RequestBody Image image){
        service.saveImage(image);
        return image;
    }
    
    @RequestMapping("/photovsimage/photos/{id}")
    public String deletePhoto(@PathVariable int id){
        Photo photo = service.getPhoto(id);
        if(photo == null){
            throw new CustomNotFoundException("Photo khong tim thay ");
        }
        service.deletePhoto(photo);
        return "Photo da xoa thanh cong";
    }
    
    @RequestMapping("/photovsimage/images/{id}")
    public String deleteImage(@PathVariable int id){
        Image image = service.getImage(id);
        if(image == null){
            throw new CustomNotFoundException("Image khong tim thay ");
        }
        service.deleteImage(image);
        return "Image da xoa thanh cong";
    }
}
