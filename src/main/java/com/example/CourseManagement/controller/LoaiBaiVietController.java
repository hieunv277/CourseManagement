package com.example.CourseManagement.controller;
import com.example.CourseManagement.model.LoaiBaiViet;
import com.example.CourseManagement.service.LoaiBaiVietService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoaiBaiVietController {

    @Autowired
    LoaiBaiVietService loaiBVSer;

    @RequestMapping(value = "/loaibaiviet/them",method = RequestMethod.POST,produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public LoaiBaiViet ThemLoaiBaiViet(@RequestBody String loaiBaiViet) {
        Gson gson = new Gson();
        LoaiBaiViet lbv = gson.fromJson(loaiBaiViet, LoaiBaiViet.class);
        return loaiBVSer.ThemLoaiBaiviet(lbv);

    }
    @RequestMapping(value = "/loaibaiviet/capnhat",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    public LoaiBaiViet CapNhatLoaiBaiViet (@RequestBody String loaiBaiVietSua) {
        Gson gson = new Gson();
        LoaiBaiViet lbv= gson.fromJson(loaiBaiVietSua, LoaiBaiViet.class);
        return loaiBVSer.CapNhatLoaiBaiViet(lbv);

    }
    @RequestMapping(value = "/loaibaiviet/xoa",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
    public LoaiBaiViet XoaLoaiBaiViet(@RequestParam int id) {
        return loaiBVSer.XoaLoaiBaiViet(id);

    }

}
