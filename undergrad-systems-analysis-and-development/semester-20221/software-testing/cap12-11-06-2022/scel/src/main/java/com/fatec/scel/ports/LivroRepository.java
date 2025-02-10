package com.fatec.scel.ports;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fatec.scel.model.Livro;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long> {
	public Livro findByIsbn(@Param("isbn") String isbn);

	List<Livro> findAllByTituloIgnoreCaseContaining(String titulo);

	@Query(value = "SELECT l FROM Livro l ORDER BY titulo")
	List<Livro> buscaTodosLivrosOrdenadosPorTitulo();

}