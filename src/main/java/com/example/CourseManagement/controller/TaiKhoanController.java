package com.example.CourseManagement.controller;
import com.example.CourseManagement.model.TaiKhoan;
import com.example.CourseManagement.service.TaiKhoanService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaiKhoanController {

    @Autowired
    TaiKhoanService tkSer;

    @RequestMapping(value = "/taikhoan/them", method = RequestMethod.POST, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public TaiKhoan ThemTaiKhoan(@RequestBody String taiKhoan) {
        Gson gson = new Gson();
        TaiKhoan tk = gson.fromJson(taiKhoan, TaiKhoan.class);
        return tkSer.ThemTaiKhoan(tk);
    }

    @RequestMapping(value = "/taikhoan/xoa", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public TaiKhoan XoaTaiKhoan(@RequestParam int id) {
        return tkSer.XoaTaiKhoan(id);

    }

    @RequestMapping(value = "/taikhoan/capnhat", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public TaiKhoan CapNhatTaiKhoan(@RequestBody String taiKhoanSua) {
        Gson gson = new Gson();
        TaiKhoan tk = gson.fromJson(taiKhoanSua, TaiKhoan.class);
        return tkSer.CapNhatTaiKhoan(tk);
    }
}
