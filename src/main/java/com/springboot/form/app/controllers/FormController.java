package com.springboot.form.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.form.app.models.User;

@Controller
public class FormController {

  @GetMapping("/form")
  public String showForm(Model model) {
    model.addAttribute("title", "Create new User");
    return "form/show_form";

  }

  @PostMapping("/form")
  public String processForm(User user, Model model) {
    model.addAttribute("title", "User creation successful");
    model.addAttribute("user", user);
    return "form/show_result";

  }

}
