package com.example.CourseManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Table
public class LoaiBaiViet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loaiBaiVietID;

    @Column(name = "ten_loai_bv")

    private String tenLoai;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "loaiBaiViet")
    @JsonIgnoreProperties(value = "loaiBaiViet")
    List<ChuDe> chuDeList;

    public int getLoaiBaiVietID() {
        return loaiBaiVietID;
    }

    public void setLoaiBaiVietID(int loaiBaiVietID) {
        this.loaiBaiVietID = loaiBaiVietID;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public List<ChuDe> getChuDeList() {
        return chuDeList;
    }

    public void setChuDeList(List<ChuDe> chuDeList) {
        this.chuDeList = chuDeList;
    }
}
