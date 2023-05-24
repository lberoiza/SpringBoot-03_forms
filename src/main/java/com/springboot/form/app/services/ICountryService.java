package com.springboot.form.app.services;

import java.util.List;

import com.springboot.form.app.models.Country;

public interface ICountryService<T extends Country> {

  public List<T> getList();

  public T getById(Integer id);
}
