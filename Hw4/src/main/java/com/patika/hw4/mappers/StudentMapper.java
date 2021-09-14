package com.patika.hw4.mappers;

import com.patika.hw4.dto.StudentDTO;
import com.patika.hw4.entity.Student;
import com.patika.hw4.service.StudentService;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    @Autowired
    StudentService STUDENT_SERVICE = null;
    Student maprFromStudentDTOtoStudent(StudentDTO dto);
    StudentDTO maprFromStudenttoStudentDTO(Student student);
}
