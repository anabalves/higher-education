package com.fatec.bibliotecanos.domain.service;

import com.fatec.bibliotecanos.api.dto.ReservaEmprestimoDevolucaoDTO;
import com.fatec.bibliotecanos.api.dto.response.RelatorioAtrasosResponse;
import com.fatec.bibliotecanos.api.dto.response.RelatorioEmprestimosResponse;
import com.fatec.bibliotecanos.api.dto.response.RelatorioSaidaResponse;
import com.fatec.bibliotecanos.api.dto.response.RelatorioUsuariosResponse;
import com.fatec.bibliotecanos.domain.model.ReservaEmprestimoDevolucao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReservaEmprestimoDevolucaoService {

    ReservaEmprestimoDevolucaoDTO realizarReserva(ReservaEmprestimoDevolucaoDTO dto);
    ReservaEmprestimoDevolucao realizarEmprestimoByDevolucao(ReservaEmprestimoDevolucaoDTO dto);
    ReservaEmprestimoDevolucaoDTO realizarEmprestimo(ReservaEmprestimoDevolucaoDTO dto);
    ReservaEmprestimoDevolucaoDTO realizarDevolucao(Long id, ReservaEmprestimoDevolucaoDTO dto);
    ReservaEmprestimoDevolucaoDTO realizarCancelamento(Long id, ReservaEmprestimoDevolucaoDTO dto);
    ReservaEmprestimoDevolucaoDTO findById(Long id);
    Page<ReservaEmprestimoDevolucaoDTO> findAll(Pageable pageable);
    List<ReservaEmprestimoDevolucaoDTO> findByUsuarioId(Long usuarioId);
    List<RelatorioUsuariosResponse> relatorioUsuarios();
    List<RelatorioSaidaResponse> relatorioSaida();
    List<RelatorioAtrasosResponse> relatorioAtrasos();
    List<RelatorioEmprestimosResponse> relatorioEmprestimos();

}
