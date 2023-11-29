package com.codeup.codeupspringblog.jpa_lectures.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String diceSelector() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public  String diceResult(@PathVariable int n, Model model) {
        int result = (int) (Math.floor(Math.random() * 6) + 1);
        if (result == n) {
            String correctGuess = "You guessed " + n + " correctly!";
            model.addAttribute("message", correctGuess);
        } else {
            String incorrectGuess = "You guessed incorrectly, as " + result + " was the correct dice roll";
            model.addAttribute("message", incorrectGuess);
        }
        return "diceResult";
    }
}


