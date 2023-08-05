package com.tattsun.RaiseTechTask7;

import org.springframework.lang.NonNull;

import java.time.LocalDate;

public class UserProfile {

    private String name;
    private LocalDate birthDate;

    public UserProfile(String name, LocalDate birthDate) {
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
