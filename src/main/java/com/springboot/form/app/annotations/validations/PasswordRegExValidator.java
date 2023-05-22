package com.springboot.form.app.annotations.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordRegExValidator implements ConstraintValidator<PasswordRegEx, String> {

  @Override
  public boolean isValid(String password, ConstraintValidatorContext context) {
    return password.matches("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[&\\-#<>_.]).{5,10}$");
  }

}
