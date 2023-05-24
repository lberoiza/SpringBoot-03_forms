package com.springboot.form.app.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.springboot.form.app.models.Role;

@Primary
@Service("RoleService")
public class RoleService implements IRoleService<Role> {

  private List<Role> roleList;

  public RoleService() {
    this.roleList = Arrays.asList(new Role(1, "Adminstrator", "ROLE_ADMIN"), new Role(2, "Moderator", "ROLE_MODERATOR"),
        new Role(3, "User", "ROLE_USER"));
  }

  @Override
  public List<Role> getList() {
    return this.roleList;
  }

  @Override
  public Role getById(Integer id) {
    Optional<Role> country = null;
    country = this.roleList.stream().filter(c -> c.getId() == id).findFirst();
    return country.orElse(null);
  }

}
