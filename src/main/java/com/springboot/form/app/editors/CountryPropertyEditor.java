package com.springboot.form.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.form.app.models.Country;
import com.springboot.form.app.services.ICountryService;

@Component
public class CountryPropertyEditor extends PropertyEditorSupport {

  @Autowired
  private ICountryService<Country> countryService;

  @Override
  public void setAsText(String countryIdString) throws IllegalArgumentException {
    try {
      setValue(countryService.getById(Integer.parseInt(countryIdString)));
    } catch (NumberFormatException nfEx) {
      setValue(null);
    }
  }

}
