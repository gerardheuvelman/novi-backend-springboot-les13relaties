package com.example.les13relaties.controller;

import com.example.les13relaties.dto.TeacherDto;
import com.example.les13relaties.service.TeacherService;
import com.example.les13relaties.util.Utils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService service;

    public TeacherController(TeacherService s) {
        this.service = s;
    }

    //@GetMapping("")
    //public ResponseEntity<Iterable<Teacher>> getTeachers() {
    //    return ResponseEntity.ok(repos.findAll());
    //}

    @PostMapping("")
    public ResponseEntity<String> createTeacher(@Valid @RequestBody TeacherDto teacherDto, BindingResult br) {

        if (br.hasErrors()) {
            // something's wrong
            String errorStr = Utils.reportErrors(br);
            return new ResponseEntity<>(errorStr, HttpStatus.BAD_REQUEST);
        }
        else {
            // happy flow
            Long createdId = service.createTeacher(teacherDto);

            URI uri = URI.create(
                    ServletUriComponentsBuilder
                            .fromCurrentContextPath()
                            .path("/teachers/" + createdId).toUriString());
            return ResponseEntity.created(uri).body("Teacher created!");
        }
    }
}
