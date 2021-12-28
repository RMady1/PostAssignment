package com.posts.postsManagement;

import com.posts.postsManagement.data.models.User;
import com.posts.postsManagement.facade.UsersFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class PostsManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostsManagementApplication.class, args);
	}

}
