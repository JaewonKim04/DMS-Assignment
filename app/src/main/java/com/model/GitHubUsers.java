package com.model;
import com.google.gson.annotations.SerializedName;

public class GitHubUsers {
    @SerializedName("login")
    private String login;

    @SerializedName("followers")
    private String followers;

    @SerializedName("following")
    private String following;

    @SerializedName("updated_at")
    private String lastdate;

    @SerializedName("created_at")
    private String madedate;

    @SerializedName("avatar_url")
    private String avatar;


    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public GitHubUsers(String login, String followers, String following, String lastdate, String madedate, String avatar) {
        this.login = login;
        this.followers = followers;
        this.following = following;
        this.lastdate = lastdate;
        this.madedate = madedate;
        this.avatar=avatar;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public void setLastdate(String lastdate) {
        this.lastdate = lastdate;
    }

    public void setMadedate(String madedate) {
        this.madedate = madedate;
    }

    public String getLogin() {
        return login;
    }

    public String getFollowers() {
        return followers;
    }

    public String getFollowing() {
        return following;
    }

    public String getLastdate() {
        return lastdate;
    }

    public String getMadedate() {
        return madedate;
    }
}
