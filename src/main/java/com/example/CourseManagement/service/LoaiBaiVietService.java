package com.example.CourseManagement.service;

import com.example.CourseManagement.model.BaiViet;
import com.example.CourseManagement.model.ChuDe;
import com.example.CourseManagement.model.LoaiBaiViet;
import com.example.CourseManagement.repository.BaiVietRepo;
import com.example.CourseManagement.repository.ChuDeRepo;
import com.example.CourseManagement.repository.LoaiBaiVietRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoaiBaiVietService {

    @Autowired
    LoaiBaiVietRepo loaiBVRep;

    @Autowired
    ChuDeRepo cdRep;

    @Autowired
    BaiVietRepo bvRep;

    public LoaiBaiViet ThemLoaiBaiviet(LoaiBaiViet loaiBV) {
        loaiBVRep.save(loaiBV);
        return loaiBV;
    }

    public LoaiBaiViet CapNhatLoaiBaiViet(LoaiBaiViet  loaiBaiVietSua) {
        Optional<LoaiBaiViet> loaiBaiViet = loaiBVRep.findById(loaiBaiVietSua.getLoaiBaiVietID());
        if (loaiBaiViet.isEmpty())
            return null;

        LoaiBaiViet lbv = loaiBaiViet.get();
        lbv.setTenLoai(loaiBaiVietSua.getTenLoai());
        loaiBVRep.save(lbv);
        return lbv;
    }

    public LoaiBaiViet XoaLoaiBaiViet(int id ) {
        Optional<LoaiBaiViet> loaiBaiVietOptional =loaiBVRep.findById(id);
        if (loaiBaiVietOptional.isEmpty())
            return null;
        LoaiBaiViet loaiBaiViet = loaiBaiVietOptional.get();
        for (ChuDe chuDe : loaiBaiViet.getChuDeList()) {
            for(BaiViet baiViet : chuDe.getBaiVietList()) {
                bvRep.delete(baiViet);
            }
            cdRep.delete(chuDe);
        }
        loaiBVRep.delete(loaiBaiViet);
        return loaiBaiViet;

    }

}
