package com.example.les13relaties.repository;

import com.example.les13relaties.model.Teacher;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
    public Iterable<Teacher> findByDobAfter(LocalDate date);
}
