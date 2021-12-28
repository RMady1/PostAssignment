package com.posts.postsManagement.service;

import com.posts.postsManagement.data.models.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public interface UserService {

     /**
     * search for user with certain user name
     * @param username
     * @return USer
     */
     User getUserByUserName(String username);

    /**
     * search for user with certain token
     * @param token
     * @return
     */
     User getUserByToken(String token);

     void addUser(User user);

     String authenticateUser(String username, String password);

     User getCurrentUser(HttpServletRequest request);

}
