package com.power.acai.service;

import java.util.Optional;

import com.power.acai.model.Role;

public interface  RoleService {
    Role findByName(String name);

	Optional<Role> findById(long string);

}
