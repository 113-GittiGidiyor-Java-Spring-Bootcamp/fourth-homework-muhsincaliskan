package com.patika.hw4.service;

import com.patika.hw4.entity.Course;
import com.patika.hw4.entity.Student;
import com.patika.hw4.repository.StudentRepository;
import com.patika.thirdhw.entity.Course;
import com.patika.thirdhw.entity.Student;
import com.patika.thirdhw.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements BaseService<Student> {
    private StudentRepository studentRepository;

    @Override
    public List findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return  studentRepository.findById(id);
    }

    @Override
    public Student save(Student object) {
        return studentRepository.save(object);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student update(Student object) {
        return studentRepository.save(object);
    }

    public List<Course> findCoursesOfStudent(int id) {
        return findById(id).getStudentCourses();
    }
}
