package com.DD.course.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CourseExceptionHandler {
    @ExceptionHandler(value = CourseException.class)
    public ResponseEntity<ErrorInfor> handleException(CourseException e){
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        if(CourseError.COURSE_NOT_FOUND.equals(e.getCourseError())) {
            httpStatus = HttpStatus.NOT_FOUND;
        }
        return ResponseEntity.status(httpStatus).body(new ErrorInfor(e.getCourseError().getMessage()));
    }

}
