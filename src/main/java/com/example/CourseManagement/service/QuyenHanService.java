package com.example.CourseManagement.service;

import com.example.CourseManagement.model.DangKyHoc;
import com.example.CourseManagement.model.QuyenHan;
import com.example.CourseManagement.model.TaiKhoan;
import com.example.CourseManagement.repository.DangKyHocRepo;
import com.example.CourseManagement.repository.QuyenHanRepo;
import com.example.CourseManagement.repository.TaiKhoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuyenHanService {

    @Autowired
    QuyenHanRepo qhRep;

    @Autowired
    TaiKhoanRepo tkRep;

    @Autowired
    DangKyHocRepo dkhRep;

    public QuyenHan ThemQuyenHan(QuyenHan quyenHan) {
        qhRep.save(quyenHan);
        return quyenHan;
    }

    public QuyenHan XoaQuyenHan(int id ) {
        Optional<QuyenHan> quyenHanOptional = qhRep.findById(id);
        if (quyenHanOptional.isEmpty())
            return null;
        QuyenHan quyenHan = quyenHanOptional.get();
        for (TaiKhoan taiKhoan : quyenHan.getTaiKhoanList()) {
            for(DangKyHoc dangKyHoc : taiKhoan.getDangKyHocList()) {
                dkhRep.delete(dangKyHoc);
            }
            tkRep.delete(taiKhoan);
        }
        qhRep.delete(quyenHan);
        return quyenHan;

    }
    public QuyenHan CapNhatQuyenHan(QuyenHan quyenHanSua) {
        Optional<QuyenHan> quyenHan = qhRep.findById(quyenHanSua.getQuyenHantID());
        if (quyenHan.isEmpty()) {
            return null;
        }

        QuyenHan qh = quyenHan.get();
        qh.setTenQuyenHan(quyenHanSua.getTenQuyenHan());

        qhRep.save(qh);
        return qh;
    }
}
