/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.controller;

import com.client.entity.KhachHang;
import com.client.entity.Photo;
import com.client.entity.TaiKhoan;
import com.client.model.ItemAccount;
import com.client.model.ItemProfile;
import com.client.service.KhachHangService;
import com.client.service.PhotoService;
import com.client.service.TaiKhoanService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author longt
 */
@Controller
@RequestMapping("/profile")
public class KhachHangController {

    @Autowired
    private KhachHangService service;

    @Autowired
    private TaiKhoanService serviceTK;

    @Autowired
    private PhotoService servicePT;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping({"/show", "/"})
    public String startProfile(Model model) {
        KhachHang khachHang = null;
        List<Photo> listPhoto = null;
        Photo t1 = null, t2 = null, t3 = null;
        try {
            String s = SecurityContextHolder.getContext().getAuthentication().getName();
            khachHang = service.getKhachHang(s);
            listPhoto = servicePT.getListPhoto(khachHang.getMaKhacHang());
            int size = listPhoto.size();
            t1 = listPhoto.get((int) (Math.random() * size));
            t2 = listPhoto.get((int) (Math.random() * size));
            t3 = listPhoto.get((int) (Math.random() * size));
        } catch (Exception e) {
        }
        model.addAttribute("phot1", t1);
        model.addAttribute("phot2", t2);
        model.addAttribute("phot3", t3);
        model.addAttribute("listPhoto", listPhoto);
        model.addAttribute("khachHang", khachHang);
        return "profile";
    }

    @GetMapping("/changeProfile")
    public String startChangeProfile(Model model) {
        KhachHang khachHang = null;
        ItemProfile profile = new ItemProfile();
        try {
            String s = SecurityContextHolder.getContext().getAuthentication().getName();
            khachHang = service.getKhachHang(s);
            profile = new ItemProfile(khachHang.getFirstName(), khachHang.getLastName(), khachHang.getEmail(), khachHang.getAddress(), khachHang.getPhone(), khachHang.getBirthDate());

        } catch (Exception e) {
        }
        model.addAttribute("profile", profile);
        return "changeProfile";
    }

    @RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
    public String updateProfile(Model model, @Valid @ModelAttribute ItemProfile profile) {
        KhachHang khachHang = null;
        try {
            String s = SecurityContextHolder.getContext().getAuthentication().getName();
            khachHang = service.getKhachHang(s);
            khachHang.setFirstName(profile.getFirstName());
            khachHang.setLastName(profile.getLastName());
            khachHang.setEmail(profile.getEmail());
            khachHang.setAddress(profile.getAddress());
            khachHang.setPhone(profile.getPhone());
            khachHang.setBirthDate(profile.getBirthDate());
            service.saveKhachHang(khachHang);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/profile/show";
    }

    @GetMapping("/changePass")
    public String startChangePass(Model model) {
        ItemAccount account = new ItemAccount();
        model.addAttribute("ItemAccount", account);
        return "changePass";
    }

    @RequestMapping(value = "/updatePass", method = RequestMethod.POST)
    public String updatePassWord(Model model, @Valid @ModelAttribute ItemAccount account) {
        KhachHang khachHang = null;
        try {
            String s = SecurityContextHolder.getContext().getAuthentication().getName();
            khachHang = service.getKhachHang(s);
            TaiKhoan t;
            t = serviceTK.getTaiKhoan(khachHang.getMaKhacHang());
            if (!account.getPassword1().equals(account.getPassword2())) {
                account.setPassword1("");
                account.setPassword2("");
                model.addAttribute("ItemAccount", account);
                return "changePass";
            }
            String MKc, MKm;
            MKc = t.getPassword();
            MKm = "{bcrypt}" + passwordEncoder.encode(account.getUsername());
            if (MKc.equals(MKm)) {
                account.setUsername("");
                model.addAttribute("ItemAccount", account);
                return "changePass";
            }
            t.setPassword("{bcrypt}" + passwordEncoder.encode(account.getPassword2()));
            serviceTK.saveTaiKhoan(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("khachHang", khachHang);
        return "redirect:/profile/show";
    }
}
