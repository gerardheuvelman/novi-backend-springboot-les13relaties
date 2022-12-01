package com.example.les13relaties.controller;


import com.example.les13relaties.dto.TeacherDto;
import com.example.les13relaties.model.Course;
import com.example.les13relaties.model.Lesson;
import com.example.les13relaties.repository.LessonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/lessons")
public class LessonController {

    private final LessonRepository repos;

    public LessonController(LessonRepository lr) {this.repos = lr;}

    @GetMapping("")
    public ResponseEntity<Iterable<Lesson>> getLessons() {
        return new ResponseEntity<>(repos.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Long> createLesson(@RequestBody Lesson newLesson) {
        repos.save(newLesson);

        return new ResponseEntity<>(newLesson.getId(), HttpStatus.CREATED);
    }


}
