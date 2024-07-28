/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.service;

import com.client.entity.Image;
import com.client.entity.Photo;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author longt
 */
@Service
public class PhotoService {

    private RestTemplate restTemplate;
    private String url;

    public PhotoService(RestTemplate restTemplate, @Value("${config.application.url.service.rest.PhotoVsImage}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public Photo savePhoto(Photo photo) {
        ResponseEntity<Photo> respon = null;
        if (photo.getIdPhoto() == 0) {
            respon = restTemplate.postForEntity(url + "/photos", photo, Photo.class);
        } else {
            restTemplate.put(url + "/photos", photo);
            return photo;
        }
        return respon.getBody();
    }

    public Image saveImage(Image image) {
        ResponseEntity<Image> respon = null;
        if (image.getIdPhoto() == 0) {
            respon = restTemplate.postForEntity(url + "/images", image, Image.class);
        } else {
            restTemplate.put(url + "/images", image);
            return image;
        }
        return respon.getBody();
    }

    public List<Photo> getListPhoto(int i) {
        ResponseEntity<List<Photo>> repon = restTemplate.exchange(url + "/photos/" + i, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<Photo>>() {
        });
        return repon.getBody();
    }

    public List<Image> getListImage(int i) {
        ResponseEntity<List<Image>> respon = restTemplate.exchange(url + "/images/" + i, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<Image>>() {
        });
        return respon.getBody();
    }

    public void deletePhoto(int id) {
        restTemplate.delete(url+"/photos/"+id);
    }

    public void deleteImage(int id) {
        restTemplate.delete(url+"/images/"+id);
    }
}
