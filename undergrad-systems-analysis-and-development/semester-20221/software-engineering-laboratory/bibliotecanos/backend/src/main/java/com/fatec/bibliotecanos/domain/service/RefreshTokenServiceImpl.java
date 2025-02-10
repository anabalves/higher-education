package com.fatec.bibliotecanos.domain.service;

import com.fatec.bibliotecanos.domain.model.RefreshToken;
import com.fatec.bibliotecanos.domain.repository.RefreshTokenRepository;
import com.fatec.bibliotecanos.domain.repository.UsuarioRepository;
import com.fatec.bibliotecanos.api.exceptions.TokenRefreshException;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RefreshTokenServiceImpl {
    @Value("${bibliotecanos.app.jwtRefreshExpirationMs}")
    private Long refreshTokenDurationMs;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    public RefreshToken createRefreshToken(Long usuarioId) {
        RefreshToken refreshToken = new RefreshToken();

        refreshToken.setUsuario(usuarioRepository.findById(usuarioId).get());
        refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
        refreshToken.setToken(UUID.randomUUID().toString());

        refreshToken = refreshTokenRepository.save(refreshToken);
        return refreshToken;
    }

    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshTokenRepository.delete(token);
            throw new TokenRefreshException(token.getToken(), "Refresh token was expired. Please make a new signin request");
        }

        return token;
    }

    @Transactional
    public int deleteByUserId(Long usuarioId) {
        return refreshTokenRepository.deleteByUsuario(usuarioRepository.findById(usuarioId).get());
    }

}
