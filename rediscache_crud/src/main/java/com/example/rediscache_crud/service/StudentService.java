package com.example.rediscache_crud.service;

import com.example.rediscache_crud.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudent();
    public Student addStudent(Student student);
    public Student getStudentById(int id);
    public String deleteStudentById(int id);
    public void updateStudentById( Student student);
}
