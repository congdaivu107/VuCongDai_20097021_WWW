/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.controller;

import com.client.entity.BinhLuan;
import com.client.entity.GioHang;
import com.client.entity.Image;
import com.client.entity.KhachHang;
import com.client.entity.Photo;
import com.client.entity.Sach;
import com.client.entity.TaiKhoan;
import com.client.model.ItemBook;
import com.client.service.BinhLuanService;
import com.client.service.GioHangService;
import com.client.service.KhachHangService;
import com.client.service.PhotoService;
import com.client.service.SachService;
import com.client.service.TaiKhoanService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author longt
 */
@Controller
@RequestMapping("/ADMIN/**")
public class QuanTriVienController {

    @Autowired
    private TaiKhoanService serviceTK;

    @Autowired
    private KhachHangService serviceKH;

    @Autowired
    private SachService serviceS;

    @Autowired
    private GioHangService serviceGH;

    @Autowired
    private PhotoService servicePT;

    @Autowired
    private BinhLuanService serviceBL;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping("/home")
    private String startHome(Model model) {
        String s = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("userLogin", s);
        List<GioHang> list = null;
        List<BinhLuan> list2 = null;
        try {
            list = serviceGH.getAllGioHang();
            list2 = serviceBL.ListBinhLuan();
        } catch (Exception e) {
        }
        model.addAttribute("ListOrder", list);
        model.addAttribute("listBinhLuan", list2);
        return "index2";
    }

    @GetMapping("/accounts")
    private String startAccount(Model model) {
        List<TaiKhoan> list = serviceTK.listTaiKhoan();
        model.addAttribute("listTaiKhoan", list);
        String s = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("userLogin", s);
        return "accounts";
    }

    @GetMapping("/accounts/taikhoan")
    private String getAccount(Model model, @RequestParam(name = "maTaiKhoan", required = false) String maTaiKhoan) {
        List<TaiKhoan> list = serviceTK.listTaiKhoan();
        model.addAttribute("listTaiKhoan", list);
        try {
            int id = Integer.parseInt(maTaiKhoan);
            TaiKhoan taiKhoan = serviceTK.getTaiKhoan(id);
            model.addAttribute("taiKhoaned", taiKhoan);
            List<Photo> listPT = servicePT.getListPhoto(taiKhoan.getKhachHang().getMaKhacHang());
            model.addAttribute("listPhoto", listPT);
        } catch (Exception e) {
        }
        String s = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("userLogin", s);
        return "accounts";
    }

    @PostMapping("/accounts/update")
    @RequestMapping(params = "update", method = RequestMethod.POST)
    private String updateAccount(Model model, @RequestParam(name = "name") String username,
            @RequestParam(name = "role") String role, @RequestParam(name = "password") String password,
            @RequestParam(name = "password2") String password2, @RequestParam(name = "status") String status,
            @RequestParam(name = "idTaiKhoan") String idTaiKhoan, @RequestParam(name = "idKhachHang") String idKhachHang) {
        List<TaiKhoan> list = serviceTK.listTaiKhoan();
        model.addAttribute("listTaiKhoan", list);
        String s = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("userLogin", s);
        try {
            int idTK = Integer.parseInt(idTaiKhoan);
            int idKH = Integer.parseInt(idKhachHang);
            KhachHang khachHang = serviceKH.getKhachHang(idKH);
            boolean sts;
            if (status.equals("true")) {
                sts = true;
            } else {
                sts = false;
            }
            if (password.contains(password2) == false & password.equals("")) {
                return "accounts";
            }
            password = "{bcrypt}" + passwordEncoder.encode(password2);
            if (!role.matches("^ROLE_[A-Z]+")) {
                return "accounts";
            }
            TaiKhoan taiKhoan = new TaiKhoan(username, password, sts, role, khachHang);
            taiKhoan.setIdTaiKhoan(idTK);
            serviceTK.saveTaiKhoan(taiKhoan);
            model.addAttribute("taiKhoaned", taiKhoan);
            BinhLuan binhLuan = new BinhLuan(s, "Cap nhat thanh cong tai khoan " + taiKhoan.getTaiKhoan(), null);
            serviceBL.saveBinhLuan(binhLuan);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return "accounts";
    }

    @PostMapping("/accounts/update")
    @RequestMapping(params = "delete", method = RequestMethod.POST)
    private String deleteAccount(Model model, @RequestParam(name = "idTaiKhoan") String idTaiKhoan) {
        try {
            int idTK = Integer.parseInt(idTaiKhoan);
            serviceTK.deleteTaiKhoan(idTK);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        List<TaiKhoan> list = serviceTK.listTaiKhoan();
        model.addAttribute("listTaiKhoan", list);
        String s = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("userLogin", s);
        BinhLuan binhLuan = new BinhLuan(s, "Xoa thanh cong tai khoan (ID" + idTaiKhoan + ")", null);
        serviceBL.saveBinhLuan(binhLuan);
        return "accounts";
    }

    @GetMapping("/reports")
    private String startReport() {
        return "reports";
    }

    @GetMapping("/books")
    private String startBook(Model model) {
        List<Sach> list = serviceS.getSach();
        Set<String> list2 = new HashSet<>();
        for (Sach sach : list) {
            list2.add(sach.getTacGia());
        }
        model.addAttribute("listTacGia", list2);
        model.addAttribute("listSach", list);
        String s = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("userLogin", s);
        return "products";
    }

    @GetMapping("/books/add")
    private String showAddBook(Model model) {
        ItemBook itemBook = new ItemBook();
        itemBook.setMaSach(0);
        model.addAttribute("itemBooks", itemBook);
        String s = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("userLogin", s);
        model.addAttribute("chucNang", "THEM SACH MOI");
        return "addBook";
    }

    @GetMapping("/books/view/{maSach}")
    private String viewBook(Model model, @PathVariable(name = "maSach") String maSach) {
        Sach sach;
        int id = 0;
        try {
            id = Integer.parseInt(maSach);
            sach = serviceS.getSach(id);
        } catch (Exception e) {
            return "redirect:/ADMIN/books";
        }
        StringBuilder info = new StringBuilder();
        Set<String> listInf = sach.getThongTinThem();
        for (String string : listInf) {
            info.append(string).append(";");
        }
        ItemBook itemBook = new ItemBook(sach.getMaSach(), sach.getTenSach(), sach.getTacGia(), sach.getMieuTa(), info.toString(), sach.getGiaSach(), sach.getDanhGia(), sach.getNgayXuatBang());
        model.addAttribute("itemBooks", itemBook);
        String s = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("userLogin", s);
        model.addAttribute("chucNang", "CAP NHAT SACH " + sach.getMaSach());
        Image image = null;
        List<Image> list = servicePT.getListImage(sach.getMaSach());
        model.addAttribute("listImage", list);
        return "addBook";
    }

    @RequestMapping(value = "/books/update", method = RequestMethod.POST)
    private String updateBook(@Valid @ModelAttribute ItemBook itemBook) {
        Sach sach = new Sach(itemBook.getName(), itemBook.getMoney(), itemBook.getRate(), itemBook.getAuth(), itemBook.getDecriber(), itemBook.getDatePub());
        sach.setMaSach(itemBook.getMaSach());
        String[] s = itemBook.getInfor().split(";");
        Set<String> infSet = new HashSet<>();
        for (String string : s) {
            infSet.add(string);
        }
        sach.setThongTinThem(infSet);
        sach = serviceS.saveSach(sach);
        String s1 = SecurityContextHolder.getContext().getAuthentication().getName();
        BinhLuan binhLuan;
        if (sach.getMaSach() == 0) {
            binhLuan = new BinhLuan(s1, "Them thanh cong sach: " + sach.getTenSach(), null);
        } else {
            binhLuan = new BinhLuan(s1, "Cap nhat thanh cong sach: " + sach.getTenSach(), null);
        }
        serviceBL.saveBinhLuan(binhLuan);
        return "redirect:/ADMIN/books";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/books/deletelist")
    private String deleteList(@RequestParam(name = "listCheck", required = false) String list) {
        String[] list2 = list.split(",");
        int num;
        String s1 = SecurityContextHolder.getContext().getAuthentication().getName();
        for (String string : list2) {
            try {
                num = Integer.parseInt(string);
                serviceS.deleteSach(num);
                BinhLuan binhLuan = new BinhLuan(s1, "Xoa thanh cong sach (ID:" + string + ")", null);
                serviceBL.saveBinhLuan(binhLuan);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "redirect:/ADMIN/books";
    }

    @GetMapping("/books/{tacGia}")
    private String searchtBook(Model model, @PathVariable(name = "tacGia", required = false) String tacGia) {
        if (tacGia == null) {
            startBook(model);
        }
        List<Sach> list = serviceS.getSach(), list3 = new ArrayList<>();
        Set<String> list2 = new HashSet<>();
        for (Sach sach : list) {
            list2.add(sach.getTacGia());
        }
        for (Sach sach : list) {
            if (sach.getTacGia().toLowerCase().contains(tacGia.toLowerCase())) {
                list3.add(sach);
            }
        }
        model.addAttribute("listTacGia", list2);
        model.addAttribute("listSach", list3);
        String s = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("userLogin", s);
        return "products";
    }

    @GetMapping("/login")
    private String startLogin() {
        return "loginAdmin";
    }
}
