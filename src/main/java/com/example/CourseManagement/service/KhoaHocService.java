package com.example.CourseManagement.service;

import com.example.CourseManagement.model.DangKyHoc;
import com.example.CourseManagement.model.KhoaHoc;
import com.example.CourseManagement.model.KhoaHocDTO;
import com.example.CourseManagement.repository.DangKyHocRepo;
import com.example.CourseManagement.repository.KhoaHocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class KhoaHocService {

    @Autowired
    KhoaHocRepo khRep;

    @Autowired
    DangKyHocRepo dkhRep;

    public KhoaHoc ThemKhoaHoc(KhoaHoc khoaHoc) {
        khRep.save(khoaHoc);
        return khoaHoc;

    }

    public KhoaHoc XoaKhoaHoc(int id ) {
        Optional<KhoaHoc> khoahocOptional = khRep.findById(id);
        if (khoahocOptional.isEmpty())
            return null;
        KhoaHoc khoaHoc =  khoahocOptional.get();
        List<DangKyHoc> dangKyHocList = khoaHoc.getDangKyHocList();

        if (dangKyHocList != null && !dangKyHocList.isEmpty()) {
            for (DangKyHoc dangKyHoc : dangKyHocList) {
                dkhRep.delete(dangKyHoc);
            }
        }
        khRep.delete(khoaHoc);
        return khoaHoc;

    }

    public KhoaHoc CapNhatKhoaHoc(KhoaHoc khoaHocSua) {
        Optional<KhoaHoc> khoaHoc = khRep.findById(khoaHocSua.getKhoaHocID());
        if (khoaHoc.isEmpty()) {
            return null;
        }

        KhoaHoc kh = khoaHoc.get();
        kh.setTenKhoaHoc(khoaHocSua.getTenKhoaHoc());
        kh.setThoiGianHoc(khoaHocSua.getThoiGianHoc());
        kh.setGioiThieu(khoaHocSua.getGioiThieu());
        kh.setNoiDung(khoaHocSua.getNoiDung());
        kh.setHocPhi(khoaHocSua.getHocPhi());
        kh.setSoHocVien(khoaHocSua.getSoHocVien());
        kh.setSoLuongMon(khoaHocSua.getSoLuongMon());
        kh.setHinhAnh(khoaHocSua.getHinhAnh());

        kh.setLoaiKhoaHoc(khoaHocSua.getLoaiKhoaHoc());

        khRep.save(kh);
        return kh;
    }

    public List<KhoaHocDTO> TimKiem(String tenKhoaHoc) {
        List<KhoaHocDTO> khoaHocDTOList = new ArrayList<>();

        for (KhoaHoc khoaHoc : khRep.findAll()) {
            if (khoaHoc.getTenKhoaHoc().toLowerCase().contains(tenKhoaHoc.toLowerCase())) {
                KhoaHocDTO khoaHocDTO = new KhoaHocDTO();
                khoaHocDTO.setKhoaHocID(khoaHoc.getKhoaHocID());
                khoaHocDTO.setTenKhoaHoc(khoaHoc.getTenKhoaHoc());
                khoaHocDTO.setThoiGianHoc(khoaHoc.getThoiGianHoc());
                khoaHocDTO.setGioiThieu(khoaHoc.getGioiThieu());
                khoaHocDTO.setNoiDung(khoaHoc.getNoiDung());
                khoaHocDTO.setHocPhi(khoaHoc.getHocPhi());
                khoaHocDTO.setSoHocVien(khoaHoc.getSoHocVien());
                khoaHocDTO.setSoLuongMon(khoaHoc.getSoLuongMon());
                khoaHocDTO.setHinhAnh(khoaHoc.getHinhAnh());
                khoaHocDTO.setLoaiKhoaHocID(khoaHoc.getLoaiKhoaHocID());

                khoaHocDTOList.add(khoaHocDTO);
            }
        }

        return khoaHocDTOList;
    }
}
