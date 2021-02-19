package com.power.acai.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.power.acai.model.Categoria;

@SpringBootTest
@AutoConfigureMockMvc
public class CategoriaControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	

	@Test
	public void getAllCategoria() throws Exception {
		mockMvc.perform(get("/categoria/")).andExpect(status().isOk());
	}

	@Test
	public void postCategoria() throws Exception {
		Categoria c = new Categoria("Comida");
		mockMvc.perform(
				post("/categoria/cadastrar").contentType("application/json").content(objectMapper.writeValueAsString(c)))
				.andExpect(status().isOk());
	}
}
