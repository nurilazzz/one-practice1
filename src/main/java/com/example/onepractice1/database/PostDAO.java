package com.example.onepractice1.database;

import com.example.onepractice1.models.Post;

import java.util.List;

public interface PostDAO {
    List<Post> getPosts();
    void savePost(Post post);
    Post getPostById(Long id);
    boolean deletePostById(Long id);
}
