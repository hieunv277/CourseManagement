package com.example.CourseManagement.repository;

import com.example.CourseManagement.model.HocVien;
import com.example.CourseManagement.model.KhoaHoc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KhoaHocRepo extends JpaRepository<KhoaHoc,Integer> {
}
