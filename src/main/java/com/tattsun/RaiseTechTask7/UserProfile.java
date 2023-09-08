package com.tattsun.RaiseTechTask7;

public class UserProfile {
    private Integer id;
    private String name;

    public UserProfile(Integer id, String name) {
        this.id = id;
        this.name = name;
        }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
