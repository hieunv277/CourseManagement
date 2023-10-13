package com.example.CourseManagement.service;

import com.example.CourseManagement.model.DangKyHoc;
import com.example.CourseManagement.model.HocVien;
import com.example.CourseManagement.repository.DangKyHocRepo;
import com.example.CourseManagement.repository.HocVienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HocVienService {

    @Autowired
    HocVienRepo hvRep;

    @Autowired
    DangKyHocRepo dkhRep;
    public HocVien ThemHocVien(HocVien hocVien) {
        hvRep.save(hocVien);
        return hocVien;
    }

    public HocVien CapNhatHocVien (HocVien hocVienSua) {
        Optional<HocVien> hocVien = hvRep.findById(hocVienSua.getHocVienID());
        if(hocVien.isEmpty())
            return null;

        HocVien hv = hocVien.get();
        hv.setEmail(hocVienSua.getEmail());
        hv.setHinhAnh(hocVienSua.getHinhAnh());
        hv.setHoTen(hocVienSua.getHoTen());
        hv.setNgaySinh(hocVienSua.getNgaySinh());
        hv.setPhuongXa(hocVienSua.getPhuongXa());
        hv.setQuanHuyen(hocVienSua.getQuanHuyen());
        hv.setTinhThanh(hocVienSua.getTinhThanh());
        hv.setSoNha(hocVienSua.getSoNha());
        hv.setSdt(hocVienSua.getSdt());
        hvRep.save(hv);
        return hv;

    }

    public HocVien XoaHocVien(int hocVienID ) {
        Optional<HocVien> hocVienOptional = hvRep.findById(hocVienID);
        if (hocVienOptional.isEmpty())
            return null;
        HocVien hocVien = hocVienOptional.get();
        for (DangKyHoc dangKyHoc : hocVien.getDangKyHocList()) {
            dkhRep.delete(dangKyHoc);
        }
        hvRep.delete(hocVien);
        return hocVien;

    }

//	 public List<HocVien> TimKiemHocVien(String hoTen) {
//	        List<HocVien> lst = new ArrayList<>();
//
//	        for (HocVien x : hvRep.findAll()) {
//	            if (x.getHoTen().toLowerCase().contains(hoTen.toLowerCase())) {
//	                lst.add(x);
//	            }
//	        }
//	        return lst;
//	    }
//
//	public List<HocVien> timHocVienTheoHoTenVaMail(String hoTen, String email) {
//		return hvRep.timKiemTheoTenVaMail(hoTen, email);
//	}
}
