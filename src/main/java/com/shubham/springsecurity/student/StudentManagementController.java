package com.shubham.springsecurity.student;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {
    private static final List<Student> STUDENTS= Arrays.asList(
            new Student(1,"shubham"),
            new Student(2,"shim"),
            new Student(3,"ram")

    );
    //    hasRole('ROLE_') hasAnyRole('ROLE_') hasAuthority('permission') hasAnyAuthority('permission')
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMINTRAINEE')")
    public List<Student> getAllStudents(){
        return STUDENTS;
    }
    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void registerNewStudent(@RequestBody Student student){
        System.out.println(student);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable("id") int id){
        System.out.println(id);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(@PathVariable("id") int id,@RequestBody Student student){
        System.out.println(""+id+" "+student);
    }


}
