package com.example.h2connections.Repositary;

import com.example.h2connections.dao.Student1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository
     extends JpaRepository<Student1, Integer> {


    }


