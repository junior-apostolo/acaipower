package com.power.acai.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.power.acai.model.Role;
import com.power.acai.repository.RoleRepository;
import com.power.acai.service.RoleService;

@Service(value = "roleService")
public class RoleSerciceImpl implements RoleService {
	@Autowired
	private RoleRepository roleDao;

	@Override
	public Role findByName(String name) {
		Role role = roleDao.findRoleByName(name);
		return role;
	}
	@Override
	public Optional<Role> findById(long id) {
		return roleDao.findById(id);
	}
}
