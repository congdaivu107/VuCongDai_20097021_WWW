/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.service;

import com.client.entity.GioHang;
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
public class GioHangService {

    private RestTemplate restTemplate;
    private String url;

    public GioHangService(RestTemplate restTemplate, @Value("${config.application.url.service.rest.carts}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public List<GioHang> getGioHangByMaKH(int maKhachHang) {
        ResponseEntity<List<GioHang>> respon = restTemplate.exchange(url+"/"+maKhachHang, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<GioHang>>() {
        });
        return respon.getBody();
    }

    public void deleteItem(int maKhacHang, int id) {
        restTemplate.delete(url+"/"+maKhacHang+"/"+id);
    }

    public void addGioHang(GioHang gioHang) {
        restTemplate.put(url, gioHang);
    }

    public List<GioHang> getAllGioHang() {
        ResponseEntity<List<GioHang>> respon = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<GioHang>>(){});
        return respon.getBody();
    }
}
