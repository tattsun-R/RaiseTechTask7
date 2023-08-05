package com.tattsun.RaiseTechTask7;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UpdateForm {
    private String name;

    private LocalDate birthDate;

    public UpdateForm(String name, LocalDate birthDate) {
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
