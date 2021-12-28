package com.posts.postsManagement.web;

import com.posts.postsManagement.data.models.Post;
import com.posts.postsManagement.data.models.PostStatus;
import com.posts.postsManagement.data.models.User;
import com.posts.postsManagement.facade.PostsFacade;
import com.posts.postsManagement.facade.UsersFacade;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/posts")
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "This is a bad request, please follow the API documentation for the proper request format"),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Due to security constraints, your access request cannot be authorized"),
        @io.swagger.annotations.ApiResponse(code = 500, message = "The server is down. Please bear with us."),
})
public class PostsController {


    @Autowired
    PostsFacade postsFacade;

    @Autowired
    UsersFacade usersFacade;


    @RequestMapping(value = "/addPost", method = POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Post> addPost(@RequestBody String post,  HttpServletRequest httpRequest) {
        if (StringUtils.hasText(post)) {
            User currentUser = usersFacade.getCurrentUser(httpRequest);
            if (currentUser != null) {
                Post createdPost =  postsFacade.createPost(currentUser, post, PostStatus.PRIVATE);
                return new ResponseEntity<>(createdPost, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/search")
    public ResponseEntity<List<Post>> getAllMatchedPosts(@RequestParam String searchText, HttpServletRequest httpRequest) {
        if (StringUtils.hasText(searchText.trim())) {
            User currentUser = usersFacade.getCurrentUser(httpRequest);
            if (currentUser != null) {
                List<Post> posts = postsFacade.searchPublicPostsForCertainWords(searchText);
                return new ResponseEntity<>(posts, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
