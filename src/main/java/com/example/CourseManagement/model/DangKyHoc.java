package com.example.CourseManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table
public class DangKyHoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dkHocID;

    @Column(name = "ngay_dang_ky")
    private String ngayDangKy;

    @Column(name = "ngay_bat_dau")
    private String ngayBatDau;

    @Column(name = "ngay_ket_thuc")
    private String ngayKetThuc;

    @Column(name = "tinhtranghocid",insertable = false, updatable = false)
    private int tinhTrangHocID;

    @Column(name = "taikhoanid",insertable = false, updatable = false)
    private int taiKhoanID;

    @Column(name = "hocvienid",insertable = false, updatable = false)
    private int hocVienID;

    @Column(name = "khoahocid",insertable = false, updatable = false)
    private int khoaHocID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tinhtranghocid")
    @JsonIgnoreProperties(value = "dangKyHocList1")
    TinhTrangHoc tinhTrangHoc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "taikhoanid")
    @JsonIgnoreProperties(value = "dangKyHocList2")
    TaiKhoan taiKhoan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hocvienid")
    @JsonIgnoreProperties(value = "dangKyHocList3")
    HocVien hocVien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "khoahocid")
    @JsonIgnoreProperties(value = "dangKyHocList4")
    KhoaHoc khoaHoc;

    public int getDkHocID() {
        return dkHocID;
    }

    public void setDkHocID(int dkHocID) {
        this.dkHocID = dkHocID;
    }

    public String getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(String ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getTinhTrangHocID() {
        return tinhTrangHocID;
    }

    public void setTinhTrangHocID(int tinhTrangHocID) {
        this.tinhTrangHocID = tinhTrangHocID;
    }

    public int getTaiKhoanID() {
        return taiKhoanID;
    }

    public void setTaiKhoanID(int taiKhoanID) {
        this.taiKhoanID = taiKhoanID;
    }

    public int getHocVienID() {
        return hocVienID;
    }

    public void setHocVienID(int hocVienID) {
        this.hocVienID = hocVienID;
    }

    public int getKhoaHocID() {
        return khoaHocID;
    }

    public void setKhoaHocID(int khoaHocID) {
        this.khoaHocID = khoaHocID;
    }

    public TinhTrangHoc getTinhTrangHoc() {
        return tinhTrangHoc;
    }

    public void setTinhTrangHoc(TinhTrangHoc tinhTrangHoc) {
        this.tinhTrangHoc = tinhTrangHoc;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public HocVien getHocVien() {
        return hocVien;
    }

    public void setHocVien(HocVien hocVien) {
        this.hocVien = hocVien;
    }

    public KhoaHoc getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(KhoaHoc khoaHoc) {
        this.khoaHoc = khoaHoc;
    }
}
