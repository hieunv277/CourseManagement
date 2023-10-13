package com.example.CourseManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table
public class BaiViet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bai_viet_id")
    private int baiVietID;


    @Column(name = "ten_bai_viet")
    private String tenBaiViet;


    @Column(name = "ten_tac_gia")
    private String tenTacGia;


    @Column(name = "noi_dung")
    private String noiDung;

    @Column(name = "noi_dung_ngan")
    private String noiDungNgan;


    @Column(name = "hinh_anh")
    private String hinhAnh;

    @Column(name = "chudeid", insertable = false, updatable = false)
    private int chuDeID;

    @Column(name = " taikhoanid", insertable = false, updatable = false)
    private int taiKhoanID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chudeid")
    @JsonIgnoreProperties(value = "baiVietList")
    ChuDe chuDe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "taikhoanid")
    @JsonIgnoreProperties(value = "baiVietList1")
    TaiKhoan taiKhoan;

    public int getBaiVietID() {
        return baiVietID;
    }

    public void setBaiVietID(int baiVietID) {
        this.baiVietID = baiVietID;
    }

    public String getTenBaiViet() {
        return tenBaiViet;
    }

    public void setTenBaiViet(String tenBaiViet) {
        this.tenBaiViet = tenBaiViet;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getNoiDungNgan() {
        return noiDungNgan;
    }

    public void setNoiDungNgan(String noiDungNgan) {
        this.noiDungNgan = noiDungNgan;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public int getChuDeID() {
        return chuDeID;
    }

    public void setChuDeID(int chuDeID) {
        this.chuDeID = chuDeID;
    }

    public int getTaiKhoanID() {
        return taiKhoanID;
    }

    public void setTaiKhoanID(int taiKhoanID) {
        this.taiKhoanID = taiKhoanID;
    }

    public ChuDe getChuDe() {
        return chuDe;
    }

    public void setChuDe(ChuDe chuDe) {
        this.chuDe = chuDe;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

}
