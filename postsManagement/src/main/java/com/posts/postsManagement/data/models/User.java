package com.posts.postsManagement.data.models;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(indexes =  @Index(columnList = "username, token"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer PK;

    @Column(unique = true)
    private String username;

    private String password;

    private String full_name;

    private LocalDateTime created_at;

    private String token;

    public void setPK(Integer PK) {
        this.PK = PK;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public Integer getPK() {
        return PK;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFull_name() {
        return full_name;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }






}
