package com.fatec.bibliotecanos.api.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.Valid;

import com.fatec.bibliotecanos.common.ApiValidations;
import com.fatec.bibliotecanos.domain.model.RefreshToken;
import com.fatec.bibliotecanos.domain.model.Role;
import com.fatec.bibliotecanos.domain.model.Usuario;
import com.fatec.bibliotecanos.domain.model.enums.ERole;
import com.fatec.bibliotecanos.domain.model.enums.EUsuario;
import com.fatec.bibliotecanos.domain.repository.RoleRepository;
import com.fatec.bibliotecanos.domain.repository.UsuarioRepository;
import com.fatec.bibliotecanos.api.exceptions.TokenRefreshException;
import com.fatec.bibliotecanos.common.jwt.JwtUtils;
import com.fatec.bibliotecanos.api.dto.request.LogOutRequest;
import com.fatec.bibliotecanos.api.dto.request.LoginRequest;
import com.fatec.bibliotecanos.api.dto.request.SignupRequest;
import com.fatec.bibliotecanos.api.dto.request.TokenRefreshRequest;
import com.fatec.bibliotecanos.api.dto.response.JwtResponse;
import com.fatec.bibliotecanos.api.dto.response.MessageResponse;
import com.fatec.bibliotecanos.api.dto.response.TokenRefreshResponse;
import com.fatec.bibliotecanos.domain.service.RefreshTokenServiceImpl;
import com.fatec.bibliotecanos.domain.service.UsuarioDetailsImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@Api(value = "/api/auth", tags = "Bibliotecanos API", description = "API Para Gerenciamento de Bibliotecas")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    RefreshTokenServiceImpl refreshTokenService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getSenha()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UsuarioDetailsImpl usuarioDetails = (UsuarioDetailsImpl) authentication.getPrincipal();

        String jwt = jwtUtils.generateJwtToken(usuarioDetails);

        List<String> roles = usuarioDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        RefreshToken refreshToken = refreshTokenService.createRefreshToken(usuarioDetails.getId());

        return ResponseEntity.ok(new JwtResponse(
                jwt,
                refreshToken.getToken(),
                usuarioDetails.getId(),
                usuarioDetails.getNome(),
                usuarioDetails.getSobrenome(),
                usuarioDetails.getEmail(),
                usuarioDetails.getEmailAlternativo(),
                usuarioDetails.getCpf(),
                usuarioDetails.getTelefone(),
                usuarioDetails.getCep(),
                usuarioDetails.getEndereco(),
                usuarioDetails.getNumeroEndereco(),
                usuarioDetails.getComplemento(),
                usuarioDetails.getCidade(),
                usuarioDetails.getEstado(),
                roles,
                usuarioDetails.getSituacao(),
                usuarioDetails.getObservacao()));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (usuarioRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: O e-mail já foi cadastrado!"));
        }

        if (usuarioRepository.existsByCpf(signUpRequest.getCpf())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: O CPF já foi cadastrado!"));
        }

        if (!ApiValidations.validarEmailFatec(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: O e-mail fatec é inválido!"));
        }

        if (!ApiValidations.validarEmailAlternativo(signUpRequest.getEmailAlternativo())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: O e-mail alternativo é inválido!"));
        }

        if (!ApiValidations.validarCPF(signUpRequest.getCpf())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: O CPF é inválido!"));
        }

        if (!ApiValidations.validarTelefone(signUpRequest.getTelefone())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: O Telefone é inválido!"));
        }

        if (!ApiValidations.validarCep(signUpRequest.getCep())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: O CEP é inválido!"));
        }

        Usuario usuario = new Usuario(
                signUpRequest.getNome(),
                signUpRequest.getSobrenome(),
                ApiValidations.removeCaracteresEspeciais(signUpRequest.getCpf()),
                ApiValidations.removeCaracteresEspeciais(signUpRequest.getTelefone()),
                ApiValidations.removeCaracteresEspeciais(signUpRequest.getCep()),
                signUpRequest.getEndereco(),
                signUpRequest.getNumeroEndereco(),
                signUpRequest.getComplemento(),
                signUpRequest.getCidade(),
                signUpRequest.getEstado(),
                signUpRequest.getEmailAlternativo(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getSenha()));

        Set<String> strRoles = signUpRequest.getRoles();
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

        usuario.setRoles(roles);
        usuario.setSituacao(EUsuario.OK);
        usuario.setObservacao("Usuário OK - Devoluções no Prazo Correto");
        usuarioRepository.save(usuario);

        return ResponseEntity.ok(new MessageResponse("Usuário cadastrado com sucesso!"));
    }

    @PostMapping("/refreshtoken")
    public ResponseEntity<?> refreshtoken(@Valid @RequestBody TokenRefreshRequest request) {
        String requestRefreshToken = request.getRefreshToken();

        return refreshTokenService.findByToken(requestRefreshToken)
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUsuario)
                .map(usuario -> {
                    String token = jwtUtils.generateTokenFromUsername(usuario.getEmail());
                    return ResponseEntity.ok(new TokenRefreshResponse(token, requestRefreshToken));
                })
                .orElseThrow(() -> new TokenRefreshException(requestRefreshToken,
                        "Refresh token não está na base de dados!"));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser(@Valid @RequestBody LogOutRequest logOutRequest) {
        refreshTokenService.deleteByUserId(logOutRequest.getUsuarioId());
        return ResponseEntity.ok(new MessageResponse("Log out com sucesso!"));
    }

}