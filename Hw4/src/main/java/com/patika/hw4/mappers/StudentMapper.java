package com.patika.hw4.mappers;

import com.patika.hw4.dto.StudentDTO;
import com.patika.hw4.entity.Student;
import org.mapstruct.Mapper;

@Mapper
public interface StudentMapper {
    Student maprFromStudentDTOtoStudent(StudentDTO dto);
    StudentDTO maprFromStudenttoStudentDTO(Student student);
}
