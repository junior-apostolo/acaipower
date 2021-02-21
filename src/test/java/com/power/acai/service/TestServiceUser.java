package com.power.acai.service;

import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.context.junit4.SpringRunner;

import com.power.acai.dto.UserDto;
import com.power.acai.model.User;
import com.power.acai.repository.UserRepository;
import com.power.acai.service.impl.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.main.allow-bean-definition-overriding=true")
public class TestServiceUser {

	@Autowired
	UserServiceImpl userService;
	@MockBean
	UserRepository userRepository;

	@Autowired
	SmtpEmailService stmp;

	@TestConfiguration
	static class UserServiceTestConfiguration {
		@Bean
		public UserServiceImpl userServiceTest() {
			return new UserServiceImpl();
		}

		@Bean
		public EmailService emailService() {
			return new SmtpEmailService();
		}
	}

	/*
	 * seta informacoes para depois realizar alguns testes
	 */

	@BeforeEach
	public void setup() {
		User user1 = new User(1, "kaiquemotta", "123", "kaique.motta@hotmail.com", "11989778962",
				"kaique de jesus motta", "auto geral");
		Mockito.when(userRepository.findByUsername("kaiquemotta")).thenReturn(user1);
		Optional<User> user2 = Optional.ofNullable(new User(2, "kaiquemotta", "123", "kaique.motta@hotmail.com",
				"11989778962", "kaique de jesus motta", "auto geral"));
		Mockito.when(userRepository.findById(2L)).thenReturn(user2);

	}

	/*
	 * registra usuario
	 */

	@Test
	public void cadastraUsuario() {
		UserDto user = new UserDto("kaiquemotta", "123", "kaique.motta@hotmail.com", "11989778962",
				"Kaique de jesus Motta", "auto geral");
		User u = new User();
		Mockito.when(userRepository.save(Mockito.any(user.getUserFromDto().getClass())))
				.thenAnswer(i -> i.getArgument(0));
		u = userService.save(user);
		assertNotNull(u);
	}

	/*
	 * busca usuario pelo nome
	 */
	@Test
	public void findOneUserName() {
		User u = userService.findOne("kaiquemotta");
		assertNotNull(u);
	}

	/*
	 * busca usuario pelo id
	 */
	@Test
	public void findOneId() {
		Optional<User> u = userService.findById(2L);
		assertNotNull(u.get());
	}

	@Test
	public void testeEnvioSenha() {
		Optional<User> u = userService.findById(2L);
		stmp.sendNewPasswordEmail(u.get(), "12345");

	}
	
}
