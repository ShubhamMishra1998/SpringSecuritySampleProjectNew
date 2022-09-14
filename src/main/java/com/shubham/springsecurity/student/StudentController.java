package com.shubham.springsecurity.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    private static final List<Student> STUDENTS= Arrays.asList(
            new Student(1,"shubham"),
            new Student(2,"shim"),
            new Student(3,"ram")

    );
    @GetMapping("{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId){
        return STUDENTS.stream().filter(e->e.getStudentId()==studentId).findFirst().orElseThrow(()->new RuntimeException("not found"));
    }
}
