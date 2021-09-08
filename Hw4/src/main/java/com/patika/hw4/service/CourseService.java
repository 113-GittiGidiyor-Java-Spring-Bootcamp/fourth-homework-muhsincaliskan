package com.patika.hw4.service;

import com.patika.hw4.dto.CourseDTO;
import com.patika.hw4.entity.Course;
import com.patika.hw4.entity.Instructor;
import com.patika.hw4.mappers.CourseMapper;
import com.patika.hw4.repository.CourseRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements BaseService<Course> {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    public CourseService(CourseRepository courseRepository ){this.courseRepository=courseRepository;}
    @Override
    public Optional <List<Course>> findAll() {
        return courseRepository.findAll();
    }

    @Transactional
    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }

    @Transactional
    public Optional<Course> save(CourseDTO object) {

        boolean isExists=  courseRepository.existsById(object.getId());

        if (isExists){
            throw new ArrayIndexOutOfBoundsException("Course is already Exists");
        }
        Course course=courseMapper.maprFromCourseDTOtoCourse(object);
        return Optional.of(courseRepository.save(course));
    }

    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }

    public Course update(Course object) {
        return courseRepository.save(object);
    }
    public Instructor findInstructorOfCourse(int id) {

        return findById(id).getInstructor();

    }

}
