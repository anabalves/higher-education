package com.fatec.scel.servico;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.scel.model.Livro;
import com.fatec.scel.ports.LivroRepository;
import com.fatec.scel.ports.LivroServico;

@Service
public class LivroServicoI implements LivroServico {
	Logger logger = LogManager.getLogger(this.getClass());
	@Autowired
	LivroRepository repository;

	@Override
	public List<Livro> consultaTodos() {
		List<Livro> result = new ArrayList<Livro>();
		repository.findAll().forEach(result::add);
		return result;
	}

	@Override
	public Livro save(Livro livro) {
		logger.info(">>>>>> servico save - cadastro de livro ");
		return repository.save(livro); // retorna o livro com id
	}

	@Override
	public Optional<Livro> consultaPorId(Long id) {
		logger.info(">>>>>> servico consulta por id chamado");
		return repository.findById(id);
	}

	@Override
	public Livro consultaPorIsbn(String isbn) {
		logger.info(">>>>>> servico consulta por isbn chamado");
		return repository.findByIsbn(isbn);
	}

	@Override
	public void delete(Long id) {
		logger.info(">>>>>> servico delete por id chamado");
		repository.deleteById(id);
	}
}
