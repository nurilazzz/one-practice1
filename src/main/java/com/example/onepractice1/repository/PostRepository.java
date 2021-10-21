package com.example.onepractice1.repository;

import com.example.onepractice1.database.Post;

import java.util.List;

public interface PostRepository {
    List<Post> findAll();
    Post findPostById(int id);
    boolean savePost(Post post);
    void deletePostById(int id);
}
