package com.patika.hw4.controller;

import com.patika.hw4.entity.Student;
import com.patika.hw4.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService){this.studentService=studentService;}
    @GetMapping("/{id}")
    public Student findStudent(@PathVariable int studentId){
        return studentService.findById(studentId);
    }
    @GetMapping("/all-students")
    public List<Student> findAllStudent(){
        return studentService.findAll();
    }
    @PostMapping("/save-student")
    public void saveStudent(Student student){
        studentService.save(student);
    }

    @DeleteMapping("/delete-student")
    public void deleteStudent(@PathVariable int id){
        studentService.deleteById(id);
    }
    @PutMapping("/update-student")
    public void updateStudent(Student student,@PathVariable int id){
        studentService.update(student, id);
    }

}
