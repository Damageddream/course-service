package com.DD.course.service;

import com.DD.course.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getCourses(Course.Status status);
    Course getCourseById(String id);
    Course addCourse(Course course);
}
