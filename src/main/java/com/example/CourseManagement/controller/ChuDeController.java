package com.example.CourseManagement.controller;

import com.example.CourseManagement.model.ChuDe;
import com.example.CourseManagement.service.ChuDeService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChuDeController {

    @Autowired
    ChuDeService chuDeSer;

    @RequestMapping(value = "/chude/them", method = RequestMethod.POST, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ChuDe ThemChuDe(@RequestBody String chuDe) {
        Gson gson = new Gson();
        ChuDe cd = gson.fromJson(chuDe, ChuDe.class);
        return chuDeSer.ThemChuDe(cd);
    }

    @RequestMapping(value = "/chude/xoa",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ChuDe XoạChuDe(@RequestParam int id) {
        return chuDeSer.XoaChuDe(id);

    }

    @RequestMapping(value = "/chude/capnhat",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    public ChuDe CapNhatChuDe(@RequestBody String chuDeSua) {
        Gson gson = new Gson();
        ChuDe cd= gson.fromJson(chuDeSua, ChuDe.class);
        return chuDeSer.CapNhatChuDe(cd);

    }

}
