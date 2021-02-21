package com.power.acai.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.power.acai.dto.UserDto;
import com.power.acai.model.User;
import com.power.acai.repository.UserRepository;
import com.power.acai.service.EmailService;
import com.power.acai.service.RoleService;
import com.power.acai.service.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private EmailService emailService;

	private Random random = new Random();

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserRepository userDao;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				getAuthority(user));
	}

	private Set<SimpleGrantedAuthority> getAuthority(User user) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
		});
		return authorities;
	}

	public void sendNewPassword(String email) throws com.power.acai.util.exception.ObjectNotFoundException {
		User cliente = userDao.findByEmail(email);
		if (cliente == null) {
			throw new com.power.acai.util.exception.ObjectNotFoundException("Email não encontrado");
		}
		String newPass = newPassword();
		cliente.setPassword(bCryptPasswordEncoder.encode(newPass));
		userDao.save(cliente);
		emailService.sendNewPasswordEmail(cliente, newPass);
	}

	private String newPassword() {
		char[] vet = new char[10];
		for (int i = 0; i < 10; i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}

	private char randomChar() {
		int opt = random.nextInt(3);
		if (opt == 0) { // gera um digito
			return (char) (random.nextInt(10) + 48);
		} else if (opt == 1) { // gera letra maiuscula
			return (char) (random.nextInt(26) + 65);
		} else { // gera letra minuscula
			return (char) (random.nextInt(26) + 97);
		}
	}

	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	public void updateResetPasswordToken(String email) {
		User customer = userDao.findByEmail(email);
		if (customer != null) {
			userDao.save(customer);
		} else {
			System.out.println("Tratar erro que não atualizou");
		}
	}

	@Override
	public User findOne(String username) {
		return userDao.findByUsername(username);
	}

	public Optional<User> findById(long i) {
		return userDao.findById(i);
	}

	/*
	 * foi definido que quando a role estiver nula, o usuario por padrao é um perfil User(id 1). Caso ela venha preenchida a mesma é perfil Admin (id 2)
	 * 
	 * */
	@Override
	public User save(UserDto user) {
		User nUser = user.getUserFromDto();
		nUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userDao.save(nUser);
	}

}
