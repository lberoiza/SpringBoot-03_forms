package com.springboot.form.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.form.app.models.User;

import jakarta.validation.Valid;

@Controller
public class FormController {

  @GetMapping("/form")
  public String showForm(Model model) {
    model.addAttribute("title", "Create new User");
    User user = new User();
    user.setId("15.570.392-k");
    user.setName("Peter");
    user.setSurname("Parker");
    model.addAttribute("user", user);
    return "form/show_form";

  }

//  Con la anotacion @Valid (Spring Boot 2 desde javax y en Spring Boot 3 desde jakarta)
//  se pueden agregar Validaciones a los campos.
//  Las validaciones fueron definidas en la clase User.
//
//  El Objeto BindingResult contiene las validaciones del objeto anterior.
//  debe ser inyectado como segundo argumento del metodo, al lado del objeto con la anotacion
//  @Valid.
  @PostMapping("/form")
  public String processForm(@Valid User user,BindingResult result, Model model) {
    if (result.hasErrors())  return "form/show_form";

    model.addAttribute("title", "User creation successful");
    model.addAttribute("user", user);
    return "form/show_result";

  }

}
