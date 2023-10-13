package com.example.CourseManagement.service;

import com.example.CourseManagement.model.DangKyHoc;
import com.example.CourseManagement.model.TinhTrangHoc;
import com.example.CourseManagement.repository.DangKyHocRepo;
import com.example.CourseManagement.repository.TinhTrangHocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TinhTrangHocService {

    @Autowired
    TinhTrangHocRepo tthRep;

    @Autowired
    DangKyHocRepo dkhRep;

    public TinhTrangHoc ThemTinhTrangHoc(TinhTrangHoc tinhTrangHoc) {
        tthRep.save(tinhTrangHoc);
        return tinhTrangHoc;

    }

    public TinhTrangHoc XoaTinhTrangHoc(int id ) {
        Optional<TinhTrangHoc> tinhTrangHocOptional = tthRep.findById(id);
        if (tinhTrangHocOptional.isEmpty())
            return null;
        TinhTrangHoc tinhTrangHoc= tinhTrangHocOptional.get();
        for (DangKyHoc dangKyHoc : tinhTrangHoc.getDangKyHocList()) {
            dkhRep.delete(dangKyHoc);
        }
        tthRep.delete(tinhTrangHoc);
        return tinhTrangHoc;

    }

    public TinhTrangHoc CapNhatTinhTrangHoc(TinhTrangHoc tinhTrangHocSua) {
        Optional<TinhTrangHoc> tinhTrangHoc = tthRep.findById(tinhTrangHocSua.getTinhTrangHocID());
        if (tinhTrangHoc.isEmpty()) {
            return null;
        }

        TinhTrangHoc tth = tinhTrangHoc.get();
        tth.setTenTinhTrang(tinhTrangHocSua.getTenTinhTrang());

        tthRep.save(tth);
        return tth;
    }
}
