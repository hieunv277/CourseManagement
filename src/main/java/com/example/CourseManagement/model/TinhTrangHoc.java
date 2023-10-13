package com.example.CourseManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class TinhTrangHoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tinhTrangHocID;

    @Column(name = "ten_tinh_trang")
    private String tenTinhTrang;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tinhTrangHoc")
    @JsonIgnoreProperties(value = "tinhTrangHoc")
    List<DangKyHoc> dangKyHocList;

    public int getTinhTrangHocID() {
        return tinhTrangHocID;
    }

    public void setTinhTrangHocID(int tinhTrangHocID) {
        this.tinhTrangHocID = tinhTrangHocID;
    }

    public String getTenTinhTrang() {
        return tenTinhTrang;
    }

    public void setTenTinhTrang(String tenTinhTrang) {
        this.tenTinhTrang = tenTinhTrang;
    }

    public List<DangKyHoc> getDangKyHocList() {
        return dangKyHocList;
    }

    public void setDangKyHocList(List<DangKyHoc> dangKyHocList) {
        this.dangKyHocList = dangKyHocList;
    }
}
