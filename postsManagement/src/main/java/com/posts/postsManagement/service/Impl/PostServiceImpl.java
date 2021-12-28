package com.posts.postsManagement.service.Impl;

import com.posts.postsManagement.data.models.Post;
import com.posts.postsManagement.data.models.PostStatus;
import com.posts.postsManagement.data.models.User;
import com.posts.postsManagement.data.repository.PostRepository;
import com.posts.postsManagement.facade.UsersFacade;
import com.posts.postsManagement.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    UsersFacade usersFacade;


    @Override
    public Post createPost(User user, String content, PostStatus status) {
        Post post = new Post();
        post.setContent(content);
        post.setPostStatus(status);
        post.setCreated_at(LocalDateTime.now());
        post.setPost_creator_id(user);
        postRepository.save(post);
        return post;
    }

    @Override
    public List<Post> searchPublicPostsForCertainWords(String searchText) {

        return postRepository.findAll(forWords(searchText));
    }

    private Specification<Post> forWords(String searchText) {
        if(!StringUtils.hasText(searchText)) {
            throw new RuntimeException("Search Text cannot be empty.");
        }
        String wordsArray  [] ;
        if (StringUtils.containsWhitespace(searchText)) {
            wordsArray = StringUtils.split(searchText, " ");
        } else {
            wordsArray = new String [] {searchText};
        }
        return (root, query, builder) ->  Arrays.stream(wordsArray)
                .map(String::toLowerCase)
                .map(word -> "%" + word + "%")
                .map(word -> builder.like(builder.lower(root.get("content")), word))
                .reduce(builder::or)
                .get();
    }
}
