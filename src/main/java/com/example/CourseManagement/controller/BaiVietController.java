package com.example.CourseManagement.controller;

import com.example.CourseManagement.model.BaiViet;
import com.example.CourseManagement.service.BaiVietService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class BaiVietController {
    @Autowired
    BaiVietService baiVietSer;

    @RequestMapping(value = "/baiviet/them",method = RequestMethod.POST,produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public BaiViet ThemBaiViet(@RequestBody String baiViet) {
        Gson gson = new Gson();
        BaiViet bv = gson.fromJson(baiViet, BaiViet.class);
        return baiVietSer.ThemBaiViet(bv);

    }

    @RequestMapping(value = "/baiviet/xoa",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
    public BaiViet XoaBaiViet(@RequestParam int id) {
        return baiVietSer.XoaBaiViet(id);

    }

    @RequestMapping(value = "/baiviet/capnhat", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaiViet CapNhatBaiViet(@RequestBody String baiVietSua) {
        Gson gson = new Gson();
        BaiViet baiViet = gson.fromJson(baiVietSua, BaiViet.class);
        return baiVietSer.CapNhatBaiViet(baiViet);
    }
}
