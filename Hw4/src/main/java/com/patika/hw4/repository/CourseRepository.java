package com.patika.hw4.repository;

import com.patika.hw4.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course,Long> {
}
