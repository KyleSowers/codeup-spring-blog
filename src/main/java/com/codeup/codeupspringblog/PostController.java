package com.codeup.codeupspringblog;

import com.codeup.codeupspringblog.jpa_lectures.model.Post;
import com.codeup.codeupspringblog.jpa_lectures.model.User;
import com.codeup.codeupspringblog.jpa_lectures.repositories.PostRepository;
import com.codeup.codeupspringblog.jpa_lectures.repositories.UserRepository;
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

    //INJECTION CONSTRUCTOR
    public PostController(PostRepository postDataAccessObject, UserRepository userDataAccessObject) {
        this.postDataAccessObject = postDataAccessObject;
        this.userDataAccessObject = userDataAccessObject;
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

    public String viewCreatePost() {
        return "posts/create";
    }

    @RequestMapping(path = "/post/create", method = RequestMethod.POST)
    public String createPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body, Model model) {

        User user = userDataAccessObject.getUserById(1L);
        Post post = new Post(title, body);
        post.setUser(user);

        postDataAccessObject.save(post);

        return "redirect:/post";
    }


}
