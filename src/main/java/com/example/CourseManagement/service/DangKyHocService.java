package com.example.CourseManagement.service;

import com.example.CourseManagement.model.DangKyHoc;
import com.example.CourseManagement.model.KhoaHoc;
import com.example.CourseManagement.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DangKyHocService {

    @Autowired
    DangKyHocRepo dkhRep;
    @Autowired
    HocVienRepo hocvienRep;
    @Autowired
    KhoaHocRepo khoaHocRep;
    @Autowired
    TaiKhoanRepo taiKhoanRep;
    @Autowired
    TinhTrangHocRepo tinhTrangHocRep;

    @Autowired
    private KhoaHocRepo khoaHocRepo;

//    public DangKyHoc themDangKyHoc(DangKyHoc dangKyHoc) {
//        dkhRep.save(dangKyHoc);
//        // Cập nhật số học viên của khóa học
//        capNhatSoHocVien(dangKyHoc.getKhoaHocID());
//        return dangKyHoc;
//    }
//
//    @Transactional
//    public void capNhatSoHocVien(int khoaHocID) {
//        KhoaHoc khoaHoc =khoaHocRep.findById(khoaHocID).orElse(null);
//        if (khoaHoc != null) {
//            int soHocVien = khoaHoc.getSoHocVien();
//            khoaHoc.setSoHocVien(soHocVien + 1);
//            khoaHocRep.save(khoaHoc);
//        }
//    }

    public DangKyHoc themDangKyHoc(DangKyHoc dangKyHoc) {

        KhoaHoc khoaHoc = dangKyHoc.getKhoaHoc();
        if (khoaHoc != null) {
            int soHocVienHienTai = khoaHoc.getSoHocVien();
            khoaHoc.setSoHocVien(soHocVienHienTai + 1);
            khoaHocRep.save(khoaHoc);
        }

        dkhRep.save(dangKyHoc);
        return dangKyHoc;
    }

    public DangKyHoc XoaDangKyHoc(int id) {
        Optional<DangKyHoc> dangKyHoc = dkhRep.findById(id);
        if (dangKyHoc.isEmpty())
            return null;
        dkhRep.delete(dangKyHoc.get());
        return dangKyHoc.get();

    }

    public DangKyHoc CapNhatDangKyHoc(DangKyHoc dangKyHocSua) {
        Optional<DangKyHoc> dangKyHoc = dkhRep.findById(dangKyHocSua.getDkHocID());
        if (dangKyHoc.isEmpty()) {
            return null;
        }

        DangKyHoc dkh = dangKyHoc.get();
        dkh.setNgayDangKy(dangKyHocSua.getNgayDangKy());
        dkh.setNgayBatDau(dangKyHocSua.getNgayBatDau());
        dkh.setNgayKetThuc(dangKyHocSua.getNgayKetThuc());

        dkh.setHocVien(dangKyHocSua.getHocVien());

        dkh.setKhoaHoc(dangKyHocSua.getKhoaHoc());

        dkhRep.save(dkh);
        return dkh;
    }
}
