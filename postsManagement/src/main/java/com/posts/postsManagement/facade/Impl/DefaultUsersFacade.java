package com.posts.postsManagement.facade.Impl;

import com.posts.postsManagement.data.models.User;
import com.posts.postsManagement.facade.UsersFacade;
import com.posts.postsManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Component
public class DefaultUsersFacade implements UsersFacade {

    @Autowired
    UserService userService;

    @Override
    public String startLoginProcess(String username, String password) {
        String token = userService.authenticateUser(username,password);

        return token;
    }

    @Override
    public User getUserByUserName(String username) {
        return userService.getUserByUserName(username);
    }

    @Override
    public User getUserByToken(String token) {
        return userService.getUserByToken(token);
    }

    @Override
    public void addUser(final String username, final String password, final String fullName){
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        user.setFull_name(fullName);
        user.setCreated_at(LocalDateTime.now());
        userService.addUser(user);
    }
    public User getCurrentUser(HttpServletRequest httpRequest) {

       return  userService.getCurrentUser(httpRequest);
    }

}
