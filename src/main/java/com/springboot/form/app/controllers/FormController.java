package com.springboot.form.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

  @GetMapping("/form")
  public String showForm(Model model) {
    model.addAttribute("title", "Create new User");
    return "form/show_form";

  }

  @PostMapping("/form")
  public String processForm(Model model, @RequestParam String username, @RequestParam String password,
      @RequestParam String email) {
    model.addAttribute("title", "User creation successful");
    model.addAttribute("username", username);
    model.addAttribute("password", password);
    model.addAttribute("email", email);
    return "form/show_result";

  }

}
