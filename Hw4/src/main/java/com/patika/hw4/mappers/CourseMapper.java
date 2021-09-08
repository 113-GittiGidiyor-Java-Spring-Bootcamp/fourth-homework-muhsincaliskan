package com.patika.hw4.mappers;

import com.patika.hw4.dto.CourseDTO;
import com.patika.hw4.entity.Course;
import org.mapstruct.Mapper;

@Mapper
public interface CourseMapper {
    Course maprFromCourseDTOtoCourse(CourseDTO dto);
    CourseDTO maprFromCoursetoCourseDTO(Course student);
}
