package com.example.onepractice1.repository.impl;

import com.example.onepractice1.database.Post;
import com.example.onepractice1.repository.PostRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepository {
    @Override
    public List<Post> findAll() {
        return Post.getPosts();
    }

    @Override
    public Post findPostById(int id) {
        return Post.getPostById(id);
    }

    @Override
    public boolean savePost(Post post) {
        return Post.savePost(post);
    }

    @Override
    public void deletePostById(int id) {
        Post.deletePostById(id);
    }
}
