package com.patika.hw4.service;

import com.patika.hw4.dto.CourseDTO;
import com.patika.hw4.entity.Course;
import com.patika.hw4.entity.Instructor;
import com.patika.hw4.exceptions.CourseIsAlreadyExistException;
import com.patika.hw4.mappers.CourseMapper;
import com.patika.hw4.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CourseService implements BaseService<Course> {
    private final CourseRepository courseRepository;
    public final CourseMapper courseMapper;
    @Override
    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }


    /**
     * @param id
     * @return
     */
    @Transactional
    public Optional<Course> findById(Long id) {

        return  courseRepository.findById(id);
    }

    /**
     * @param object
     * @return
     */
    @Transactional
    public Optional<Course> save(CourseDTO object) {

        boolean isExists=  courseRepository.existsById(object.getId());

        if (isExists){
            throw new CourseIsAlreadyExistException("Course is already Exists");
        }
        Course course=courseMapper.maprFromCourseDTOtoCourse(object);
        return Optional.of(courseRepository.save(course));
    }

    /**
     * @param id
     */
    @Override
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }

    /**
     * @param object
     * @return
     */
    @Override
    public Course update(Course object) {
        return courseRepository.save(object);
    }

    /**
     * @param id
     * @return
     */
    public Instructor findInstructorOfCourse(Long id) {

        return courseRepository.findById(id).get().getInstructor();

    }

}
