package com.example.rediscache_crud.restcontroller;

import com.example.rediscache_crud.entity.Student;
import com.example.rediscache_crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping("/students")
    @Cacheable("students")
    public List<Student> getAllStudent(){
        System.out.println("Lấy dữ liệu All Student từ Database ");
        return  studentService.getAllStudent();
    }
    @GetMapping("/students/{id}")
    @Cacheable(value ="students",key = "#id")
    public Student getStudentById(@PathVariable int id){
        System.out.println("Lấy dữ  liệu 1 Student từ Database ");
        return  studentService.getStudentById(id);
    }
    @PostMapping("/students")
    @CacheEvict(value = "students",allEntries = true)
    public Student addNewStudent(@RequestBody Student student){
        System.out.println("add student Vào Database ");
        return  studentService.addStudent(student);
    }
    @PutMapping("/students")

    public void updateStudent(@RequestBody Student student){
        System.out.println("Update Student Từ DB");
         studentService.updateStudentById(student);
    }
    @DeleteMapping("/students/{id}")
    @CacheEvict(value = "students",allEntries = true)
    public String deleteStudentById(@PathVariable int id){
        System.out.println("Xoá 1 Student từ Database ");
        studentService.deleteStudentById(id);
        return "Delete Success Student "+id;
    }
}
