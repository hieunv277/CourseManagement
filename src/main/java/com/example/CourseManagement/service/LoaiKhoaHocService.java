package com.example.CourseManagement.service;

import com.example.CourseManagement.model.DangKyHoc;
import com.example.CourseManagement.model.KhoaHoc;
import com.example.CourseManagement.model.LoaiKhoaHoc;
import com.example.CourseManagement.repository.DangKyHocRepo;
import com.example.CourseManagement.repository.KhoaHocRepo;
import com.example.CourseManagement.repository.LoaiKhoaHocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoaiKhoaHocService {

    @Autowired
    LoaiKhoaHocRepo lkhRep;

    @Autowired
    KhoaHocRepo khRep;

    @Autowired
    DangKyHocRepo dkhRep;

    public LoaiKhoaHoc ThemLoaiKhoaHoc(LoaiKhoaHoc loaiKH) {
        lkhRep.save(loaiKH);
        return loaiKH;
    }

    public LoaiKhoaHoc XoaLoaiKhoaHoc(int id ) {
        Optional<LoaiKhoaHoc> loaiKhoaHocOptional = lkhRep.findById(id);
        if (loaiKhoaHocOptional.isEmpty())
            return null;
        LoaiKhoaHoc loaiKhoaHoc = loaiKhoaHocOptional.get();
        for (KhoaHoc khoaHoc: loaiKhoaHoc.getKhoaHocList()) {
            for(DangKyHoc dangKyHoc: khoaHoc.getDangKyHocList()) {
                dkhRep.delete(dangKyHoc);
            }
            khRep.delete(khoaHoc);
        }
        lkhRep.delete(loaiKhoaHoc);
        return loaiKhoaHoc;

    }

    public LoaiKhoaHoc CapNhatLoaiKhoaHoc(LoaiKhoaHoc loaiKhoaHocSua) {
        Optional<LoaiKhoaHoc> loaiKhoaHoc = lkhRep.findById(loaiKhoaHocSua.getLoaiKhoaHocID());
        if (loaiKhoaHoc.isEmpty()) {
            return null;
        }

        LoaiKhoaHoc lkh = loaiKhoaHoc.get();
        lkh.setTenLoai(loaiKhoaHocSua.getTenLoai());

        lkhRep.save(lkh);
        return lkh;
    }
}
