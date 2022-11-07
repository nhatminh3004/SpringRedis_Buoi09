package com.example.rediscache_crud.repository;

import com.example.rediscache_crud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
