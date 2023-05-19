package com.springboot.form.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {

  @GetMapping("/form") 
  public String showForm(Model model){
    return "form/show_form";
    
  }

  
  @PostMapping("/form") 
  public String processForm(Model model){
    return "form/show_result";
    
  }


}
