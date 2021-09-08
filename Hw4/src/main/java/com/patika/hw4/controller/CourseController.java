package com.patika.hw4.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.patika.hw4.dto.CourseDTO;
import com.patika.hw4.entity.Course;
import com.patika.hw4.entity.Instructor;
import com.patika.hw4.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private CourseService courseService;
    @Autowired

    public CourseController(CourseService courseService){this.courseService=courseService;}

    /**
     * @param courseId
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Course> findCourse(Long courseId){
        return new ResponseEntity<>(courseService.findById(courseId).get(),HttpStatus.OK);
    }

    /**
     * @return
     */
    @GetMapping("/all-courses")
    public ResponseEntity<List<Course>> findAllCourse(){

        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }

    /**
     * @param courseDTO
     * @return
     */
    @PostMapping("/save-course")
    public ResponseEntity<Course> saveCourse(@RequestBody @Valid CourseDTO courseDTO){
        Optional<Course> course= courseService.save(courseDTO);
        return new ResponseEntity<>(course.get(),HttpStatus.OK);
    }

    /**
     * @param id
     * @return
     */
    @DeleteMapping("/delete-course")
    public ResponseEntity<Course> deleteCourse(@PathVariable Long id){
        Optional<Course> course=courseService.findById(id);
        courseService.deleteById(id);
        return new ResponseEntity<>(course.get(),HttpStatus.OK);
    }

    /**
     * @param course
     * @return
     */
    @PutMapping("/courses/")
    public Course updateCourse(@RequestBody Course course){
        return courseService.update(course);

    }

    /**
     * @param id
     * @return
     */
    @JsonProperty("instructor")
    @GetMapping("/courses/{id}")
    public ResponseEntity<Instructor> getInstructor(@RequestBody Long id){

        return new ResponseEntity<>(courseService.findInstructorOfCourse(id),HttpStatus.OK);

    }
}
