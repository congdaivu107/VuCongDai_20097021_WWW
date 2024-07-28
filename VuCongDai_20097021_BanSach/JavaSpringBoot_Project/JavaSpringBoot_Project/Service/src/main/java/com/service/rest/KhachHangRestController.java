/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.rest;

import com.service.entity.KhachHang;
import com.service.exception.CustomNotFoundException;
import com.service.service.KhachHangService;
import com.service.service.PhotoVsImageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
public class KhachHangRestController {

    @Autowired
    private KhachHangService service;
    
    @Autowired
    private PhotoVsImageService servicePTIM;

    @GetMapping("/customers")
    public List<KhachHang> getListKhachHang() {
        List<KhachHang> list = service.getListKhachHang();
        return list;
    }

    @GetMapping("/customers/{id}")
    public KhachHang getKhachHang(@PathVariable int id) {
        KhachHang khachHang = service.getKhachHang(id);
        if (khachHang == null) {
            throw new CustomNotFoundException("Khach hang khong tim thay (ID:" + id + ")");
        }
        return khachHang;
    }

    @GetMapping("/customers/username/{user}")
    public KhachHang getKhachHangByTaiKhoan(@PathVariable("user") String user) {
        try {
            KhachHang khachHang = service.getKhachHangByTaiKhoan(user);
            return khachHang;
        } catch (Exception e) {
            throw new CustomNotFoundException("Khach hang khong tim thay (user:" + user + ")");
        }
    }

    @PostMapping("/customers")
    public KhachHang addKhachHang(@RequestBody KhachHang khachHang) {
        khachHang.setMaKhachHang(0);
        khachHang = service.saveKhachHang(khachHang);
        return khachHang;
    }

    @PutMapping("/customers")
    public KhachHang updateKhachHang(@RequestBody KhachHang khachHang) {
        khachHang = service.saveKhachHang(khachHang);
        return khachHang;
    }

    @DeleteMapping("/customers/{id}")
    public String deleteKhachHang(@PathVariable int id) {
        KhachHang khachHang = service.getKhachHang(id);
        if (khachHang == null) {
            throw new CustomNotFoundException("Khach hang khong tim thay (ID:" + id + ")");
        }
        servicePTIM.deletePhotoByIdKhachHang(id);
        service.deleteKhachHang(khachHang);
        return "Khach hang xoa thanh cong (ID:" + id + ")";
    }
}
