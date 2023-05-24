package com.springboot.form.app.models;

import java.util.Date;
import java.util.List;

//import org.springframework.format.annotation.DateTimeFormat;

import com.springboot.form.app.annotations.validations.PasswordRegEx;
import com.springboot.form.app.annotations.validations.RequiredField;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
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

  // NotNull es solo para Tipos de Objetos
  // Integer es un objeto
  @NotNull
  @Min(1)
  @Max(9999)
  private Integer count;

  @NotNull
  @Past
  // este formato es enviado por el Datepicker de HTML5
//  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date birthdayDate;

  @NotNull
  private Country country;

  @NotEmpty
  private List<Role> roles;

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

  public Country getCountry() {
    return country;
  }

  public void setCountry(Country country) {
    this.country = country;
  }

  public Date getBirthdayDate() {
    return birthdayDate;
  }

  public void setBirthdayDate(Date birthdayDate) {
    this.birthdayDate = birthdayDate;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

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
