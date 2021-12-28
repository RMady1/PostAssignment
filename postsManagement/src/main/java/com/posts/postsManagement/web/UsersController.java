package com.posts.postsManagement.web;

import com.posts.postsManagement.facade.UsersFacade;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/users")
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "This is a bad request, please follow the API documentation for the proper request format"),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Due to security constraints, your access request cannot be authorized"),
        @io.swagger.annotations.ApiResponse(code = 500, message = "The server is down. Please bear with us."),
})
public class UsersController {


    @Autowired
    private UsersFacade usersFacade;

    @RequestMapping(value = "/addUSer", method = POST)
    public String addUser(@RequestParam String username, @RequestParam String password,@RequestParam String fullUserName) {
         usersFacade.addUser(username,password,fullUserName);
         return username;
    }


    @RequestMapping(value = "/loginUser", method = POST)
    public String loginUser(@RequestParam String username, @RequestParam String password) {
        return usersFacade.startLoginProcess(username,password);
    }
}
