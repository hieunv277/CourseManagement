package com.example.CourseManagement.controller;
import com.example.CourseManagement.model.TinhTrangHoc;
import com.example.CourseManagement.service.TinhTrangHocService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class TinhTrangHocController {

    @Autowired
    TinhTrangHocService tthSer;

    @RequestMapping(value = "/tinhtranghoc/them", method = RequestMethod.POST, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public TinhTrangHoc ThemTinhTrangHoc(@RequestBody String tinhTrangHoc) {
        Gson gson = new Gson();
        TinhTrangHoc tth = gson.fromJson(tinhTrangHoc, TinhTrangHoc.class);
        return tthSer.ThemTinhTrangHoc(tth);
    }

    @RequestMapping(value = "/tinhtranghoc/xoa", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public TinhTrangHoc XoaTinhTrangHoc(@RequestParam int id) {
        return tthSer.XoaTinhTrangHoc(id);

    }

    @RequestMapping(value = "/tinhtranghoc/capnhat", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public TinhTrangHoc CapNhatTinhTrangHoc(@RequestBody String tinhTrangHocSua) {
        Gson gson = new Gson();
        TinhTrangHoc tth = gson.fromJson(tinhTrangHocSua, TinhTrangHoc.class);
        return tthSer.CapNhatTinhTrangHoc(tth);
    }
}
