package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {

    @Autowired
    private Repository repository;

    @Secured("ROLE_GUEST")
    @GetMapping("hello")
    public String hello() {
        return "Hello Word Armmy Is Normal";
    }

    //@Secured("ROLE_USER")
    @GetMapping("hello1")
    public String hello1() {
        return "Hello Word 1";
    }

    @GetMapping("add")
    public String addData() {
        Student student = new Student();
        student.setName("ARMMY");
        student.setAge(33);
        repository.save(student);
        return "Success"+student.toString();
    }

    @GetMapping("getData")
    public List<Student> getData() {
        List<Student> students = repository.findAll();
        return students;
    }

}
