package com.jpa.many.to.many.controller;

import com.jpa.many.to.many.entity.Course;
import com.jpa.many.to.many.entity.Student;
import com.jpa.many.to.many.repository.CourseRepo;
import com.jpa.many.to.many.repository.StudentRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/course")
public class StudentCourseController {

    private final StudentRepo studentRepo;
    private final CourseRepo courseRepo;

    public StudentCourseController(StudentRepo studentRepo, CourseRepo courseRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    @PostMapping
    public Student saveStudent(@RequestBody Student student){
        return studentRepo.save(student);
    }
    @GetMapping
    public List<Student> findAllStud( ){
        return studentRepo.findAll();
    }
    @GetMapping("/{studId}")
    public Student findAllStud(@PathVariable Long studId){
        return studentRepo.findById(studId).orElse(null);
    }
    @GetMapping("/{name}")
    public List<Student> findStudByName(String name){
        return studentRepo.findByNameContaining(name);
    }
    @GetMapping("/{price}")
    public List<Course> findCourseLessThanPrice(double price){
        return courseRepo.findByFeeLessThan(price);
    }
}
