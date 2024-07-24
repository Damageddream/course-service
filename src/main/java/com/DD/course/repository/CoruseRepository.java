package com.DD.course.repository;

import com.DD.course.model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CoruseRepository extends MongoRepository<Course, String> {
    List<Course> findAllByStatus(Course.Status status);
}
