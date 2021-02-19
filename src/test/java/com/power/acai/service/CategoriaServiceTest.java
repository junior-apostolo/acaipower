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
import org.springframework.test.context.junit4.SpringRunner;
import com.power.acai.model.Categoria;
import com.power.acai.repository.CategoriaRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.main.allow-bean-definition-overriding=true")
public class CategoriaServiceTest   {

	@TestConfiguration
	static class CategoriaServiceTestConfiguration {
		@Bean
		public CategoriaService categoriaServiceTest() {
			return new CategoriaService();
		}
	}

	@Autowired
	CategoriaService categoriaService;
	@MockBean
	CategoriaRepository categoriaRepository;

	@BeforeEach
	public void setup() {
		Categoria categoria = new Categoria(1, "Comida");+
		
		Mockito.when(categoriaRepository.findById(1)).thenReturn(Optional.of(categoria));
	}
	
	@Test
	public void getCategoriaId() {
		Optional<Categoria> opCategoria = categoriaService.findById(1);
		assertNotNull(opCategoria.get());
	}
}
