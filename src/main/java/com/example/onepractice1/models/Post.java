package com.example.onepractice1.models;

import com.example.onepractice1.models.enumuration.PostStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "post_status")
    private String postStatus;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client clientId;
}
