package com.example.CourseManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class KhoaHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int khoaHocID;

    @Column(name = "ten_khoa_hoc")
    private String tenKhoaHoc;

    @Column(name = "thoi_gian_hoc")
    private String thoiGianHoc;

    @Column(name = "gioi_thieu")
    private String gioiThieu;

    @Column(name = "noi_dung")
    private String noiDung;

    @Column(name = "hoc_phi")
    private int hocPhi;

    @Column(name = "so_hoc_vien")
    private int soHocVien;

    @Column(name = "so_luong_mon")

    private int soLuongMon;

    @Column(name = "hinh_anh")
    private String hinhAnh;

    @Column(name = "loaikhoahocid",insertable = false, updatable = false)
    private int loaiKhoaHocID;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "khoaHoc")
    @JsonIgnoreProperties(value = "khoaHoc")
    List<DangKyHoc> dangKyHocList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loaikhoahocid")
    @JsonIgnoreProperties(value = "khoaHoc1")
    LoaiKhoaHoc loaiKhoaHoc;

    public int getKhoaHocID() {
        return khoaHocID;
    }

    public void setKhoaHocID(int khoaHocID) {
        this.khoaHocID = khoaHocID;
    }

    public String getTenKhoaHoc() {
        return tenKhoaHoc;
    }

    public void setTenKhoaHoc(String tenKhoaHoc) {
        this.tenKhoaHoc = tenKhoaHoc;
    }

    public String getThoiGianHoc() {
        return thoiGianHoc;
    }

    public void setThoiGianHoc(String thoiGianHoc) {
        this.thoiGianHoc = thoiGianHoc;
    }

    public String getGioiThieu() {
        return gioiThieu;
    }

    public void setGioiThieu(String gioiThieu) {
        this.gioiThieu = gioiThieu;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public int getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(int hocPhi) {
        this.hocPhi = hocPhi;
    }

    public int getSoHocVien() {
        return soHocVien;
    }

    public void setSoHocVien(int soHocVien) {
        this.soHocVien = soHocVien;
    }

    public int getSoLuongMon() {
        return soLuongMon;
    }

    public void setSoLuongMon(int soLuongMon) {
        this.soLuongMon = soLuongMon;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public int getLoaiKhoaHocID() {
        return loaiKhoaHocID;
    }

    public void setLoaiKhoaHocID(int loaiKhoaHocID) {
        this.loaiKhoaHocID = loaiKhoaHocID;
    }

    public List<DangKyHoc> getDangKyHocList() {
        return dangKyHocList;
    }

    public void setDangKyHocList(List<DangKyHoc> dangKyHocList) {
        this.dangKyHocList = dangKyHocList;
    }

    public LoaiKhoaHoc getLoaiKhoaHoc() {
        return loaiKhoaHoc;
    }

    public void setLoaiKhoaHoc(LoaiKhoaHoc loaiKhoaHoc) {
        this.loaiKhoaHoc = loaiKhoaHoc;
    }
}
