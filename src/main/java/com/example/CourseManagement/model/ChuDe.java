package com.example.CourseManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class ChuDe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chuDeID;

    @Column(name = "ten_chu_de")
    private String tenChuDe;

    @Column(name = "noi_dung")
    private String noiDung;

    @Column(name = "loaibaivietid",insertable = false, updatable = false)
    private int loaiBaiVietID;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "chuDe")
    @JsonIgnoreProperties(value = "chuDe")
    List<BaiViet> baiVietList;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loaibaivietid")
    @JsonIgnoreProperties(value = "chuDeList")
    LoaiBaiViet loaiBaiViet;


    public int getChuDeID() {
        return chuDeID;
    }


    public void setChuDeID(int chuDeID) {
        this.chuDeID = chuDeID;
    }


    public String getTenChuDe() {
        return tenChuDe;
    }


    public void setTenChuDe(String tenChuDe) {
        this.tenChuDe = tenChuDe;
    }


    public String getNoiDung() {
        return noiDung;
    }


    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }


    public int getLoaiBaiVietID() {
        return loaiBaiVietID;
    }


    public void setLoaiBaiVietID(int loaiBaiVietID) {
        this.loaiBaiVietID = loaiBaiVietID;
    }


    public List<BaiViet> getBaiVietList() {
        return baiVietList;
    }


    public void setBaiVietList(List<BaiViet> baiVietList) {
        this.baiVietList = baiVietList;
    }


    public LoaiBaiViet getLoaiBaiViet() {
        return loaiBaiViet;
    }


    public void setLoaiBaiViet(LoaiBaiViet loaiBaiViet) {
        this.loaiBaiViet = loaiBaiViet;
    }
}
