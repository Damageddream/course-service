package com.DD.course.service;

import com.DD.course.model.Course;
import com.DD.course.repository.CoruseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {

    private final CoruseRepository courseRepository;

    public CourseServiceImpl(CoruseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getCourses(Course.Status status) {
        if(status!= null){
            return courseRepository.findAllByStatus(status);
        }
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(String id) {
        Course course = courseRepository.findById(id).orElseThrow(null);
        return course;
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }
}
