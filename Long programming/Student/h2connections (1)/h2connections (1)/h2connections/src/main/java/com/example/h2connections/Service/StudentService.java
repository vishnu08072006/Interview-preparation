package com.example.h2connections.Service;

import com.example.h2connections.Repositary.StudentRepository;
import com.example.h2connections.dao.Student1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repo;
    public Student1 SaveStudent(Student1 S){
        return repo.save(S);
    }
    public List<Student1> getAllStudents(){

        return repo.findAll();
    }
    public String deleteStudent(int id){
        repo.deleteById(id);
        return "Deleted successfully";
    }
    public Student1 updateStudent(int id,Student1 S){
        Student1 existing=repo.findById(id).orElse(null);
        if(existing!=null){
            existing.setFirstName(S.getFirstName());
            existing.setLastName(S.getLastName());
            existing.setResult(S.getResult());
            repo.save(existing);
        }
        return null;

    }

}







































