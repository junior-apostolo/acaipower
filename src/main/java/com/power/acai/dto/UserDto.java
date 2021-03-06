package com.power.acai.dto;

import java.util.HashSet;
import java.util.Set;

import com.power.acai.model.Role;
import com.power.acai.model.User;

public class UserDto {

	private String username;
	private String password;
	private String email;
	private String phone;
	private String name;
	private String businessTitle;
	private Set<Role> roles = new HashSet<>();

	public UserDto(String username, String password, String email, String phone, String name, String businessTitle) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.name = name;
		this.businessTitle = businessTitle;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBusinessTitle() {
		return businessTitle;
	}

	public void setBusinessTitle(String businessTitle) {
		this.businessTitle = businessTitle;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public User getUserFromDto() {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setPhone(phone);
		user.setName(name);
		user.setBusinessTitle(businessTitle);
		if (this.roles == null || this.roles.isEmpty()) {
			Role role = new Role(1, "USER", "USER");
			user.setRoles(Set.of(role));
		} else {
			Role role = new Role(2, "ADMIN", "ADMIN");
			user.setRoles(Set.of(role));

		}
		return user;
	}
}
