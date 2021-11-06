package com.example.onepractice1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    @Column(name = "post_name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "post_status")
    private String postStatus;

}
