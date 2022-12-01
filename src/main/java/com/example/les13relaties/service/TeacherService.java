package com.example.les13relaties.service;

import com.example.les13relaties.dto.TeacherDto;
import com.example.les13relaties.model.Teacher;
import com.example.les13relaties.repository.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    private final TeacherRepository repos;

    // constructor injection (instead of @Autowired)
    public TeacherService(TeacherRepository r) {
        this.repos = r;
    }

    public Long createTeacher(TeacherDto teacherDto) {
        Teacher newTeacher = new Teacher();

        // map dto to entity
        newTeacher.setFirstName(teacherDto.firstName);
        newTeacher.setLastName(teacherDto.lastName);
        newTeacher.setDob(teacherDto.dob);

        Teacher savedTeacher = repos.save(newTeacher);
        return savedTeacher.getId();
    }
}
