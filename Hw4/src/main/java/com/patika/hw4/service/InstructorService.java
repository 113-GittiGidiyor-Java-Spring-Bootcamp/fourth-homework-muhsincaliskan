package com.patika.hw4.service;

import com.patika.hw4.entity.Course;
import com.patika.hw4.entity.Instructor;
import com.patika.hw4.repository.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService implements BaseService<Instructor> {
    InstructorRepository instructorRepository;

    @Override
    public List<Instructor> findAll() {
        return instructorRepository.findAll();

    }

    @Override
    public Instructor findById(Long id) {
        return instructorRepository.findById(id);

    }

    @Override
    public Instructor save(Instructor object) {
        return instructorRepository.save(object);
    }

    @Override
    public void deleteById(Long id) {
        instructorRepository.deleteById(id);
    }

    @Override
    public Instructor update(Instructor object) {
        return instructorRepository.updateOnDatabase(object,id);
    }


    public List<Course> findCoursesOfInstructor(Long id) {
        return findById(id).getCourseList();
    }
}
