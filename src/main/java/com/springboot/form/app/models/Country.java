package com.springboot.form.app.models;

import java.util.Objects;

public class Country {

  private Integer id;
  private String code;
  private String name;

  public Country() {
  }

  public Country(Integer id, String code, String name) {
    this.id = id;
    this.code = code;
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Country [id=" + id + ", code=" + code + ", name=" + name + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, id, name);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Country other = (Country) obj;
    return Objects.equals(code, other.code) && Objects.equals(id, other.id) && Objects.equals(name, other.name);
  }
}
