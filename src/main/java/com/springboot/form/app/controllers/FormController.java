package com.springboot.form.app.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.springboot.form.app.editors.CapitalizeTextEditor;
import com.springboot.form.app.editors.CountryPropertyEditor;
import com.springboot.form.app.editors.RolePropertyEditor;
import com.springboot.form.app.models.Country;
import com.springboot.form.app.models.Role;
import com.springboot.form.app.models.User;
import com.springboot.form.app.services.ICountryService;
import com.springboot.form.app.services.IRoleService;
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

  @Autowired
  private CapitalizeTextEditor capitalizeTextEditor;
  
  @Autowired
  private CountryPropertyEditor countryPropertyEditor;

  @Autowired
  private RolePropertyEditor rolePropertyEditor;
  
  @Autowired
  private ICountryService<Country> countryService;

  @Autowired
  private IRoleService<Role> roleService;

  @InitBinder
  public void initBinder(WebDataBinder binder) {
    // agrega un nuevo validador al stack de validadores que hay
    // tambien hay un metodo setValidaror, pero ese reemplaza
    // el validador por defecto y solo agrega el validador personalizado
    binder.addValidators(userValidator);

    SimpleDateFormat dateFormater = new SimpleDateFormat("yyy-MM-dd");
    // no debe ser indulgente, debe ser estricto en la conversion
    dateFormater.setLenient(false);
    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormater, false));
    // Especifica el campo especifico en el se utilizará este editor
//    binder.registerCustomEditor(Date.class, "birthdayDate", new CustomDateEditor(dateFormater, false));

    binder.registerCustomEditor(String.class, "name", capitalizeTextEditor);
    binder.registerCustomEditor(String.class, "surname", capitalizeTextEditor);

    // registrando Pais en el objeto User
    binder.registerCustomEditor(Country.class, "country", countryPropertyEditor);
    
    binder.registerCustomEditor(Role.class, "roles", rolePropertyEditor);
  }
  
  @ModelAttribute("roles")
  public List<Role> getRolles() {
    return roleService.getList();
  }

  @ModelAttribute("countries")
  public List<Country> getCountries() {
    return countryService.getList();
  }

  @GetMapping("/form")
  public String showForm(Model model) {
    model.addAttribute("title", "Create new User");
    User user = new User();
    user.setId("15.570.392-k");
    user.setName("Peter");
    user.setSurname("Parker");
    user.setActive(true);
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
