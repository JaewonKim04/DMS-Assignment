package com.model;
import com.google.gson.annotations.SerializedName;

public class GitHubRepo {
    @SerializedName("name")
    private String name;

    @SerializedName("created_at")
    private String create;
    @SerializedName("pushed_at")
    private String update;
    @SerializedName("language")
    private String language;


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

    public GitHubRepo(
            String language,
            String create,
            String name,
            String update) {

        this.setLanguage(language);
        this.setName(name);
        this.setCreate(create);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
