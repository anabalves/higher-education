package com.fatec.bibliotecanos.domain.service;

import com.fatec.bibliotecanos.common.ApiValidations;
import com.fatec.bibliotecanos.api.dto.UsuarioDTO;
import com.fatec.bibliotecanos.api.dto.request.AtualizarSenhaRequest;
import com.fatec.bibliotecanos.api.dto.request.AtualizarUsuarioRequest;
import com.fatec.bibliotecanos.api.dto.request.RoleToUsuarioRequest;
import com.fatec.bibliotecanos.api.dto.response.RoleToUsuarioResponse;
import com.fatec.bibliotecanos.domain.model.Role;
import com.fatec.bibliotecanos.domain.model.Usuario;
import com.fatec.bibliotecanos.domain.model.enums.ERole;
import com.fatec.bibliotecanos.domain.repository.RoleRepository;
import com.fatec.bibliotecanos.domain.repository.UsuarioRepository;
import com.fatec.bibliotecanos.domain.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public Page<UsuarioDTO> findAllPaged(Pageable pageable) {
        Page<Usuario> list = usuarioRepository.findAll(pageable);
        return list.map(UsuarioDTO::new);
    }

    @Override
    public UsuarioDTO findById(Long id) {
        Optional<Usuario> obj = usuarioRepository.findById(id);
        Usuario entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
        return new UsuarioDTO(entity);
    }

    @Override
    public UsuarioDTO update(Long id, AtualizarUsuarioRequest dto) {
        try {
            Usuario entity = usuarioRepository.getOne(id);
            entity.setNome(dto.getNome());
            entity.setSobrenome(dto.getSobrenome());
            entity.setTelefone(ApiValidations.removeCaracteresEspeciais(dto.getTelefone()));
            entity.setCep(ApiValidations.removeCaracteresEspeciais(dto.getCep()));
            entity.setEndereco(dto.getEndereco());
            entity.setNumeroEndereco(dto.getNumeroEndereco());
            entity.setComplemento(dto.getComplemento());
            entity.setCidade(dto.getCidade());
            entity.setEstado(dto.getEstado());
            entity.setEmailAlternativo(dto.getEmailAlternativo());

            entity = usuarioRepository.save(entity);
            return new UsuarioDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id não encontrado " + id);
        }
    }

    @Override
    public RoleToUsuarioResponse updateRole(Long id, RoleToUsuarioRequest dto) {
        try {
            Usuario entity = usuarioRepository.getOne(id);
            Set<String> strRoles = dto.getRoles();
            Set<Role> roles = new HashSet<>();

            if (strRoles == null) {
                Role usuarioRole = roleRepository.findByAutorizacao(ERole.ROLE_USUARIO)
                        .orElseThrow(() -> new RuntimeException("Error: Role não encontrada."));
                roles.add(usuarioRole);
            } else {
                strRoles.forEach(role -> {
                    switch (role) {
                        case "admin":
                            Role adminRole = roleRepository.findByAutorizacao(ERole.ROLE_ADMIN)
                                    .orElseThrow(() -> new RuntimeException("Error: Role não encontrada."));
                            roles.add(adminRole);
                            break;
                        case "bibliotecario":
                            Role bibliotecarioRole = roleRepository.findByAutorizacao(ERole.ROLE_BIBLIOTECARIO)
                                    .orElseThrow(() -> new RuntimeException("Error: Role não encontrada."));
                            roles.add(bibliotecarioRole);
                            break;
                        default:
                            Role usuarioRole = roleRepository.findByAutorizacao(ERole.ROLE_USUARIO)
                                    .orElseThrow(() -> new RuntimeException("Error: Role não encontrada."));
                            roles.add(usuarioRole);
                    }
                });
            }

            entity.setRoles(roles);
            entity = usuarioRepository.save(entity);
            return new RoleToUsuarioResponse(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id não encontrado " + id);
        }
    }

    @Override
    public UsuarioDTO updateSenha(Long id, AtualizarSenhaRequest dto) {
        try {
            Usuario entity = usuarioRepository.getOne(id);
            entity.setSenha(encoder.encode(dto.getSenha()));

            entity = usuarioRepository.save(entity);
            return new UsuarioDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id não encontrado " + id);
        }
    }

}
