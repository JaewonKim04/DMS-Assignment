package com.example.mygithub;

public class Repos {
    String name;
    String update;
    String create;
    String language;

    public Repos(String name, String update, String create, String language) {
        this.name = name;
        this.update = update;
        this.create = create;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
