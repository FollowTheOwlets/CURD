package ru.netology.repository;

import ru.netology.model.Post;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

public class PostRepository {
    private ConcurrentMap<Long, Post> posts;
    private AtomicLong nextId;

    public PostRepository() {
        posts = new ConcurrentHashMap<>();
        nextId = new AtomicLong(0L);
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
        long id = nextId.incrementAndGet();
        post.setId(id);
        posts.put(id, post);
        return post;
    }

    public void removeById(long id) {
        posts.remove(id);
    }
}
