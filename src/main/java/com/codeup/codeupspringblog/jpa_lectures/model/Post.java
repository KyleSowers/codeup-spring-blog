package com.codeup.codeupspringblog.jpa_lectures.model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(length = 750)
    private String body;


    //CONSTRUCTORS
    ///
    ////
    public Post(){
    }

    public Post(long id, String title, String body) {
       this.id = id;
        this.title = title;
        this.body = body;
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }


    //GETTERS/SETTERS
    ///
    ////

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Post(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
