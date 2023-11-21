package com.codeup.codeupspringblog.jpa_lectures.repositories;

import com.codeup.codeupspringblog.jpa_lectures.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

    Post getPostById(int id);

}
