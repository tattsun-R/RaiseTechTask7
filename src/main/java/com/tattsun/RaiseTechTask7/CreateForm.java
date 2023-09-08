package com.tattsun.RaiseTechTask7;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class CreateForm {
    @NotBlank(message = "Name cannot be blank")
    String name;
    @NotNull(message = "birthDate cannot be blank")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate birthDate;


        public CreateForm(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }


    public String getName() {
        return name;
    }


    public LocalDate getBirthDate() {
        return birthDate;
    }

}
