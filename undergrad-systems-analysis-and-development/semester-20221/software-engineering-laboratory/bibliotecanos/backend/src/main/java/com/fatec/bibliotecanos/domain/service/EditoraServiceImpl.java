package com.fatec.bibliotecanos.domain.service;

import com.fatec.bibliotecanos.api.dto.EditoraDTO;
import com.fatec.bibliotecanos.domain.model.Editora;
import com.fatec.bibliotecanos.domain.exception.DatabaseException;
import com.fatec.bibliotecanos.domain.exception.ResourceNotFoundException;
import com.fatec.bibliotecanos.domain.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@Transactional
public class EditoraServiceImpl implements EditoraService {

    @Autowired
    private EditoraRepository editoraRepository;

    @Override
    public Page<EditoraDTO> findAllPaged(Pageable pageable) {
        Page<Editora> list = editoraRepository.findAll(pageable);
        return list.map(EditoraDTO::new);
    }

    @Override
    public EditoraDTO findById(Long id) {
        Optional<Editora> obj = editoraRepository.findById(id);
        Editora entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
        return new EditoraDTO(entity);
    }

    @Override
    public EditoraDTO insert(EditoraDTO dto) {
        Editora entity = new Editora();
        copyDtoToEntity(dto, entity);
        entity = editoraRepository.save(entity);
        return new EditoraDTO(entity);
    }

    @Override
    public EditoraDTO update(Long id, EditoraDTO dto) {
        try {
            Editora entity = editoraRepository.getOne(id);
            copyDtoToEntity(dto, entity);
            entity = editoraRepository.save(entity);
            return new EditoraDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id não encontrado " + id);
        }
    }

    @Override
    public void delete(Long id) {
        try {
            editoraRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id não encontrado " + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Violação da integridade");
        }
    }

    private void copyDtoToEntity(EditoraDTO dto, Editora entity) {
        entity.setNome(dto.getNome());
    }

}
