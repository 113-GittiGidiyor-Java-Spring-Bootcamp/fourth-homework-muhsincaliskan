package com.patika.hw4.controller;

import com.patika.hw4.dto.InstructorDTO;
import com.patika.hw4.entity.Instructor;
import com.patika.hw4.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/instructors")
@RequiredArgsConstructor
public class InstructorController {
    private InstructorService instructorService;
    @Autowired
    public InstructorController(InstructorService instructorService){this.instructorService=instructorService;}
    @GetMapping("/instructors/{id}")
    public Optional<Instructor> findInstructor(@PathVariable Long instructorId){
        return instructorService.findById(instructorId);
    }
    @GetMapping("/all-instructors")
    public List<Instructor> findAll(){
        return instructorService.findAll();
    }
    @PostMapping("/save-instructor")
    public void save(InstructorDTO instructor){
        instructorService.save(instructor);
    }

    @DeleteMapping("/delete-instructor")
    public void delete(@PathVariable Long id){
        instructorService.deleteById(id);
    }
    @PutMapping("/update-instructors")
    public void update(Instructor instructor){
        instructorService.update(instructor);
    }

}
