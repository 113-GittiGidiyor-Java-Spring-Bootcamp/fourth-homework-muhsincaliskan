package com.patika.hw4.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.patika.hw4.entity.Course;
import com.patika.hw4.entity.Instructor;
import com.patika.hw4.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private CourseService courseService;
    @Autowired
    public CourseController(CourseService courseService){this.courseService=courseService;}

    @GetMapping("/{id}")
    public Course findCourse(Long courseId){
        return courseService.findById(courseId);
    }
    @GetMapping("/all-courses")
    public ResponseEntity<List<Course>> findAllCourse(){

        return new ResponseEntity<>( courseService.findAll(), HttpStatus.OK);
    }
    @PostMapping("/save-course")
    public Course saveCourse(@RequestBody Course course){
        return courseService.save(course);
    }

    @DeleteMapping("/delete-course")
    public String deleteCourse(@PathVariable int id){
        courseService.deleteById(id);
        return "Deleted...";
    }

    @PutMapping("/courses/")
    public Course updateCourse(@RequestBody Course course){
        return courseService.update(course);

    }
    @JsonProperty("instructor")
    @GetMapping("/courses/{id}")
    public Instructor getInstructor(@RequestBody int id){

        return courseService.findInstructorOfCourse(id);

    }
}
