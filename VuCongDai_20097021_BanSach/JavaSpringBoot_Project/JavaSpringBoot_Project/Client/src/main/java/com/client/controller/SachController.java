/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.controller;

import com.client.entity.Image;
import com.client.entity.Photo;
import com.client.service.SachService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.client.entity.Sach;
import com.client.model.ItemHomPage;
import com.client.service.KhachHangService;
import com.client.service.PhotoService;
import java.util.ArrayList;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author longt
 */
@Controller
@RequestMapping("/sach")
public class SachController {

    @Autowired
    private SachService service;

    @Autowired
    private KhachHangService serviceKH;

    @Autowired
    private PhotoService servicePT;

    @GetMapping("/shop")
    public String listSach(Model model) {
        List<Sach> list;
        list = service.getSach();
        List<Image> listImage;
        List<ItemHomPage> listItemHomePage = new ArrayList<>();
        Image img = null;
        ItemHomPage item = null;
        for (Sach sach : list) {
            try {
                listImage = servicePT.getListImage(sach.getMaSach());
                img = listImage.get(0);
                item = new ItemHomPage(sach, img);
            } catch (Exception e) {
            }
            listItemHomePage.add(item);
        }
        model.addAttribute("listItemHomePage", listItemHomePage);
        model.addAttribute("numPage", 1);
        return "shop";
    }

    @GetMapping("/search")
    public String listSachSearch(Model model, @RequestParam(name = "q", required = false) String q) {
        List<Sach> list;
        list = service.getSachSearch(q);
        List<Image> listImage;
        List<ItemHomPage> listItemHomePage = new ArrayList<>();
        Image img = null;
        ItemHomPage item = null;
        for (Sach sach : list) {
            try {
                listImage = servicePT.getListImage(sach.getMaSach());
                img = listImage.get(0);
                item = new ItemHomPage(sach, img);
            } catch (Exception e) {
            }
            listItemHomePage.add(item);
        }
        model.addAttribute("listItemHomePage", listItemHomePage);
        model.addAttribute("numPage", 3);
        return "shop";
    }

    @GetMapping("/book")
    public String getSach(Model model, @RequestParam("id") String id) {
        Sach sach;
        List<Image> images = null;
        try {
            int ID = Integer.parseInt(id);
            sach = service.getSach(ID);
            images = servicePT.getListImage(ID);
        } catch (NumberFormatException e) {
            return "shop";
        }
        
        int numPagePhoto = images.size() % 3;
        
        List<Sach> list = service.getSach(), list2 = new ArrayList<Sach>();
        int size = list.size();
        for (int i = 0; i < 15; i++) {
            list2.add(list.get((int) (Math.random() * size)));
        }
        List<Image> listImage;
        List<ItemHomPage> listItemHomePage = new ArrayList<>();
        Image img = null;
        ItemHomPage item = null;
        for (Sach sach1 : list2) {
            try {
                listImage = servicePT.getListImage(sach1.getMaSach());
                img = listImage.get(0);
                item = new ItemHomPage(sach1, img);
            } catch (Exception e) {
            }
            listItemHomePage.add(item);
        }
        
        model.addAttribute("numPagePhoto", numPagePhoto);
        model.addAttribute("photoActive", images.get(0));
        model.addAttribute("images", images);
        model.addAttribute("sach", sach);
        model.addAttribute("listItemHomePage", listItemHomePage);
        return "book";
    }
}
