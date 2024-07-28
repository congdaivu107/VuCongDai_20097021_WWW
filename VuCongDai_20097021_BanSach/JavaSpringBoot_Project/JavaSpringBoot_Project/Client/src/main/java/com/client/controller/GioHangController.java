/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.controller;

import com.client.entity.GioHang;
import com.client.entity.Image;
import com.client.entity.KhachHang;
import com.client.entity.Sach;
import com.client.model.ItemCart;
import com.client.service.GioHangService;
import com.client.service.KhachHangService;
import com.client.service.PhotoService;
import com.client.service.SachService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author longt
 */
@Controller
@RequestMapping("/cart")
public class GioHangController {

    @Autowired
    private GioHangService service;

    @Autowired
    private KhachHangService serviceKH;

    @Autowired
    private SachService serviceS;

    @Autowired
    private PhotoService servicePT;

    @GetMapping({"/show", "/"})
    public String showCart(Model model) {
        String s = SecurityContextHolder.getContext().getAuthentication().getName();
        KhachHang khachHang = null;
        List<GioHang> list = null;
        try {
            khachHang = serviceKH.getKhachHang(s);
            list = service.getGioHangByMaKH(khachHang.getMaKhacHang());
        } catch (Exception e) {
            System.out.println("*** SERVICE ERROR");
        }
        List<ItemCart> itemCarts = new ArrayList<>();
        List<Image> images;
        Image image = null;
        ItemCart item;
        for (GioHang gioHang : list) {
            try {
                images = servicePT.getListImage(gioHang.getMaSach().getMaSach());
                image = images.get(0);
            } catch (Exception e) {
            }
            item = new ItemCart(gioHang, image);
            itemCarts.add(item);
            System.out.println("***com.client.controller.GioHangController.showCart():" + item);
        }
        model.addAttribute("itemCarts", itemCarts);
        return "cart";
    }

    @GetMapping("/delete")
    public String deleteItem(Model model, @RequestParam(name = "id") String id) {
        KhachHang khachHang;
        try {
            int ID = Integer.parseInt(id);
            String s = SecurityContextHolder.getContext().getAuthentication().getName();
            khachHang = serviceKH.getKhachHang(s);
            service.deleteItem(khachHang.getMaKhacHang(), ID);
        } catch (NumberFormatException e) {
            return "redirect:/Client/cart/";
        }
//        List<GioHang> list;
//        try {
//            list = service.getGioHangByMaKH(khachHang.getMaKhacHang());
//        } catch (Exception e) {
//            System.out.println("*** SERVICE ERROR");
//            list = new ArrayList<>();
//        }
//        model.addAttribute("gioHang", list);
        return "redirect:/cart/";
    }

    @GetMapping("/add")
    private String addSach(Model model, @RequestParam(name = "maSach") String maSach, @RequestParam(name = "quanity") String soLuong) {
        KhachHang khachHang;
        String s = SecurityContextHolder.getContext().getAuthentication().getName();
        khachHang = serviceKH.getKhachHang(s);
        try {
            int MASACH = Integer.parseInt(maSach);
            int SOLUONG = Integer.parseInt(soLuong);
            String GHICHU = "Ngay mua: " + LocalDate.now();
            Sach sach = serviceS.getSach(MASACH);
            GioHang gioHang = new GioHang(khachHang, sach, SOLUONG, GHICHU);
            service.addGioHang(gioHang);
        } catch (NumberFormatException e) {
            return "redirect:/home";
        } finally {
            return "redirect:/cart/";
        }
    }
}
