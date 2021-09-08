package com.patika.hw4.mappers;

import com.patika.hw4.dto.CourseDTO;
import com.patika.hw4.dto.InstructorDTO;
import com.patika.hw4.entity.Course;
import com.patika.hw4.entity.Instructor;
import org.mapstruct.Mapper;

@Mapper
public interface InstructorMapper {
    Instructor maprFromInstructoDTOrtoInstructor(InstructorDTO dto);
    InstructorDTO maprFromInstructortoInstructorDTO(Instructor student);
}
