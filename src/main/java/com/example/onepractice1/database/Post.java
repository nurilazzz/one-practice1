package com.example.onepractice1.database;

import com.example.onepractice1.models.enumuration.PostStatus;
import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Post {
    private static int nextId = 0;
    private int id;
    private String description;
    private PostStatus status;
    private Client receiver;

    public Post() {
        id = nextId++;
        status = PostStatus.SENT;
    }

    public Post(String description, PostStatus status, Client receiver) {
        this.description = description;
        this.status = status;
        this.receiver = receiver;
    }

    public static PostBuilder postBuilder() {
        return new Post().new PostBuilder();
    }

    public class PostBuilder {
        private PostBuilder() {
        }

        public PostBuilder description(String description) {
            Post.this.description = description;
            return this;
        }

        public PostBuilder status(PostStatus status) {
            Post.this.status = status;
            return this;
        }

        public PostBuilder receiver(Client receiver) {
            Post.this.receiver = receiver;
            return this;
        }

        public Post build() {
            return Post.this;
        }
    }


    public static List<Post> getPosts() {
        Post post1 = Post.postBuilder()
                .description("Post is in very good condition")
                .status(PostStatus.SENT)
                .receiver(Client.getClients().get(0))
                .build();

        Post post2 = Post.postBuilder()
                .description("Post is in very good condition")
                .status(PostStatus.ON_THE_WAY)
                .receiver(Client.getClients().get(1))
                .build();

        Post post3 = Post.postBuilder()
                .description("Post is in very good condition")
                .status(PostStatus.DELIVERED)
                .receiver(Client.getClients().get(1))
                .build();

        return Arrays.asList(post1, post2, post3);
    }

    public static boolean savePost(Post post) {
        return getPosts().add(post);
    }


    public static Post getPostById(int id) {
        for (Post post : getPosts()) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null;
    }

    public static void deletePostById(int id) {
        Post.getPosts().removeIf(post -> post.getId() == id);
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Post.nextId = nextId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PostStatus getStatus() {
        return status;
    }

    public void setStatus(PostStatus status) {
        this.status = status;
    }

    public Client getReceiver() {
        return receiver;
    }

    public void setReceiver(Client receiver) {
        this.receiver = receiver;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", receiver=" + receiver +
                '}';
    }
}
