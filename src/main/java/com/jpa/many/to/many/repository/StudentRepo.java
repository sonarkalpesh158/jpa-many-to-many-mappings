package com.jpa.many.to.many.repository;

import com.jpa.many.to.many.entity.Course;
import com.jpa.many.to.many.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo  extends JpaRepository<Student,Long> {
    List<Student> findByNameContaining(String name);

}
