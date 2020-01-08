package com.example.blogrest.Repositories;

import com.example.blogrest.Models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    // Custom query to search blog posts by title or content
    List<Blog> findByTitleContainingOrContentContaining(String text, String textAgain);
}
