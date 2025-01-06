package com.jpa.many.to.many.repository;

import com.jpa.many.to.many.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepo extends JpaRepository<Course,Long> {

    List<Course> findByFeeLessThan(double fee);
}
