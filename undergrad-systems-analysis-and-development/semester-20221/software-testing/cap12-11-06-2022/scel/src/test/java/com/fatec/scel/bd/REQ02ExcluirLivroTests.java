package com.fatec.scel.bd;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.scel.model.Livro;
import com.fatec.scel.ports.LivroRepository;
@SpringBootTest
class REQ02ExcluirLivroTests {

	@Autowired
	LivroRepository repository;
	@Test
	void ct01_quando_exclui_livro_pelo_id_consulta_por_isbn_deve_retorna_null() {
		// Dado – que o livro está cadastrado
		repository.deleteAll();
		Livro livro = new Livro("3333", "Teste de Software", "Delamaro");
		repository.save(livro);
		// Quando – o usuário solicita exclusao
		Livro ro = repository.findByIsbn("3333");
		repository.deleteById(ro.getId());
		// Então – o resultado obtido da consulta deve ser null
		assertThat(repository.findByIsbn("3333")).isEqualTo(null);
		assertThat(repository.findByIsbn("3333")).isNull();
	}

}
