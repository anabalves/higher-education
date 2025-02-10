package com.fatec.scel.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.fatec.scel.model.Livro;
import com.fatec.scel.ports.LivroRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
class REQ02ConsultarLivroAPITests {

	String urlBase = "/api/v1/livros/";
	@Autowired
	TestRestTemplate testRestTemplate;
	@Autowired
	LivroRepository repository;

	@BeforeAll
	void inicializa() {
		repository.deleteAll();
		Livro umLivro = new Livro("1111", "Teste de Software", "Delamaro");
		repository.save(umLivro);
		umLivro = new Livro("2222", "Engenharia de Software", "Pressman");
		repository.save(umLivro);
		Iterable<Livro> livros = repository.findAll();
		ArrayList<Livro> lista = new ArrayList<Livro>();
		livros.forEach(item -> lista.add(item));
		lista.forEach(livro -> System.out.println("Livros cadastrados nesta sessao =>" + livro.toString()));
	}

	@Test
	void ct01_quando_cosulta_todos_retorna2() {
		// Dado - que existem 2 registros cadastrados
		// Quando - solicita uma requisicao get consulta todos
		ParameterizedTypeReference<List<Livro>> tipoRetorno = new ParameterizedTypeReference<List<Livro>>() {
		};
		ResponseEntity<List<Livro>> resposta = testRestTemplate.exchange(urlBase, HttpMethod.GET, null, tipoRetorno);
		List<Livro> lista = resposta.getBody();
		// Entao - retorna 2 assertEquals(2, lista.size());
		// validacao do estado
		Livro re = new Livro("1111", "Teste de Software", "Delamaro");
		Livro ro = resposta.getBody().get(0);
		re.setId(ro.getId());
		assertEquals(re.getId(), ro.getId());
		assertTrue(re.equals(ro));
	}

	@Test
	public void ct02_quando_consulta_pelo_isbn_entao_retorna_os_detalhes_do_livro() throws Exception {
		// Dado - que existem dois registros no banco de dados
		// Quando - o usuario consulta pelo isbn
		String isbn = "1111";
		ResponseEntity<Livro> resposta = testRestTemplate.getForEntity(urlBase + isbn, Livro.class);
		Livro ro = resposta.getBody();
		// Entao - retorna os detalhes do livro
		Livro re = new Livro("1111", "Teste de Software", "Delamaro");
		re.setId(ro.getId()); // id deve ser inicializado no teste assertTrue(re.equals(ro));
		assertEquals("200 OK", resposta.getStatusCode().toString());
	}

	@Test
	public void ct03_quando_consulta_isbn_nao_cadastrado_retorna_not_found() throws Exception {
		// Dado - que existem dois registros no banco de dados
		// Quando - o usuario consulta isbn nao cadastrado
		String isbn = "3333";
		ResponseEntity<Livro> resposta = testRestTemplate.getForEntity(urlBase + isbn, Livro.class);
		Optional<Livro> ro = Optional.ofNullable(resposta.getBody());
		// Entao - retorna not found assertFalse(ro.isPresent());
		assertEquals("404 NOT_FOUND", resposta.getStatusCode().toString());
	}

}
