package ru.netology.repository;

import ru.netology.model.Post;

import java.util.*;

// Stub
public class PostRepository {
    Map<Long, Post> posts;

    public PostRepository() {
        posts = new HashMap<>();
    }

    public List<Post> all() {
        return List.of(posts.values().toArray(new Post[0]));
    }

    public Optional<Post> getById(long id) {
        if (posts.containsKey(id)) {
            return Optional.of(posts.get(id));
        } else {
            return Optional.of(new Post(id, "not found"));
        }
    }

    public Post save(Post post) {
        post.setId(posts.size() + 1);
        posts.put((long) (posts.size() + 1), post);
        return post;
    }

    public void removeById(long id) {
        posts.remove(id);
    }
}
