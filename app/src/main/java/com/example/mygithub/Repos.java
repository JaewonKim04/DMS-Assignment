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

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public String getCreate() {
        return create;
    }

    public void setCreate(String create) {
        this.create = create;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
