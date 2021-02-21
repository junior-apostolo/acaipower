package com.power.acai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.power.acai.model.Role;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Long> {
    Role findRoleByName(String name);
}
