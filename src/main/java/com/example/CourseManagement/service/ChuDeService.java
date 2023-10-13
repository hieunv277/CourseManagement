package com.example.CourseManagement.service;

import com.example.CourseManagement.model.BaiViet;
import com.example.CourseManagement.model.ChuDe;
import com.example.CourseManagement.repository.BaiVietRepo;
import com.example.CourseManagement.repository.ChuDeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChuDeService {

    @Autowired
    ChuDeRepo chuDeRep;

    @Autowired
    BaiVietRepo bvRep;

    public ChuDe ThemChuDe(ChuDe chuDe) {
        chuDeRep.save(chuDe);
        return chuDe;
    }

    public ChuDe XoaChuDe(int id ) {
        Optional<ChuDe> chuDeOptional = chuDeRep.findById(id);
        if (chuDeOptional.isEmpty())
            return null;
        ChuDe chuDe = chuDeOptional.get();
        for (BaiViet baiViet : chuDe.getBaiVietList()) {
            bvRep.delete(baiViet);
        }
        chuDeRep.delete(chuDe);
        return chuDe;

    }

    public ChuDe CapNhatChuDe (ChuDe chuDeSua) {
        Optional<ChuDe> chuDe = chuDeRep.findById(chuDeSua.getChuDeID());
        if(chuDe.isEmpty())
            return null;

        ChuDe cd = chuDe.get();
        cd.setTenChuDe(chuDeSua.getTenChuDe());
        cd.setNoiDung(chuDeSua.getNoiDung());
        cd.setLoaiBaiViet(chuDeSua.getLoaiBaiViet());
        chuDeRep.save(cd);
        return cd;

    }
}
