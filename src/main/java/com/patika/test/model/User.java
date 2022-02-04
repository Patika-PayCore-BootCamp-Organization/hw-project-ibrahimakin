package com.patika.test.model;

public class User {
    String fullname;
    String username;
    String email;
    String created;

    public User(String fullname, String username, String email, String created) {
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.created = created;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
