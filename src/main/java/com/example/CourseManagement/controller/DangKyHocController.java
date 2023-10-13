package com.example.CourseManagement.controller;

import com.example.CourseManagement.model.DangKyHoc;
import com.example.CourseManagement.service.DangKyHocService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class DangKyHocController {

    @Autowired
    DangKyHocService dkhSer;

    @RequestMapping(value = "/dangkyhoc/them",method = RequestMethod.POST,produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public DangKyHoc ThemDangKyHoc(@RequestBody String dangKyHoc) {
        Gson gson = new Gson();
        DangKyHoc dkh = gson.fromJson(dangKyHoc, DangKyHoc.class);
        return dkhSer.themDangKyHoc(dkh);

    }

    @RequestMapping(value = "/dangkyhoc/xoa",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
    public DangKyHoc XoaDangKyHoc (@RequestParam int id) {
        return dkhSer.XoaDangKyHoc(id);

    }

    @RequestMapping(value = "/dangkyhoc/capnhat", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public DangKyHoc CapNhatDangKyHoc(@RequestBody String dangKyHocSua) {
        Gson gson = new Gson();
        DangKyHoc dkh = gson.fromJson(dangKyHocSua, DangKyHoc.class);
        return dkhSer.CapNhatDangKyHoc(dkh);
    }

}
