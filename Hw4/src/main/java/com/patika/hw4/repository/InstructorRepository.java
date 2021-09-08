package com.patika.hw4.repository;

import com.patika.hw4.entity.Instructor;
import org.springframework.data.repository.CrudRepository;
public interface InstructorRepository extends CrudRepository<Instructor,Long> {
}