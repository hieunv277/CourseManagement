package com.example.CourseManagement.service;

import com.example.CourseManagement.model.BaiViet;
import com.example.CourseManagement.model.DangKyHoc;
import com.example.CourseManagement.model.TaiKhoan;
import com.example.CourseManagement.repository.BaiVietRepo;
import com.example.CourseManagement.repository.DangKyHocRepo;
import com.example.CourseManagement.repository.TaiKhoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaiKhoanService {

    @Autowired
    TaiKhoanRepo tkRep;

    @Autowired
    DangKyHocRepo dkhRep;

    @Autowired
    BaiVietRepo bvRep;

    public TaiKhoan ThemTaiKhoan(TaiKhoan taiKhoan) {
        tkRep.save(taiKhoan);
        return taiKhoan;
    }

    public TaiKhoan XoaTaiKhoan(int id) {
        Optional<TaiKhoan> taikhoanOptional = tkRep.findById(id);
        if (taikhoanOptional.isEmpty())
            return null;
        TaiKhoan taiKhoan = taikhoanOptional.get();
        for (DangKyHoc dangKyHoc : taiKhoan.getDangKyHocList()) {
            dkhRep.delete(dangKyHoc);
        }
        for (BaiViet baiViet : taiKhoan.getBaiVietList()) {
            bvRep.delete(baiViet);
        }
        tkRep.delete(taiKhoan);
        return taiKhoan;

    }

    public TaiKhoan CapNhatTaiKhoan(TaiKhoan taiKhoanSua) {
        Optional<TaiKhoan> taiKhoan = tkRep.findById(taiKhoanSua.getTaiKhoanID());
        if (taiKhoan.isEmpty()) {
            return null;
        }

        TaiKhoan tk = taiKhoan.get();
        tk.setTenNguoiDung(taiKhoanSua.getTenNguoiDung());
        tk.setTaiKhoan(taiKhoanSua.getTaiKhoan());
        tk.setMatKhau(taiKhoanSua.getMatKhau());

        tkRep.save(tk);
        return tk;
    }
}
