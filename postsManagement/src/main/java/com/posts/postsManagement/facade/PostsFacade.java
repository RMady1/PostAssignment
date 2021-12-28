package com.posts.postsManagement.facade;

import com.posts.postsManagement.data.models.Post;
import com.posts.postsManagement.data.models.PostStatus;
import com.posts.postsManagement.data.models.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PostsFacade {
    /** create new post in the database
     *
     * @param content the content which entered by the user
     * @param status the status which entered by the user
     * @return true if everything is ok otherwise false
     */
    Post createPost(User currentUser, String content, PostStatus status);

    /**
     * filter all the public posts which contain the search text in their content filed
     * @param searchText can be multi-words i.e “Java developer”. Matched posts should
     * contain all the search words in any order AND search should be case
     * insensitive.
     * @return list of matched public posts, either created by the logged
     * in user or other users.
     */
    List<Post> searchPublicPostsForCertainWords(String searchText);
}
