package com.springboot.form.app.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.springboot.form.app.models.Country;

@Primary
@Service("CountryService")
public class CountryService implements ICountryService<Country> {

  private List<Country> countryList;

  public CountryService() {
    this.countryList = Arrays.asList(new Country(1, "CL", "Chile"), new Country(2, "DE", "Germany"),
        new Country(3, "ES", "Spain"), new Country(4, "IT", "Italia"), new Country(5, "FR", "French"),
        new Country(6, "AR", "Argentina"));
  }

  @Override
  public List<Country> getList() {
    return this.countryList;
  }

  @Override
  public Country getById(Integer id) {
    Optional<Country> country = null;
    country = this.countryList.stream().filter(c -> c.getId() == id).findFirst();
    return country.orElse(null);
  }

}
