package ru.netology.repository;

import org.springframework.stereotype.Repository;
import ru.netology.model.Post;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Repository
public class PostRepository {
    ConcurrentMap<Long, Post> posts;

    public PostRepository() {
        posts = new ConcurrentHashMap<>();
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

    public synchronized Post save(Post post) {
        post.setId(posts.size() + 1);
        posts.put((long) (posts.size() + 1), post);
        return post;
    }

    public void removeById(long id) {
        posts.remove(id);
    }
}
