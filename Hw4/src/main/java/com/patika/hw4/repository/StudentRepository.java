package com.patika.hw4.repository;

import com.patika.hw4.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Long> {
}
