package com.example.les13relaties.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class TeacherDto {
    @NotBlank
    public String firstName;
    @NotBlank
    @Size(min=3, max=128)
    public String lastName;
    @Past
    public LocalDate dob;
}
