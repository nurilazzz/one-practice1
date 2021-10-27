package com.example.onepractice1.database.impl;

import com.example.onepractice1.database.PostDAO;
import com.example.onepractice1.models.Client;
import com.example.onepractice1.models.Post;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class JdbcPostDAO implements PostDAO, InitializingBean {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    class PostRowMapper implements RowMapper<Post> {
        @Override
        public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
            Post post = new Post();
            post.setId(rs.getLong("id"));
            post.setDescription(rs.getString("description"));
            post.setPostStatus(rs.getString("post_status"));
            return post;
        }

    }

    @Override
    public Post getPostById(Long id) {
        String sql = "SELECT * FROM POSTS WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Post.class));
    }

    @Override
    public List<Post> getPosts() {
        String sql = "SELECT * FROM POSTS";
        return jdbcTemplate.query(sql, new PostRowMapper());
    }

    @Override
    public void savePost(Post post) {
        String sql = "INSERT INTO POSTS(id, description, post_status) values (?, ?, ?)";
        jdbcTemplate.update(sql, post.getId(), post.getDescription(), post.getPostStatus());
    }

    @Override
    public boolean deletePostById(Long id) {
        String sql = "DELETE FROM POSTS WHERE id = ?";
        return jdbcTemplate.update(sql, new Object[] {id}) == 1;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (jdbcTemplate == null) {
            throw new BeanCreationException("Bean is null");
        }
    }
}
