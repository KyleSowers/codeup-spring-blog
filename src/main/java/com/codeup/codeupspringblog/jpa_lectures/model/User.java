package com.codeup.codeupspringblog.jpa_lectures.model;

import jakarta.persistence.*;

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

    @Column(nullable = false, length = 100)
    private String user_email;

    @Column(nullable = false, length = 50)
    private String user_password;


    //CONSTRUCTORS
    ///
    ////

    public User() {
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
}
