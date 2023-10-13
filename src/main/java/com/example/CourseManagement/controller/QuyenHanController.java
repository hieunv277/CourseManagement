package com.example.CourseManagement.controller;
import com.example.CourseManagement.model.QuyenHan;
import com.example.CourseManagement.service.QuyenHanService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuyenHanController {

    @Autowired
    QuyenHanService qhSer;

    @RequestMapping(value = "/quyenhan/them", method = RequestMethod.POST, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public QuyenHan ThemQuyenHan(@RequestBody String quyenHan) {
        Gson gson = new Gson();
        QuyenHan qh = gson.fromJson(quyenHan, QuyenHan.class);
        return qhSer.ThemQuyenHan(qh);
    }

    @RequestMapping(value = "/quyenhan/xoa", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public QuyenHan XoaQuyenHan(@RequestParam int id) {
        return qhSer.XoaQuyenHan(id);

    }

    @RequestMapping(value = "/quyenhan/capnhat", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public QuyenHan CapNhatQuyenHan(@RequestBody String quyenHanSua) {
        Gson gson = new Gson();
        QuyenHan qh = gson.fromJson(quyenHanSua, QuyenHan.class);
        return qhSer.CapNhatQuyenHan(qh);
    }
}
