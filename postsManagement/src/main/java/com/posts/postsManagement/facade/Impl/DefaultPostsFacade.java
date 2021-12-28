package com.posts.postsManagement.facade.Impl;

import com.posts.postsManagement.data.models.Post;
import com.posts.postsManagement.data.models.PostStatus;
import com.posts.postsManagement.data.models.User;
import com.posts.postsManagement.facade.PostsFacade;
import com.posts.postsManagement.service.PostService;
import com.posts.postsManagement.service.UserService;
import com.posts.postsManagement.utils.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultPostsFacade implements PostsFacade {

    @Autowired
    PostService postService;


    @Override
    public Post createPost(User currentUser, String content, PostStatus status) {
        return postService.createPost(currentUser, content,status);
    }

    @Override
    public List<Post> searchPublicPostsForCertainWords(String searchText) {
        return postService.searchPublicPostsForCertainWords(searchText);
    }
}
