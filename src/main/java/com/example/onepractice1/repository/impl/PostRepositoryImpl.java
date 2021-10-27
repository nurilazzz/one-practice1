package com.example.onepractice1.repository.impl;

import com.example.onepractice1.database.PostDAO;
import com.example.onepractice1.database.impl.JdbcPostDAO;
import com.example.onepractice1.models.Post;
import com.example.onepractice1.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepository {
    private JdbcPostDAO jdbcPostDAO;

    @Autowired
    public PostRepositoryImpl(JdbcPostDAO jdbcPostDAO) {
        this.jdbcPostDAO = jdbcPostDAO;
    }

    @Override
    public List<Post> findAll() {
        return jdbcPostDAO.getPosts();
    }

    @Override
    public Post findPostById(Long id) {
        return jdbcPostDAO.getPostById(id);
    }

    @Override
    public void savePost(Post post) {
        jdbcPostDAO.savePost(post);
    }

    @Override
    public boolean deletePostById(Long id) {
        return jdbcPostDAO.deletePostById(id);
    }
}
