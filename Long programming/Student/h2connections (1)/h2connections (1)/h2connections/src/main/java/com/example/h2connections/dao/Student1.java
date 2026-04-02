package com.example.h2connections.dao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
    @Table(name = "students")
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class Student1{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        @Column(name="Firstname")
        private String firstName;
        private String lastName;
        private String result;
    }

