/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.service;

import com.client.entity.KhachHang;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author longt
 */
@Service
public class KhachHangService {

    private RestTemplate restTemplate;
    private String url;

    private KhachHangService(RestTemplate restTemplate, @Value("${config.application.url.service.rest.customer}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public KhachHang getKhachHang(int id) {
        return restTemplate.getForObject(url+"/"+id, KhachHang.class);
    }
    
    public KhachHang getKhachHang(String s) {
        return restTemplate.getForObject(url+"/username/"+s, KhachHang.class);
    }

    public KhachHang saveKhachHang(KhachHang khachHang) {
        ResponseEntity<KhachHang> repon = null;
        if (khachHang.getMaKhacHang() == 0) {
            repon = restTemplate.postForEntity(url, khachHang, KhachHang.class);
        } else {
            restTemplate.put(url, khachHang);
            return khachHang;
        }
        return repon.getBody();
    }

    public void addAttribute(String idKhachHang, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
