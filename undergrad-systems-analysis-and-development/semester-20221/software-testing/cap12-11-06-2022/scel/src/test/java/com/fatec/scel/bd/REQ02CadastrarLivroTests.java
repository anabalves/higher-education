package com.fatec.scel.bd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import com.fatec.scel.model.Livro;
import com.fatec.scel.ports.LivroRepository;
@SpringBootTest
class REQ02CadastrarLivroTests {

	@Autowired
	LivroRepository repository;
	private Livro livro;
	private Validator validator;
	private ValidatorFactory validatorFactory;

	@Test
	void ct01_quando_dados_validos_isbn_nao_cadastrado_retorna1() {
		// Dado – que o atendente tem um livro não cadastrado
		repository.deleteAll();
		Livro livro = new Livro("4444", "Teste de Software", "Delamaro");
		// Quando – o atendente cadastra um livro com informações validas
		repository.save(livro);
		// Então – o sistema valida os dados E permite a consulta do livro
		assertEquals(1, repository.count());
	}

	@Test
	void ct02_quando_dados_invalidos_violacoes_retorna_true() {
		// Dado – que o atendente tem um livro não cadastrado
		livro = new Livro("3333", "", "Delamaro");
		// Quando – o usuário não informa o título do livro
		validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
		Set<ConstraintViolation<Livro>> violations = validator.validate(livro);
		// Então – o sistema rejeita o cadastro.
		assertFalse(violations.isEmpty());
	}

	@Test
	void ct03_quando_titulo_branco_msg_titulo_invalido() {
		// Dado – que o atendente tem um livro não cadastrado
		livro = new Livro("3333", "", "Delamaro");
		// Quando – o atendente cadastra um livro com informações válidas
		validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
		Set<ConstraintViolation<Livro>> violations = validator.validate(livro);
		// Então – o sistema verifica os dados e retorna titulo invalido.
		// assertFalse(violations.isEmpty());
		// assertEquals(violations.size(), 1);
		assertEquals("Titulo deve ter entre 1 e 50 caracteres", violations.iterator().next().getMessage());
	}

	@Test
	void ct04_quando_isbn_ja_cadastrado_retornar_violacao_de_integridade() {
		// Dado – que o ISBN do livro ja está cadastrado
		repository.deleteAll();
		livro = new Livro("4444", "Teste de Software", "Delamaro");
		repository.save(livro);
		// Quando – o usuário registra as informações do livro e confirma a operação
		livro = new Livro("4444", "Teste de Software", "Delamaro");
		// Então – o sistema valida as informações E retorna violação de integridade.
		try {
			repository.save(livro);
		} catch (DataIntegrityViolationException e) {
			assertEquals("could not execute statement", e.getMessage().substring(0, 27));
			assertEquals(1, repository.count());
		}
	}


}
