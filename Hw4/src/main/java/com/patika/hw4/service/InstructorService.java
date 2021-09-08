package com.patika.hw4.service;

import com.patika.hw4.dto.InstructorDTO;
import com.patika.hw4.entity.Course;
import com.patika.hw4.entity.Instructor;
import com.patika.hw4.exceptions.InstructorIsAlreadyExistException;
import com.patika.hw4.mappers.InstructorMapper;
import com.patika.hw4.repository.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService implements BaseService<Instructor> {
    InstructorRepository instructorRepository;
    InstructorMapper instructorMapper;

    @Override
    public List<Instructor> findAll() {
        return instructorRepository.findAll();

    }
    @Override
    public Instructor findById(Long id) {
        return instructorRepository.findById(id);

    }
    public Optional<Instructor> save(InstructorDTO object) {
        boolean isExists=  instructorRepository.existsById(object.getId());

        if (isExists){
            throw new InstructorIsAlreadyExistException("Course is already Exists");
        }
        Instructor instructor=instructorMapper.maprFromInstructoDTOrtoInstructor(object);
        return Optional.of(instructorRepository.save(instructor));
    }
    @Override
    public void deleteById(Long id) {
        instructorRepository.deleteById(id);
    }
    @Override
    public Instructor update(Instructor object) {
        return instructorRepository.save(object);
    }

    public List<Course> findCoursesOfInstructor(Long id) {
        return findById(id).getCourseList();
    }
}
