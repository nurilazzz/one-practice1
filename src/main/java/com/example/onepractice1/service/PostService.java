package com.example.onepractice1.service;


import com.example.onepractice1.models.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();

    Post getPostById(Long id);

    Post savePost(Post post);

}
