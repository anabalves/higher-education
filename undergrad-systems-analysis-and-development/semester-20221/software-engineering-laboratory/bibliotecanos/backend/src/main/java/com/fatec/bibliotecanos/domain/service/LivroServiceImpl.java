package com.fatec.bibliotecanos.domain.service;

import com.fatec.bibliotecanos.api.dto.LivroDTO;
import com.fatec.bibliotecanos.api.dto.response.RelatorioAcervoResponse;
import com.fatec.bibliotecanos.api.dto.response.RelatorioUsuariosResponse;
import com.fatec.bibliotecanos.domain.model.Editora;
import com.fatec.bibliotecanos.domain.model.Genero;
import com.fatec.bibliotecanos.domain.model.Livro;
import com.fatec.bibliotecanos.domain.model.enums.ELivro;
import com.fatec.bibliotecanos.domain.exception.DatabaseException;
import com.fatec.bibliotecanos.domain.exception.ResourceNotFoundException;
import com.fatec.bibliotecanos.domain.repository.EditoraRepository;
import com.fatec.bibliotecanos.domain.repository.GeneroRepository;
import com.fatec.bibliotecanos.domain.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LivroServiceImpl implements LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private EditoraRepository editoraRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Page<LivroDTO> findAll(Pageable pageable) {
        Page<Livro> list = livroRepository.findAll(pageable);
        return list.map(LivroDTO::new);
    }

    @Override
    public LivroDTO findById(Long id) {
        Optional<Livro> obj = livroRepository.findById(id);
        Livro entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
        return new LivroDTO(entity);
    }

    @Override
    public LivroDTO insert(LivroDTO dto) {
        Livro entity = new Livro();
        return verificaStatusLivro(dto, entity);
    }

    @Override
    public LivroDTO update(Long id, LivroDTO dto) {
        try {
            Livro entity = livroRepository.getOne(id);
            return verificaStatusLivro(dto, entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id não encontrado " + id);
        }
    }

    private LivroDTO verificaStatusLivro(LivroDTO dto, Livro entity) {
        if (dto.getQuantidade().equals(0)) {
            entity.setStatus(ELivro.INDISPONIVEL);
            copyDtoToEntity(dto, entity);
        } else {
            copyDtoToEntity(dto, entity);
            entity.setStatus(ELivro.DISPONIVEL);
        }
        entity = livroRepository.save(entity);
        return new LivroDTO(entity);
    }

    @Override
    public void delete(Long id) {
        try {
            livroRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id não encontrado " + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Violação da integridade");
        }
    }

    @Override
    public List<RelatorioAcervoResponse> relatorioAcervo() {
        return jdbcTemplate.query("SELECT \n" +
                "\tA.ID,\n" +
                "\tA.TITULO,\n" +
                "\tA.AUTOR,\n" +
                "\tA.DESCRICAO,\n" +
                "\tB.NOME AS EDITORA,\n" +
                "\tC.NOME AS GENERO,\n" +
                "\tA.ANO_PUBLICACAO,\n" +
                "\tA.ISBN\n" +
                "FROM \n" +
                "\ttb_livro A, \n" +
                "\ttb_editora B, \n" +
                "\ttb_genero C \n" +
                "WHERE \n" +
                "\ta.editora_id = b.id \n" +
                "AND \n" +
                "\ta.genero_id = c.id\n" +
                "ORDER BY \n" +
                "\ta.titulo",
                BeanPropertyRowMapper.newInstance(RelatorioAcervoResponse.class));
    }

    private void copyDtoToEntity(LivroDTO dto, Livro entity) {
        entity.setTitulo(dto.getTitulo());
        entity.setDescricao(dto.getDescricao());
        entity.setAutor(dto.getAutor());
        entity.setEdicao(dto.getEdicao());
        entity.setIsbn(dto.getIsbn());
        entity.setQuantidade(dto.getQuantidade());
        entity.setImgUrl(dto.getImgUrl());
        entity.setAnoPublicacao(dto.getAnoPublicacao());

        Genero genero = generoRepository.getOne(dto.getGeneroId());
        entity.setGenero(genero);

        Editora editora = editoraRepository.getOne(dto.getEditoraId());
        entity.setEditora(editora);
    }

}
