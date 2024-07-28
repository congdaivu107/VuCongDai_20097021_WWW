/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.service;

import com.client.entity.Sach;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SachService implements SachServiceInterface {

    private RestTemplate restTemplate;
    private String url;

    @Autowired
    public SachService(RestTemplate restTemplate, @Value("${config.application.url.service.rest.books}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    @Override
    public List<Sach> getSach() {
        ResponseEntity<List<Sach>> respon = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<Sach>>() {
        });
        List<Sach> list = respon.getBody();
        return list;
    }

    public Sach getSach(int id) {
        return restTemplate.getForObject(url + "/" + id, Sach.class);
    }

    public List<Sach> getSachSearch(String q) {
        ResponseEntity<List<Sach>> respon = restTemplate.exchange(url + "/search/" + q, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<Sach>>() {
        });
        return respon.getBody();
    }

    public void deleteSach(int num) {
        restTemplate.delete(url + "/" + num);
    }

    public Sach saveSach(Sach sach) {
        ResponseEntity<Sach> respon;
        if (sach.getMaSach() == 0) {
            respon = restTemplate.postForEntity(url, sach, Sach.class);
        }else{
            restTemplate.put(url, sach);
            return sach;
        }
        return respon.getBody();
    }

}
