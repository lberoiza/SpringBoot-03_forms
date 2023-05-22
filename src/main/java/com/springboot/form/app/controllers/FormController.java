package com.springboot.form.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.springboot.form.app.models.User;
import com.springboot.form.app.validations.UserValidator;

import jakarta.validation.Valid;

@Controller
//la anotacion @SessionAttributes mapea un objeto (en este caso user)
//para que esté disponible entre requests.
//de esta manera no se pierden los datos (id) del user.
@SessionAttributes("user")
public class FormController {

  @Autowired
  private UserValidator userValidator;

  @InitBinder
  public void initBinder(WebDataBinder binder) {
    // agrega un nuevo validador al stack de validadores que hay
    // tambien hay un metodo setValidaror, pero ese reemplaza
    // el validador por defecto y solo agrega el validador personalizado
    binder.addValidators(userValidator);
  }

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
  public String processForm(@Valid User user, BindingResult result, Model model, SessionStatus status) {
    model.addAttribute("title", "User creation");

    if (result.hasErrors())
      return "form/show_form";

    model.addAttribute("user", user);
    status.setComplete();
    return "form/show_result";

  }

}
