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
@Constraint(validatedBy = PasswordRegExValidator.class)
public @interface PasswordRegEx {
  String message() default "Password Invalid. Size (5-10), 1 Uppercase, 1 Number and 1 Special Symbol (&-#<>_.)";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
