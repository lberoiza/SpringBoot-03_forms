package com.springboot.form.app.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

// Al Poner la clase User como primer argumento del metodo "processForm"
// puede mapear los datos del formulario a los campos de la clase
// porque la clase tiene los mismo nombres de variables que los name
// del formulario.
public class User {

  @NotEmpty
  private String username;

  @NotEmpty
  private String password;

  @NotEmpty
  @Email
  private String email;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}
