package com.fatec.scel.api;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fatec.scel.model.Livro;
import com.fatec.scel.ports.LivroRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class REQ02ExcluirLivroAPITest {
	String urlBase = "/api/v1/livros/";
	@Autowired
	TestRestTemplate testRestTemplate;
	@Autowired
	LivroRepository repository;

	@Test
	void ct01_quando_exclui_pelo_id_consulta_por_isbn_deve_retorna_null() {
		// Dado – que o id está cadastrado
		repository.deleteAll();
		Livro livro = new Livro("3333", "Teste de Software", "Delamaro");
		Livro umLivro = repository.save(livro);
		// Quando – o usuário solicita exclusao
		ResponseEntity<String> resposta = testRestTemplate.exchange(urlBase + umLivro.getId(), HttpMethod.DELETE, null,
				String.class);
		// Então – o resultado obtido da consulta deve ser null
		assertEquals(HttpStatus.NO_CONTENT, resposta.getStatusCode());
		assertThat(repository.findByIsbn("3333")).isEqualTo(null);
	}

}
