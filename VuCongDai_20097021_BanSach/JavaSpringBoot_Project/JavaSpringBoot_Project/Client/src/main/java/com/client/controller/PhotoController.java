/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.controller;

import com.client.entity.KhachHang;
import com.client.entity.Photo;
import com.client.service.KhachHangService;
import com.client.service.PhotoService;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author longt
 */
@Controller
@RequestMapping("/photo")
public class PhotoController {

    @Autowired
    private KhachHangService serviceKH;

    @Autowired
    private PhotoService servicePT;

    @PostMapping("/save")
    public RedirectView savePhoto(@RequestParam(value = "fileImage", required = false) MultipartFile multipartFile,
            @RequestParam(value = "idTaiKhoan", required = false) int idTaiKhoan) throws IOException {
        String s = SecurityContextHolder.getContext().getAuthentication().getName();
        KhachHang khachHang = serviceKH.getKhachHang(idTaiKhoan);
        String fileName = null;
        if (khachHang == null || multipartFile == null) {
            return new RedirectView("/ADMIN/accounts", true);
        }
        fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        if (fileName.equals("") || fileName == null) {
            return new RedirectView("/ADMIN/accounts", true);
        }
        Photo photo = new Photo(khachHang, fileName);
        photo = servicePT.savePhoto(photo);

        String uploadDir = "/Photo-BaiTapLon/" + photo.getIdPhoto();
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            System.err.println("***Khong the luu file :"+ioe);
        }

        return new RedirectView("/ADMIN/accounts", true);
    }

    @GetMapping("/delete/{id}")
    public RedirectView deletePhoto(@PathVariable(name = "id") int id) {
        servicePT.deletePhoto(id);
        System.out.println("***com.client.controller.PhotoController.deletePhoto():"+id);
        return new RedirectView("/ADMIN/accounts", true);
    }
}
