package com.posts.postsManagement.facade;

import com.posts.postsManagement.data.models.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;



@Component
public interface UsersFacade {

    String startLoginProcess(final String username, final String password);

    /**
     * search for user with certain user name
     * @param username
     * @return
     */
    User getUserByUserName(String username);

    User getUserByToken(String token);

    void addUser(final String username, final String password, final String fullName);

    User getCurrentUser(HttpServletRequest httpRequest);

}
