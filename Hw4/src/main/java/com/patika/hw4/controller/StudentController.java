package com.patika.hw4.controller;

import com.patika.hw4.dto.StudentDTO;
import com.patika.hw4.entity.Student;
import com.patika.hw4.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService){this.studentService=studentService;}

    /**
     * @param studentId
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Student> findStudent(@PathVariable Long studentId){
        return new ResponseEntity<>(studentService.findById(studentId).get(), HttpStatus.OK) ;
    }

    /**
     * @return
     */
    @GetMapping("/all-students")
    public List<Student> findAllStudent(){
        return studentService.findAll();
    }

    /**
     * @param student
     */
    @PostMapping("/save-student")
    public void saveStudent(StudentDTO student){
        studentService.save(student);
    }

    /**
     * @param id
     */
    @DeleteMapping("/delete-student")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteById(id);
    }
    @PutMapping("/update-student")
    public void updateStudent(Student student,@PathVariable int id){
        studentService.update(student);
    }

}
