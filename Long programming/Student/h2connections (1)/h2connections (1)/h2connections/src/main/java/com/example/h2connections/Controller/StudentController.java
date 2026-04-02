package com.example.h2connections.Controller;
import com.example.h2connections.Service.StudentService;

import com.example.h2connections.dao.Student1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/students")
    public List<Student1> getStudents() {

        return service.getAllStudents();
    }

    @PostMapping("/students")
    public Student1 addStudent(@RequestBody Student1 S) {
        return service.SaveStudent(S);
    }

    @PutMapping("students/{id}")
    public Student1 update(@PathVariable int id, @RequestBody Student1 S) {
        return service.updateStudent(id, S);
    }

    @DeleteMapping("students/{id}")
    public String delete(@PathVariable int id) {
        return service.deleteStudent(id);
    }
}


