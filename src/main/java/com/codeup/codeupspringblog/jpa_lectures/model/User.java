package com.codeup.codeupspringblog.jpa_lectures.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //FIELDS
    ///
    ////
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 30)
    private String user_name;

    @Column(unique = true)
    private String user_email;

    @Column(nullable = false, length = 50)
    private String user_password;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts;


    //CONSTRUCTORS
    ///
    ////

    public User() {
    }

    public User(User copy){
        id = copy.id;
        user_email = copy.user_email;
        user_name = copy.user_name;
        user_password = copy.user_password;
    }


    public User(Long id, String user_name, String user_email, String user_password, List<Post> posts) {
        this.id = id;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_password = user_password;
        this.posts = posts;
    }

    public User(String user_name, String user_email, String user_password, List<Post> posts) {
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_password = user_password;
        this.posts = posts;
    }

    public User(Long id, String user_name, String user_email, String user_password) {
        this.id = id;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_password = user_password;
    }

    public User(String user_name, String user_email, String user_password) {
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_password = user_password;
    }

    //GETTERS/SETTERS
    ///
    ////
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void setPassword(String hash) {
    }
}
