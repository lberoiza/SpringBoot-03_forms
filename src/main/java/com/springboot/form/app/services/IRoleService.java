package com.springboot.form.app.services;

import java.util.List;

import com.springboot.form.app.models.Role;

public interface IRoleService<T extends Role> {

  public List<T> getList();

  public T getById(Integer id);
}
