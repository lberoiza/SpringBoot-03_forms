package com.springboot.form.app.models;

import java.util.Objects;

public class Role {

  private Integer id;
  private String name;
  private String code;

  public Role() {
  }

  public Role(Integer id, String name, String code) {
    super();
    this.id = id;
    this.name = name;
    this.code = code;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
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
    Role other = (Role) obj;
    return Objects.equals(code, other.code) && Objects.equals(id, other.id) && Objects.equals(name, other.name);
  }

  @Override
  public String toString() {
    return "Role [id=" + id + ", name=" + name + ", code=" + code + "]";
  }
}
