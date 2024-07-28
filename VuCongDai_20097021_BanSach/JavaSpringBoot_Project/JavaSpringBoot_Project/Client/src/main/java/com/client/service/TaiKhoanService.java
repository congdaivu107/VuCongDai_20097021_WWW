/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.service;

import com.client.entity.TaiKhoan;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author longt
 */
@Service
public class TaiKhoanService {

    private RestTemplate restTemplate;
    private String url;

    public TaiKhoanService(RestTemplate restTemplate, @Value("${config.application.url.service.rest.accounts}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public List<TaiKhoan> listTaiKhoan() {
        ResponseEntity<List<TaiKhoan>> respon = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<TaiKhoan>>() {
        });
        return respon.getBody();
    }

    public TaiKhoan getTaiKhoan(int id) {
        return restTemplate.getForObject(url + "/" + id, TaiKhoan.class);
    }

    public TaiKhoan saveTaiKhoan(TaiKhoan taiKhoan) {
        ResponseEntity<TaiKhoan> respon;
        if (taiKhoan.getIdTaiKhoan() == 0) {
            respon = restTemplate.postForEntity(url, taiKhoan, TaiKhoan.class);
        } else {
            restTemplate.put(url, taiKhoan);
            return taiKhoan;
        }
        return respon.getBody();
    }

    public void deleteTaiKhoan(int taiKhoan) {
        restTemplate.delete(url + "/" + taiKhoan);
    }

    public boolean checkTaiKhoan(String username) {
        return restTemplate.getForObject(url + "/check/" + username, Boolean.class);
    }
}
