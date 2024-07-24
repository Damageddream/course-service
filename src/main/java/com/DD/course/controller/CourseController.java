package com.DD.course.controller;

import com.DD.course.model.Course;
import com.DD.course.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getAllCourses(@RequestParam(required = false)Course.Status status) {
        return courseService.getCourses(status);
    }

    @PostMapping
    public Course addcourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    @GetMapping("/{code}")
    public Course getCourse(@PathVariable String code){
        return  courseService.getCourseById(code);
    }
}
