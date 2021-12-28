package com.posts.postsManagement.service.Impl;

import com.posts.postsManagement.data.models.User;
import com.posts.postsManagement.data.repository.UserRepository;
import com.posts.postsManagement.service.UserService;
import com.posts.postsManagement.utils.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TokenGenerator tokenGenerator;

    @Override
    public User getUserByUserName(String username) {
        if (!StringUtils.hasText(username)) {
            System.out.println("Username is mandatory");
        }
        return userRepository.getUserByUserName(username);
    }

    @Override
    public User getUserByToken(String token) {
        if (!StringUtils.hasText(token)) {
            System.out.println("token is mandatory");
        }
        return userRepository.getUserByToken(token);
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public String authenticateUser(String username, String password) {
        String token = null;
        if (StringUtils.hasText(username) && StringUtils.hasText(password)) {
            User user = userRepository.getUserByUserName(username);
            if (password.equals(user.getPassword())) {
                token = tokenGenerator.generateToken();
                user.setToken(token);
                userRepository.saveAndFlush(user);
            }
        }
        return token;
    }

    public User getCurrentUser(HttpServletRequest request) {
        String token = tokenGenerator.extractHeaderToken(request);
        if ( token != null) {
            User user = userRepository.getUserByToken(token);
            if (user != null) {
                return user;
            }
        }
       return null;
    }

}
