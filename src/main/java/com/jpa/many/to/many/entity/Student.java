package com.jpa.many.to.many.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "student_tbl")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student{
    @Id
    @GeneratedValue
    private Long id;
    private int age;
    private String name;
    private String dept;
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "STUDENT_COURSE_TABLE",
    joinColumns={
            @JoinColumn(name = "student_id",referencedColumnName = "id")
    },
    inverseJoinColumns = {
            @JoinColumn(name = "course_id",referencedColumnName = "id")
    }
    )
    @JsonManagedReference
    private Set<Course> courses;
}
