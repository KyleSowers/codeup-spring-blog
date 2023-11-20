package com.codeup.codeupspringblog.jpa_lectures.controller;

import com.codeup.codeupspringblog.jpa_lectures.repositories.FoodRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FoodController {

    private final FoodRepository foodDataAccessObject;

    public FoodController(FoodRepository foodDataAccessObject) { this.foodDataAccessObject = foodDataAccessObject; }


    @GetMapping("/lunchTime")
    public String whatsForLunch(Model model) {

        model.addAttribute("lunchItems", foodDataAccessObject.findAll());

        return "posts/lunch";
    }
}
