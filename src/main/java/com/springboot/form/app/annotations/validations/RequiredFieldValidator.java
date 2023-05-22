package com.springboot.form.app.annotations.validations;


import org.springframework.util.StringUtils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RequiredFieldValidator implements ConstraintValidator<RequiredField, String> {

  @Override
  public boolean isValid(String field, ConstraintValidatorContext context) {
    if(field == null || !StringUtils.hasText(field)) return false;
    return true; 
  }

}
