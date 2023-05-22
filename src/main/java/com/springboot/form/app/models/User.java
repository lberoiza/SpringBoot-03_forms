package com.springboot.form.app.models;

import com.springboot.form.app.annotations.validations.PasswordRegEx;
import com.springboot.form.app.annotations.validations.RequiredField;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

// Al Poner la clase User como primer argumento del metodo "processForm"
// puede mapear los datos del formulario a los campos de la clase
// porque la clase tiene los mismo nombres de variables que los name
// del formulario.
public class User {

// Identificador de usuario, no debe ser modificado
// debe persistir si se cambian datos en el formulario
  private String id;

  @RequiredField
  @Size(min = 2, max = 15)
  private String name;

  @RequiredField
  @Size(min = 2, max = 15)
  private String surname;

  @RequiredField
  private String username;

  @NotBlank
  // Anotacion personalizada para validar password
  @PasswordRegEx
  private String password;

  @RequiredField
  @Email
  private String email;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String nombre) {
    this.name = nombre;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String apellido) {
    this.surname = apellido;
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
