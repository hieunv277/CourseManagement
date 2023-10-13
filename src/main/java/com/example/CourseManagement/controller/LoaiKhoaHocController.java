package com.example.CourseManagement.controller;
import com.example.CourseManagement.model.BaiViet;
import com.example.CourseManagement.model.LoaiKhoaHoc;
import com.example.CourseManagement.service.BaiVietService;
import com.example.CourseManagement.service.LoaiKhoaHocService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoaiKhoaHocController {

    @Autowired
    LoaiKhoaHocService lkhSer;

    @RequestMapping(value = "/loaikhoahoc/them",method = RequestMethod.POST,produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public LoaiKhoaHoc ThemLoaiKhoaHoc(@RequestBody String loaiKH) {
        Gson gson = new Gson();
        LoaiKhoaHoc lkh = gson.fromJson(loaiKH, LoaiKhoaHoc.class);
        return lkhSer.ThemLoaiKhoaHoc(lkh);

    }

    @RequestMapping(value = "/loaikhoahoc/xoa",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
    public LoaiKhoaHoc XoaLoaiKhoaHoc(@RequestParam int id) {
        return lkhSer.XoaLoaiKhoaHoc(id);

    }

    @RequestMapping(value = "/loaikhoahoc/capnhat", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public LoaiKhoaHoc CapNhatLoaiKhoaHoc(@RequestBody String loaiKhoaHocSua) {
        Gson gson = new Gson();
        LoaiKhoaHoc lkh = gson.fromJson(loaiKhoaHocSua, LoaiKhoaHoc.class);
        return lkhSer.CapNhatLoaiKhoaHoc(lkh);
    }
}
