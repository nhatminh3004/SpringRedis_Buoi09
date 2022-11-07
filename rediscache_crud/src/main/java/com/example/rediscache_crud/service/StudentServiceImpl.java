package com.example.rediscache_crud.service;

import com.example.rediscache_crud.entity.Student;
import com.example.rediscache_crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl implements  StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public String deleteStudentById(int id) {
        studentRepository.deleteById(id);
        return "Student đã được xoá";
    }

    @Override
    public void updateStudentById( Student student) {
        studentRepository.findById(student.getId()).ifPresent(studentupdate -> {
            studentupdate.setId(student.getId());
            studentupdate.setMasinhvien(student.getMasinhvien());
            studentupdate.setName(student.getName());
            studentRepository.save(studentupdate);
        } );
    }
}
