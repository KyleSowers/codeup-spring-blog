package com.codeup.codeupspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

//    @RequestMapping(path = "/post", method = RequestMethod.GET)
//    @ResponseBody
//    public String post() {
//        return "Posts index page";
//    }

    @GetMapping("/post")
    public String post(Model model) {
        Post post1 = new Post(1, "First Post", "This is the first post.");
        Post post2 = new Post(2, "Second Post", "This is the second post.");
        List<Post> posts = new ArrayList<>();
        posts.add(post1);
        posts.add(post2);
        model.addAttribute("posts", posts);
        return "posts/index";
    }

//    @RequestMapping(path = "/post/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public String individualPost(@PathVariable String id) {
//        return "View an individual post";
//    }

//    Part 3 of exercise
    @GetMapping("/post/{id}")
    public String postId(Model model, @PathVariable int id) {
        Post post = new Post(1, "Single Post", "This is the context of the new post.");
        model.addAttribute("post", post);
        return "posts/show";
    }

    @RequestMapping(path = "/post/create", method = RequestMethod.GET)
    @ResponseBody
    public String viewCreatePost() {
        return "View the form for creating a post";
    }

    @RequestMapping(path = "/post/create", method = RequestMethod.POST)
    @ResponseBody
    public String createPost() {
        return "Create a new post";
    }


}
