package com.codeup.codeupspringblog;

import com.codeup.codeupspringblog.jpa_lectures.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDataAccessObject;

    public PostController(PostRepository postDataAccessObject) { this.postDataAccessObject = postDataAccessObject; }

//    @RequestMapping(path = "/post", method = RequestMethod.GET)
//    @ResponseBody
//    public String post() {
//        return "Posts index page";
//    }
    @GetMapping("/post")
    public String post(Model model) {
        model.addAttribute("postsList", postDataAccessObject.findAll());
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
        Post post = postDataAccessObject.getPostById(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @RequestMapping(path = "/post/create", method = RequestMethod.GET)

    public String viewCreatePost() {
        return "posts/create";
    }

    @RequestMapping(path = "/post/create", method = RequestMethod.POST)
    public String createPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body, Model model) {

    Post post = new Post(title, body);

        postDataAccessObject.save(post);

        return "redirect:/post";
    }


}
