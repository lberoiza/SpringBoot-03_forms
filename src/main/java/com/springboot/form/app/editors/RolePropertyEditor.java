package com.springboot.form.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.form.app.models.Role;
import com.springboot.form.app.services.IRoleService;

@Component
public class RolePropertyEditor extends PropertyEditorSupport {

  @Autowired
  private IRoleService<Role> roleService;

  @Override
  public void setAsText(String roleIdString) throws IllegalArgumentException {
    try {
      setValue(roleService.getById(Integer.parseInt(roleIdString)));
    } catch (NumberFormatException nfEx) {
      setValue(null);
    }
  }

}
