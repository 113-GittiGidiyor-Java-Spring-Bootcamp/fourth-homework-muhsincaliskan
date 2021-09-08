package com.patika.hw4.controller;

import com.patika.hw4.entity.Instructor;
import com.patika.hw4.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
@RequiredArgsConstructor
public class InstructorController {
    private InstructorService instructorService;
    @Autowired
    public InstructorController(InstructorService instructorService){this.instructorService=instructorService;}
    @GetMapping("/instructors/{id}")
    public Instructor findInstructor(@PathVariable int instructorId){
        return instructorService.findById(instructorId);
    }
    @GetMapping("/all-instructors")
    public List<Instructor> findAll(){
        return instructorService.findAll();
    }
    @PostMapping("/save-instructor")
    public void save(Instructor instructor){
        instructorService.save(instructor);
    }

    @DeleteMapping("/delete-instructor")
    public void delete(@PathVariable int id){
        instructorService.deleteById(id);
    }
    @PutMapping("/update-instructors")
    public void update(Instructor instructor,@PathVariable int id){
        instructorService.update(instructor, id);
    }

}
