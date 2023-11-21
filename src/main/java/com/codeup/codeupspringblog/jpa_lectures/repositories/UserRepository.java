package com.codeup.codeupspringblog.jpa_lectures.repositories;

import com.codeup.codeupspringblog.jpa_lectures.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {

    User getUserById(long l);
}
