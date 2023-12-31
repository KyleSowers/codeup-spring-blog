package com.codeup.codeupspringblog.jpa_lectures.controller;

import com.codeup.codeupspringblog.EmailService;
import com.codeup.codeupspringblog.jpa_lectures.model.Post;
import com.codeup.codeupspringblog.jpa_lectures.model.User;
import com.codeup.codeupspringblog.jpa_lectures.repositories.PostRepository;
import com.codeup.codeupspringblog.jpa_lectures.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PostController {

    //DEPENDENCY INJECTOR
    ///
    ////
    private final UserRepository userDataAccessObject;

    private final PostRepository postDataAccessObject;

    private EmailService emailService;

    //INJECTION CONSTRUCTOR
    public PostController(PostRepository postDataAccessObject, UserRepository userDataAccessObject, EmailService emailService) {
        this.postDataAccessObject = postDataAccessObject;
        this.userDataAccessObject = userDataAccessObject;
        this.emailService = emailService;
    }
    //END OF DEPENDENCY INJECTOR


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

//    public String viewCreatePost() {
//        return "posts/create";

    public String viewCreatePost(Model model) {
            model.addAttribute("post", new Post());
            return "posts/create";
    }

    @RequestMapping(path = "/post/create", method = RequestMethod.POST)
//    public String createPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body, Model model) {
//
//        User user = userDataAccessObject.getUserById(1L);
//        Post post = new Post(title, body);
//        post.setUser(user);
//
//        postDataAccessObject.save(post);
//
//        return "redirect:/post";

    public String createPost(@ModelAttribute Post post) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();


        User user = userDataAccessObject.getReferenceById(loggedInUser.getId());
        post.setUser(user);
        postDataAccessObject.save(post);

        emailService.prepareAndSend(post, "Post Created", "Hello, your post has been created!");

        return "redirect:/post";
    }

    @RequestMapping(path = "/post/{id}/edit", method = RequestMethod.GET)
    public String getEditPost(@PathVariable int id, Model model) {
        Post post = postDataAccessObject.getPostById(id);
        model.addAttribute("post", post);

        return "posts/edit";
    }

    @RequestMapping(path = "/post/{id}/edit", method = RequestMethod.POST)
    public String editPost(@ModelAttribute Post post) {
        postDataAccessObject.save(post);
        return "redirect:/post";
    }


}
