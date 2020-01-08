package com.example.blogrest.Controllers;

import com.example.blogrest.Mocks.BlogMockedData;
import com.example.blogrest.Models.Blog;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("mock")
public class MockBlogController {
    BlogMockedData blogMockedData = BlogMockedData.getInstance();

    @GetMapping("/blog")
    public List<Blog> get() {
        return blogMockedData.fetchBlogs();
    }

    @GetMapping("/blog/{id}")
    public Blog getById(@PathVariable String id) {
        int blogId = Integer.parseInt(id);

        return blogMockedData.getBlogById(blogId);
    }

    @PostMapping("/blog/search")
    public List<Blog> search(@RequestBody Map<String, String> body) {
        String searchTerm = body.get("text");

        return blogMockedData.searchBlogs(searchTerm);
    }

    @PostMapping("/blog")
    public Blog create(@RequestBody Map<String, String> body) {
        int id = Integer.parseInt(body.get("id"));
        String title = body.get("title");
        String content = body.get("content");

        return blogMockedData.createBlog(id, title, content);
    }

    @PutMapping("/blog/{id}")
    public Blog update(@PathVariable String id, @RequestBody Map<String, String> body) {
        int blogId = Integer.parseInt(id);
        String title = body.get("title");
        String content = body.get("content");

        return blogMockedData.updateBlog(blogId, title, content);
    }

    @DeleteMapping("/blog/{id}")
    public boolean delete(@PathVariable String id) {
        int blogId = Integer.parseInt(id);

        return blogMockedData.delete(blogId);
    }
}
