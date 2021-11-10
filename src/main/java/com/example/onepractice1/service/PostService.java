package com.example.onepractice1.service;


import com.example.onepractice1.models.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> getAllPosts();

    Post getPostById(Long id);

    Post savePost(Post post);

    void deletePostById(Long id);
}
