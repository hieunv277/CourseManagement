package com.example.CourseManagement.controller;

import com.example.CourseManagement.model.HocVien;
import com.example.CourseManagement.service.HocVienService;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class HocVienController {

    @Autowired
    HocVienService hvSer;

    @RequestMapping(value = "/hocvien/them",method = RequestMethod.POST,produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public HocVien ThemHocVien(@RequestBody String hocVien) {
        Gson gson = new Gson();
        HocVien hv = gson.fromJson(hocVien, HocVien.class);
        return hvSer.ThemHocVien(hv);
    }

    @RequestMapping(value = "/hocvien/capnhat",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    public HocVien CapNhatHocVien(@RequestBody String hocVienSua) {
        Gson gson = new Gson();
        HocVien hv= gson.fromJson(hocVienSua, HocVien.class);
        return hvSer.CapNhatHocVien(hv);

    }

    @RequestMapping(value = "/hocvien/xoa",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
    public HocVien XoaHocVien(@RequestParam int id) {
        return hvSer.XoaHocVien(id);

    }

//	@RequestMapping(value = "/hocvien/timkiemhocvien",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
//	public List<HocVien> TimKiem(@RequestParam("hoTen") String hoTen) {
//		return hvSer.TimKiemHocVien(hoTen);
//	}

//	@RequestMapping(value = "/hocvien/timkiem/hotenvamail", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
//	public List<HocVien> timHocVienTheoHoTenVaKhoaHoc(String hoTen, String email) {
//		return hvSer.timHocVienTheoHoTenVaMail(hoTen, email);
//	}
}
