package com.example.CourseManagement.controller;

import com.example.CourseManagement.model.KhoaHoc;
import com.example.CourseManagement.model.KhoaHocDTO;
import com.example.CourseManagement.service.KhoaHocService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KhoaHocController {

    @Autowired
    KhoaHocService khSer;

    @RequestMapping(value = "/khoahoc/them", method = RequestMethod.POST, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public KhoaHoc ThemKhoaHoc(@RequestBody String khoaHoc) {
        Gson gson = new Gson();
        KhoaHoc kh = gson.fromJson(khoaHoc, KhoaHoc.class);
        return khSer.ThemKhoaHoc(kh);
    }

    @RequestMapping(value = "/khoahoc/xoa", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public KhoaHoc XoaKhoaHoc(@RequestParam int id) {
        return khSer.XoaKhoaHoc(id);

    }

    @RequestMapping(value = "/khoahoc/capnhat", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public KhoaHoc CapNhatKhoaHoc(@RequestBody String khoaHocSua) {
        Gson gson = new Gson();
        KhoaHoc kh = gson.fromJson(khoaHocSua, KhoaHoc.class);
        return khSer.CapNhatKhoaHoc(kh);
    }

    @RequestMapping(value = "/khoahoc/timkiem", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<KhoaHocDTO> timKiemKhoaHoc(@RequestParam("tenKhoaHoc") String tenKhoaHoc) {
        return khSer.TimKiem(tenKhoaHoc);
    }
}
