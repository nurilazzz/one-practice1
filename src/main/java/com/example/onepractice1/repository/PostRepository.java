package com.example.onepractice1.repository;

import com.example.onepractice1.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
}
