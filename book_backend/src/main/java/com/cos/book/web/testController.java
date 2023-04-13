package com.cos.book.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class testController {

    @GetMapping("/test")
    public String main(Model model) {
        model.addAttribute("data", "hello rozy~!");
        return "index";
    }

}

