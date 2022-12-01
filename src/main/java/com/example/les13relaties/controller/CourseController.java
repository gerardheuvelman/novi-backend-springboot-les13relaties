package com.example.les13relaties.controller;

import com.example.les13relaties.model.Course;
import com.example.les13relaties.repository.CourseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseRepository repos;

    public CourseController(CourseRepository cr) {
        this.repos = cr;
    }

    @GetMapping("")
    public ResponseEntity<Iterable<Course>> getCourses() {
        return new ResponseEntity<>(repos.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Long> createCourse(@RequestBody Course newCourse) {
        repos.save(newCourse);

        return new ResponseEntity<>(newCourse.getId(), HttpStatus.CREATED);
    }
}
