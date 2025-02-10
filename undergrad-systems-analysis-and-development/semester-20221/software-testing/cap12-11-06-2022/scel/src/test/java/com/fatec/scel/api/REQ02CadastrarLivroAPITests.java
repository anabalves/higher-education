package com.fatec.scel.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.fatec.scel.model.Livro;
import com.google.gson.Gson;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class REQ02CadastrarLivroAPITests {
	String urlBase = "/api/v1/livros";
	@Autowired
	TestRestTemplate testRestTemplate;

	@Test
	void ct01_cadastrar_livro_com_sucesso() {
		// Dado – que o servico está disponivel e o atendente tem um livro não
		// cadastrado
		Livro livro = new Livro("3333", "User Stories", "Cohn");
		Gson dadosDeEntrada = new Gson();
		String entity = dadosDeEntrada.toJson(livro);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> httpEntity = new HttpEntity<String>(entity, headers);
		// Quando – o atendente cadastra um livro com informações válidas
		ResponseEntity<String> resposta = testRestTemplate.exchange(urlBase, HttpMethod.POST, httpEntity, String.class);
		// Então – o sistema valida os dados e permite a consulta do livro
		String bodyEsperado = "{\"id\":1,\"isbn\":\"3333\",\"titulo\":\"User Stories\",\"autor\":\"Cohn\"}";
		assertEquals(bodyEsperado, resposta.getBody());
		assertEquals("201 CREATED", resposta.getStatusCode().toString());
		assertEquals(HttpStatus.CREATED, resposta.getStatusCode());

	}

	@Test
	public void ct02_quando_metodo_http_nao_disponivel_retorna_http_405() throws Exception {
		// Dado – que o servico está disponivel e o atendente tem um livro não
		// cadastrado
		Livro livro = new Livro("1111", "Teste de Software", "Delamaro");
		// Quando o cadastro é realizado para um método não disponivel
		HttpEntity<Livro> httpEntity3 = new HttpEntity<>(livro);
		ResponseEntity<String> resposta2 = testRestTemplate.exchange(urlBase, HttpMethod.PUT, httpEntity3,
				String.class);
		// Retorna http 405
		assertEquals("405 METHOD_NOT_ALLOWED", resposta2.getStatusCode().toString());
	}

	@Test
	public void ct03_quando_livro_ja_cadastrado_retorna_400() {
		// Dado - que o livro ja esta cadastrado
		Livro livro = new Livro("4444", "User Stories", "Cohn");
		HttpEntity<Livro> httpEntity = new HttpEntity<>(livro);
		ResponseEntity<String> resposta = testRestTemplate.exchange(urlBase, HttpMethod.POST, httpEntity, String.class);
		// Quando - o usuario faz uma requisicao POST para cadastrar livro
		resposta = testRestTemplate.exchange(urlBase, HttpMethod.POST, httpEntity, String.class);
		// Entao - retorna HTTP200
		assertEquals("400 BAD_REQUEST", resposta.getStatusCode().toString());
		assertEquals("Livro já cadastrado", resposta.getBody());
	}

	@Test
	void ct04_quando_requisicao_invalida_retorna_400() {
		// Dado - que livro não esta cadastrado
		Livro livro = new Livro("4444", "", "Sommerville");
		// Quando - o usuario faz uma requisicao POST invalida 
		HttpEntity<Livro> httpEntity = new HttpEntity<>(livro);
		ResponseEntity<String> resposta = testRestTemplate.exchange(urlBase, HttpMethod.POST, httpEntity, String.class);
		// Entao - retorna HTTP400
		assertEquals("400 BAD_REQUEST", resposta.getStatusCode().toString());
	}

}
