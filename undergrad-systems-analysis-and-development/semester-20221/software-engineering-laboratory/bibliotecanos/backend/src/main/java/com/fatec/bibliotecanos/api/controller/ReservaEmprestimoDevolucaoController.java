package com.fatec.bibliotecanos.api.controller;

import com.fatec.bibliotecanos.api.dto.ReservaEmprestimoDevolucaoDTO;
import com.fatec.bibliotecanos.api.dto.UsuarioDTO;
import com.fatec.bibliotecanos.api.dto.response.*;
import com.fatec.bibliotecanos.domain.service.ReservaEmprestimoDevolucaoServiceImpl;
import com.fatec.bibliotecanos.domain.service.UsuarioServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/reserva-emprestimos-devolucoes")
@Api(value = "/api/reserva-emprestimos-devolucoes", tags = "Bibliotecanos API", description = "API Para Gerenciamento de Bibliotecas")
public class ReservaEmprestimoDevolucaoController {

    @Autowired
    private ReservaEmprestimoDevolucaoServiceImpl reservaEmprestimoDevolucaoServiceImpl;

    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    @PostMapping(value = "/reservar")
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ADMIN') or hasRole('USUARIO')")
    public ResponseEntity<?> realizarReserva(@RequestBody ReservaEmprestimoDevolucaoDTO dto) {
        try {
            dto = reservaEmprestimoDevolucaoServiceImpl.realizarReserva(dto);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(dto.getId()).toUri();
            return ResponseEntity.created(uri).body(dto);
        } catch (NullPointerException e) {
            return ResponseEntity.badRequest().body("Nao Foi Possivel realizar a reserva.");
        }
    }

    @PostMapping(value = "/emprestar")
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ADMIN') or hasRole('USUARIO')")
    public ResponseEntity<?> realizarEmprestimo(@RequestBody ReservaEmprestimoDevolucaoDTO dto) {
        try {
            dto = reservaEmprestimoDevolucaoServiceImpl.realizarEmprestimo(dto);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(dto.getId()).toUri();
            return ResponseEntity.created(uri).body(dto);
        } catch (NullPointerException e) {
            return ResponseEntity.badRequest().body("Nao Foi Possivel realizar o emprestimo.");
        }
    }

    @PutMapping(value = "/devolver/{id}")
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ADMIN')")
    public ResponseEntity<?> realizarDevolucao(@PathVariable Long id, @RequestBody ReservaEmprestimoDevolucaoDTO dto) {
        try {
            dto = reservaEmprestimoDevolucaoServiceImpl.realizarDevolucao(id, dto);
            return ResponseEntity.ok().body(dto);
        } catch (NullPointerException e) {
            return ResponseEntity.badRequest().body("Nao Foi Possivel realizar a devolucao.");
        }
    }

    @PutMapping(value = "/cancelar/{id}")
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ADMIN') or hasRole('USUARIO')")
    public ResponseEntity<?> realizarCancelamento(@PathVariable Long id, @RequestBody ReservaEmprestimoDevolucaoDTO dto) {
        try {
            dto = reservaEmprestimoDevolucaoServiceImpl.realizarCancelamento(id, dto);
            return ResponseEntity.ok().body(dto);
        } catch (NullPointerException e) {
            return ResponseEntity.badRequest().body("Nao Foi Possivel realizar o cancelamento.");
        }
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ADMIN')")
    public ResponseEntity<ReservaEmprestimoDevolucaoDTO> findById(@PathVariable Long id) {
        ReservaEmprestimoDevolucaoDTO dto = reservaEmprestimoDevolucaoServiceImpl.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ADMIN')")
    public ResponseEntity<Page<ReservaEmprestimoDevolucaoDTO>> findAll(Pageable pageable) {
        Page<ReservaEmprestimoDevolucaoDTO> list = reservaEmprestimoDevolucaoServiceImpl.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/usuario/{usuarioId}")
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ADMIN') or hasRole('USUARIO')")
    public ResponseEntity<List<ReservaEmprestimoDevolucaoDTO>> findByUsuarioId(@PathVariable Long usuarioId) {
        List<ReservaEmprestimoDevolucaoDTO> list = reservaEmprestimoDevolucaoServiceImpl.findByUsuarioId(usuarioId);
        return ResponseEntity.ok().body(list);
    }


    @GetMapping(value = "/relatorio-usuarios")
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ADMIN')")
    public ResponseEntity<List<RelatorioUsuariosResponse>> relatorioUsuarios() {
        List<RelatorioUsuariosResponse> list = reservaEmprestimoDevolucaoServiceImpl.relatorioUsuarios();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/relatorio-saida")
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ADMIN')")
    public ResponseEntity<List<RelatorioSaidaResponse>> relatorioSaida() {
        List<RelatorioSaidaResponse> list = reservaEmprestimoDevolucaoServiceImpl.relatorioSaida();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/relatorio-atrasos")
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ADMIN')")
    public ResponseEntity<List<RelatorioAtrasosResponse>> relatorioAtrasos() {
        List<RelatorioAtrasosResponse> list = reservaEmprestimoDevolucaoServiceImpl.relatorioAtrasos();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/relatorio-emprestimos")
    @PreAuthorize("hasRole('BIBLIOTECARIO') or hasRole('ADMIN')")
    public ResponseEntity<List<RelatorioEmprestimosResponse>> relatorioEmprestimos() {
        List<RelatorioEmprestimosResponse> list = reservaEmprestimoDevolucaoServiceImpl.relatorioEmprestimos();
        return ResponseEntity.ok().body(list);
    }

    @Scheduled(cron="0 0 1 * * *", zone="America/Sao_Paulo")
    public void atualizaSituacaoUsuarioParaIrregular() {
        List<ReservaEmprestimoDevolucaoDTO> reservaEmprestimoDevolucao = reservaEmprestimoDevolucaoServiceImpl.listaUsuariosComUmDiaDeAtrasoDeDevolucao();

        for (ReservaEmprestimoDevolucaoDTO red : reservaEmprestimoDevolucao) {
            ReservaEmprestimoDevolucaoDTO reservaEmprestimoDevolucaoDTO = reservaEmprestimoDevolucaoServiceImpl.findById(red.getId());
            UsuarioDTO usuario = usuarioServiceImpl.findById(red.getUsuarioId());

            usuario.setSituacao("IRREGULAR");
            usuario.setObservacao("Usuário IRREGULAR - Punição de 30 Dias por Atrasar Devolução");
            reservaEmprestimoDevolucaoServiceImpl.updateSituacaoUsuario(usuario);

            reservaEmprestimoDevolucaoDTO.setSituacao("EM_ATRASO");
            reservaEmprestimoDevolucaoServiceImpl.updateSituacaoReservaEmprestimoDevolucao(reservaEmprestimoDevolucaoDTO);
        }
    }

    @Scheduled(cron="0 0 1 * * *", zone="America/Sao_Paulo")
    public void atualizaSituacaoUsuarioParaBanido() {
        List<ReservaEmprestimoDevolucaoDTO> reservaEmprestimoDevolucao = reservaEmprestimoDevolucaoServiceImpl.listaUsuariosComQuinzeDiasDeAtrasoDeDevolucao();

        for (ReservaEmprestimoDevolucaoDTO red : reservaEmprestimoDevolucao) {
            ReservaEmprestimoDevolucaoDTO reservaEmprestimoDevolucaoDTO = reservaEmprestimoDevolucaoServiceImpl.findById(red.getId());
            UsuarioDTO usuario = usuarioServiceImpl.findById(red.getUsuarioId());

            usuario.setSituacao("BANIDO");
            usuario.setObservacao("Usuário BANIDO - Não Poderá Realizar Reservas ou Empréstimos");
            reservaEmprestimoDevolucaoServiceImpl.updateSituacaoUsuario(usuario);

            reservaEmprestimoDevolucaoDTO.setSituacao("PERDIDO");
            reservaEmprestimoDevolucaoServiceImpl.updateSituacaoReservaEmprestimoDevolucao(reservaEmprestimoDevolucaoDTO);
        }
    }

    @Scheduled(cron="0 0 1 * * *", zone="America/Sao_Paulo")
    public void atualizaSituacaoUsuarioEmAtrasoParaOk() {
        List<ReservaEmprestimoDevolucaoDTO> reservaEmprestimoDevolucao = reservaEmprestimoDevolucaoServiceImpl.listaUsuariosIrregularesApos30DiadDePunicao();

        for (ReservaEmprestimoDevolucaoDTO red : reservaEmprestimoDevolucao) {
            UsuarioDTO usuario = usuarioServiceImpl.findById(red.getUsuarioId());

            usuario.setSituacao("OK");
            usuario.setObservacao("Usuário OK - Devoluções no Prazo Correto");
            reservaEmprestimoDevolucaoServiceImpl.updateSituacaoUsuario(usuario);
        }
    }

}
