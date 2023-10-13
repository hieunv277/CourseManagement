package com.example.CourseManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class LoaiKhoaHoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loaiKhoaHocID;

    @Column(name = "ten_loai")
    private String tenLoai;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "loaiKhoaHoc")
    @JsonIgnoreProperties(value = "loaiKhoaHoc")
    List<KhoaHoc> khoaHocList;

    public int getLoaiKhoaHocID() {
        return loaiKhoaHocID;
    }

    public void setLoaiKhoaHocID(int loaiKhoaHocID) {
        this.loaiKhoaHocID = loaiKhoaHocID;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public List<KhoaHoc> getKhoaHocList() {
        return khoaHocList;
    }

    public void setKhoaHocList(List<KhoaHoc> khoaHocList) {
        this.khoaHocList = khoaHocList;
    }

}
