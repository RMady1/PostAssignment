package com.posts.postsManagement.data.repository;

import com.posts.postsManagement.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


    @Query("SELECT u FROM User u WHERE u.username = ?1")
    User getUserByUserName(String username);

    @Query("SELECT u FROM User u WHERE u.token = ?1")
    User getUserByToken(String token);


}
