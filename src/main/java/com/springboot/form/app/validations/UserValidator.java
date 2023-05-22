package com.springboot.form.app.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.springboot.form.app.models.User;

@Component
public class UserValidator implements Validator {

  @Override
  public boolean supports(Class<?> clazz) {
    // verifica que Clazz puede ser asignada a User
    // es decir, si es un hijo de esta clase (User)
    return User.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    User user = (User) target;

    // validaremos que el nombre de usuario no esté en blanco
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty.user.username");
    if(!user.getUsername().matches("^[a-z0-9]{5,12}$")) {
      errors.rejectValue("username", "NotCorrect.user.username");
    }

//    // valida que el nombre de usuario no esté en blanco
//    if (user.getUsername().isBlank()) {
//      errors.rejectValue("username", "NotEmpty.user.username");
//    }
  }

}
