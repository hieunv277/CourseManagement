package com.example.CourseManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class HocVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hocVienID;

    @Column(name = "ho_ten")
    private String hoTen;

    @Column(name = "hinh_anh")
    private String hinhAnh;

    @Column(name = "ngay_sinh")
    private String ngaySinh;

    @Column(name = "sdt",unique = true)
    private String sdt;

    @Column(name = "email",unique = true)
    private String email;

    @Column(name = "tinh_thanh")
    private String tinhThanh;

    @Column(name = "quan_huyen")
    private String quanHuyen;

    @Column(name = "phuong_xa")
    private String phuongXa;

    @Column(name = "so_nha")
    private String soNha;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hocVien")
    @JsonIgnoreProperties(value = "hocVien")
    List<DangKyHoc> dangKyHocList;

    public int getHocVienID() {
        return hocVienID;
    }

    public void setHocVienID(int hocVienID) {
        this.hocVienID = hocVienID;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTinhThanh() {
        return tinhThanh;
    }

    public void setTinhThanh(String tinhThanh) {
        this.tinhThanh = tinhThanh;
    }

    public String getQuanHuyen() {
        return quanHuyen;
    }

    public void setQuanHuyen(String quanHuyen) {
        this.quanHuyen = quanHuyen;
    }

    public String getPhuongXa() {
        return phuongXa;
    }

    public void setPhuongXa(String phuongXa) {
        this.phuongXa = phuongXa;
    }

    public String getSoNha() {
        return soNha;
    }

    public void setSoNha(String soNha) {
        this.soNha = soNha;
    }

    public List<DangKyHoc> getDangKyHocList() {
        return dangKyHocList;
    }

    public void setDangKyHocList(List<DangKyHoc> dangKyHocList) {
        this.dangKyHocList = dangKyHocList;
    }
}
