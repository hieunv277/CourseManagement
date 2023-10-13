package com.example.CourseManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class QuyenHan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int quyenHantID;

    @Column(name = "ten_quyen_han")

    private String tenQuyenHan;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "quyenHan")
    @JsonIgnoreProperties(value = "quyenHan")
    List<TaiKhoan> taiKhoanList;

    public int getQuyenHantID() {
        return quyenHantID;
    }

    public void setQuyenHantID(int quyenHantID) {
        this.quyenHantID = quyenHantID;
    }

    public String getTenQuyenHan() {
        return tenQuyenHan;
    }

    public void setTenQuyenHan(String tenQuyenHan) {
        this.tenQuyenHan = tenQuyenHan;
    }

    public List<TaiKhoan> getTaiKhoanList() {
        return taiKhoanList;
    }

    public void setTaiKhoanList(List<TaiKhoan> taiKhoanList) {
        this.taiKhoanList = taiKhoanList;
    }
}
