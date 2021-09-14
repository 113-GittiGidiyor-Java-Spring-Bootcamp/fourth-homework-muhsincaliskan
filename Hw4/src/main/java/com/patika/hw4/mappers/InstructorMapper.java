package com.patika.hw4.mappers;


import com.patika.hw4.dto.InstructorDTO;

import com.patika.hw4.entity.Instructor;
import com.patika.hw4.service.InstructorService;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public interface InstructorMapper {
    @Autowired
    InstructorService instructorService=null;
    Instructor maprFromInstructoDTOrtoInstructor(InstructorDTO instructorDTO);
    InstructorDTO maprFromInstructortoInstructorDTO(Instructor instructor);
}
