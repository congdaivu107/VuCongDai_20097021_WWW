/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.service;

import com.client.entity.BinhLuan;
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
public class BinhLuanService {

    private RestTemplate restTemplate;
    private String url;

    public BinhLuanService(RestTemplate restTemplate, @Value("${config.application.url.service.rest.comments}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public List<BinhLuan> ListBinhLuan() {
        ResponseEntity<List<BinhLuan>> respon = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<BinhLuan>>() {
        });
        return respon.getBody();
    }

    public BinhLuan getBinhLuan(int id) {
        return restTemplate.getForObject(url + "/" + id, BinhLuan.class);
    }

    public BinhLuan saveBinhLuan(BinhLuan binhLuan) {
        ResponseEntity<BinhLuan> respon;
        if (binhLuan.getMaBinhLuan() == 0) {
            respon = restTemplate.postForEntity(url, binhLuan, BinhLuan.class);
        }else{
            restTemplate.put(url, binhLuan);
            return binhLuan;
        }
        return respon.getBody();
    }
    
    public void deleteBinhLuan(int id){
        restTemplate.delete(url+"/"+id);
    }
    
}
