package com.example.onepractice1.database;

import com.example.onepractice1.models.enumuration.PostStatus;

import java.util.ArrayList;
import java.util.List;

public class PostDB {
    private static PostDB postDB;
    private static List<Post> postList = new ArrayList<>();

    private PostDB() {
    }

    static {
        postList.add(new Post("Description is very good", PostStatus.SENT, ClientDB.getClientById(0)));
        postList.add(new Post("Description is very good", PostStatus.ON_THE_WAY, ClientDB.getClientById(1)));
        postList.add(new Post("Description is very good", PostStatus.DELIVERED, ClientDB.getClientById(1)));
    }

    public static List<Post> getPosts() {
        return postList;
    }

    public static boolean savePost(Post post) {
        return postList.add(post);
    }


    public static Post getPostById(int id) {
        for (Post post : postList) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null;
    }

    public static void deletePostById(int id) {
        postList.removeIf(post -> post.getId() == id);
    }

    public static PostDB getInstance() {
        if (postDB == null) {
            postDB = new PostDB();
        }
        return postDB;
    }
}
