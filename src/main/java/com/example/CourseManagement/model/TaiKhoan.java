package com.example.CourseManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.intellij.lang.annotations.Pattern;



import java.util.List;


@Entity
@Table
public class TaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taiKhoanID;

    @Column(name = "ten_nguoi_dung")
    private String tenNguoiDung;

    @Column(name = "tai_khoan", unique = true)
    private String taiKhoan;

    @Column(name = "mat_khau")
    private String matKhau;

    @Column(name = "quyenhanid",insertable = false, updatable = false)
    private int quyenHanID;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "taiKhoan")
    @JsonIgnoreProperties(value = "taiKhoan")
    List<BaiViet> baiVietList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quyenhanid")
    @JsonIgnoreProperties(value = "taiKhoanList")
    QuyenHan quyenHan;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "taiKhoan")
    @JsonIgnoreProperties(value = "taiKhoan1")
    List<DangKyHoc> dangKyHocList;

    public int getTaiKhoanID() {
        return taiKhoanID;
    }

    public void setTaiKhoanID(int taiKhoanID) {
        this.taiKhoanID = taiKhoanID;
    }

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public int getQuyenHanID() {
        return quyenHanID;
    }

    public void setQuyenHanID(int quyenHanID) {
        this.quyenHanID = quyenHanID;
    }

    public List<BaiViet> getBaiVietList() {
        return baiVietList;
    }

    public void setBaiVietList(List<BaiViet> baiVietList) {
        this.baiVietList = baiVietList;
    }

    public QuyenHan getQuyenHan() {
        return quyenHan;
    }

    public void setQuyenHan(QuyenHan quyenHan) {
        this.quyenHan = quyenHan;
    }

    public List<DangKyHoc> getDangKyHocList() {
        return dangKyHocList;
    }

    public void setDangKyHocList(List<DangKyHoc> dangKyHocList) {
        this.dangKyHocList = dangKyHocList;
    }
}
