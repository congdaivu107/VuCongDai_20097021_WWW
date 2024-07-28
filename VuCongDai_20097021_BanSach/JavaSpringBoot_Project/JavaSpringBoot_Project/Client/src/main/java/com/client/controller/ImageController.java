/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.controller;

import com.client.entity.Image;
import com.client.entity.Sach;
import com.client.service.PhotoService;
import com.client.service.SachService;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author longt
 */
@Controller
@RequestMapping("/image")
public class ImageController {
    
    @Autowired
    private SachService serviceS;
    
    @Autowired
    private PhotoService serviceIM;
    
    @PostMapping("/save")
    public String saveImage(@RequestParam(value = "fileImage", required = false) MultipartFile multipartFile,
            @RequestParam(value = "idSach", required = false) int idSach) throws IOException {
        Sach sach = null;
        String fileName = null;
        if (multipartFile == null) {
            return "redirect:/ADMIN/books/view/" + idSach;
        }
        try {
            sach = serviceS.getSach(idSach);
        } catch (Exception e) {
            return "redirect:/ADMIN/books/view/" + idSach;
        }
        fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        if (fileName == null || fileName.equals("")) {
            return "redirect:/ADMIN/books/view/" + idSach;
        }
        
        Image image = new Image(sach, fileName);
        image = serviceIM.saveImage(image);
        
        String uploadDir = "/Image-BaiTapLon/" + image.getIdPhoto();
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
        return "redirect:/ADMIN/books/view/" + idSach;
    }
    
    @GetMapping("/delete/{id}/{maS}")
    public String deleteImage(@PathVariable(name = "id") int id, @PathVariable(name = "maS") int maS){
        serviceIM.deleteImage(id);
        return "redirect:/ADMIN/books/view/"+maS;
    }
}
