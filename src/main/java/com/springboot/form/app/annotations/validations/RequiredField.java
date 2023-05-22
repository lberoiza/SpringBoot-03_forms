package com.springboot.form.app.annotations.validations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RUNTIME)
@Target({ FIELD, METHOD })
@Constraint(validatedBy = RequiredFieldValidator.class)
public @interface RequiredField {
  String message() default "This field is required";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
