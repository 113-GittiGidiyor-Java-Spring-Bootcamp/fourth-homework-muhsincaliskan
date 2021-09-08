package com.patika.hw4.controller;

import com.patika.hw4.dto.InstructorDTO;
import com.patika.hw4.entity.Instructor;
import com.patika.hw4.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/instructors")
@RequiredArgsConstructor
public class InstructorController {
    private InstructorService instructorService;

    /**
     * @param instructorService
     */
    @Autowired
    public InstructorController(InstructorService instructorService){this.instructorService=instructorService;}
    @GetMapping("/instructors/{id}")
    public ResponseEntity<Instructor> findInstructor(@PathVariable Long instructorId){
        Optional<Instructor> instructor=instructorService.findById(instructorId);
        return new ResponseEntity<>(instructor.get(),HttpStatus.OK);
    }

    /**
     * @return
     */
    @GetMapping("/all-instructors")
    public ResponseEntity<List<Instructor>> findAll(){

        return new ResponseEntity<>( instructorService.findAll(), HttpStatus.OK);
    }

    /**
     * @param instructor
     */
    @PostMapping("/save-instructor")
    public void save(InstructorDTO instructor){
        instructorService.save(instructor);
    }

    /**
     * @param id
     */
    @DeleteMapping("/delete-instructor")
    public void delete(@PathVariable Long id){
        instructorService.deleteById(id);
    }
    @PutMapping("/update-instructors")
    public void update(Instructor instructor){
        instructorService.update(instructor);
    }

}
