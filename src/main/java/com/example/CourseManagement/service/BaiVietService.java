package com.example.CourseManagement.service;

import com.example.CourseManagement.model.BaiViet;
import com.example.CourseManagement.repository.BaiVietRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BaiVietService {

    @Autowired
    BaiVietRepo baiVietRep;

    public BaiViet ThemBaiViet(BaiViet baiViet) {
        baiVietRep.save(baiViet);
        return baiViet;

    }

    public BaiViet XoaBaiViet(int id) {
        Optional<BaiViet> baiViet = baiVietRep.findById(id);
        if (baiViet.isEmpty())
            return null;
        baiVietRep.delete(baiViet.get());
        return baiViet.get();

    }

    public BaiViet CapNhatBaiViet(BaiViet baiVietSua) {
        Optional<BaiViet> baiViet = baiVietRep.findById(baiVietSua.getBaiVietID());
        if (baiViet.isEmpty()) {
            return null;
        }

        BaiViet bv = baiViet.get();
        bv.setTenBaiViet(baiVietSua.getTenBaiViet());
        bv.setTenTacGia(baiVietSua.getTenTacGia());
        bv.setNoiDung(baiVietSua.getNoiDung());
        bv.setNoiDungNgan(baiVietSua.getNoiDungNgan());
        bv.setHinhAnh(baiVietSua.getHinhAnh());
        bv.setChuDe(baiVietSua.getChuDe());
        bv.setTaiKhoan(baiVietSua.getTaiKhoan());
        baiVietRep.save(bv);
        return bv;
    }

}
