package com.patika.hw4.mappers;

import com.patika.hw4.dto.CourseDTO;
import com.patika.hw4.entity.Course;
import com.patika.hw4.service.CourseService;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    @Autowired
    CourseService courseService = null;
    Course maprFromCourseDTOtoCourse(CourseDTO courseDTO);
    CourseDTO maprFromCoursetoCourseDTO(Course course);
}
