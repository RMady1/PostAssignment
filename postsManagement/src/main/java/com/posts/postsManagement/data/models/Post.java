package com.posts.postsManagement.data.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(indexes =  @Index(columnList = "content"))
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer PK;


    private String content;

    private LocalDateTime created_at;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="uid")
    private User post_creator_id;

    @Enumerated(EnumType.STRING)
    private PostStatus postStatus;

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public void setPost_creator_id(User post_creator_id) {
        this.post_creator_id = post_creator_id;
    }

    public void setPostStatus(PostStatus postStatus) {
        this.postStatus = postStatus;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public User getPost_creator_id() {
        return post_creator_id;
    }

    public PostStatus getPostStatus() {
        return postStatus;
    }
    public void setPK(Integer PK) {
        this.PK = PK;
    }

    public Integer getPK() {
        return PK;
    }

}
