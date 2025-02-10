package com.fatec.bibliotecanos.domain.service;

import com.fatec.bibliotecanos.api.dto.UsuarioDTO;
import com.fatec.bibliotecanos.api.dto.response.*;
import com.fatec.bibliotecanos.domain.model.ReservaEmprestimoDevolucao;
import com.fatec.bibliotecanos.domain.model.Livro;
import com.fatec.bibliotecanos.domain.model.Usuario;
import com.fatec.bibliotecanos.api.dto.ReservaEmprestimoDevolucaoDTO;
import com.fatec.bibliotecanos.domain.exception.ResourceNotFoundException;
import com.fatec.bibliotecanos.domain.model.enums.ELivro;
import com.fatec.bibliotecanos.domain.model.enums.EReservaEmprestimoDevolucao;
import com.fatec.bibliotecanos.domain.model.enums.EUsuario;
import com.fatec.bibliotecanos.domain.repository.ReservaEmprestimoDevolucaoRepository;
import com.fatec.bibliotecanos.domain.repository.LivroRepository;
import com.fatec.bibliotecanos.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReservaEmprestimoDevolucaoServiceImpl implements ReservaEmprestimoDevolucaoService {

    @Autowired
    private ReservaEmprestimoDevolucaoRepository reservaEmprestimoDevolucaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public ReservaEmprestimoDevolucaoDTO realizarReserva(ReservaEmprestimoDevolucaoDTO dto) {
        ReservaEmprestimoDevolucaoDTO redReservadoByUsuarioId = findREDReservadoByUsuarioId(dto.getUsuarioId());
        ReservaEmprestimoDevolucaoDTO redEmDiaByUsuarioId = findREDEmDiaByUsuarioId(dto.getUsuarioId());
        Livro livro = livroRepository.getOne(dto.getLivroId());
        Usuario usuario = usuarioRepository.getOne(dto.getUsuarioId());

        ReservaEmprestimoDevolucao entity = new ReservaEmprestimoDevolucao();

        if (usuario.getSituacao().equals(EUsuario.BANIDO) || usuario.getSituacao().equals(EUsuario.IRREGULAR)) {
            entity = null;
        } else if (redReservadoByUsuarioId != null || redEmDiaByUsuarioId != null) {
            entity = null;
        } else if (livro.getStatus().equals(ELivro.INDISPONIVEL)) {
            entity = null;
        } else {
            copyDtoToEntity(dto, entity);
            entity.setDataEmprestimo(dto.getDataEmprestimo());
            entity.setSituacao(EReservaEmprestimoDevolucao.RESERVADO);
            LocalDate localDate = entity.getDataEmprestimo();
            entity.setDataDevolucao(localDate.plusDays(30));

            entity = reservaEmprestimoDevolucaoRepository.save(entity);

            livro.setQuantidade(livro.getQuantidade() - 1);
        }
        return new ReservaEmprestimoDevolucaoDTO(entity);
    }

    @Override
    public ReservaEmprestimoDevolucaoDTO realizarEmprestimo(ReservaEmprestimoDevolucaoDTO dto) {
        ReservaEmprestimoDevolucaoDTO redReservadoByUsuarioId = findREDReservadoByUsuarioId(dto.getUsuarioId());
        ReservaEmprestimoDevolucaoDTO redEmDiaByUsuarioId = findREDEmDiaByUsuarioId(dto.getUsuarioId());
        Livro livro = livroRepository.getOne(dto.getLivroId());
        Usuario usuario = usuarioRepository.getOne(dto.getUsuarioId());

        ReservaEmprestimoDevolucao entity = new ReservaEmprestimoDevolucao();

        if (usuario.getSituacao().equals(EUsuario.BANIDO) || usuario.getSituacao().equals(EUsuario.IRREGULAR)) {
            entity = null;
        } else if (!(redEmDiaByUsuarioId == null)) {
            entity = null;
        } else if (livro.getStatus() == ELivro.INDISPONIVEL) {
            entity = null;
        } else if (redReservadoByUsuarioId != null) {
            entity = realizarEmprestimoByDevolucao(dto);
        } else {
            copyDtoToEntity(dto, entity);
            entity.setDataEmprestimo(LocalDate.now());
            entity.setSituacao(EReservaEmprestimoDevolucao.EM_DIA);
            LocalDate localDate = entity.getDataEmprestimo();
            entity.setDataDevolucao(localDate.plusDays(30));

            entity = reservaEmprestimoDevolucaoRepository.save(entity);

            livro.setQuantidade(livro.getQuantidade() - 1);
        }
        return new ReservaEmprestimoDevolucaoDTO(entity);
    }

    @Override
    public ReservaEmprestimoDevolucao realizarEmprestimoByDevolucao(ReservaEmprestimoDevolucaoDTO dto) {
        ReservaEmprestimoDevolucao entity;
        ReservaEmprestimoDevolucaoDTO redReservadoByUsuarioId = findREDReservadoByUsuarioId(dto.getUsuarioId());

        if (redReservadoByUsuarioId.getLivroId().equals(dto.getLivroId())) {
            entity = reservaEmprestimoDevolucaoRepository.getOne(redReservadoByUsuarioId.getId());
            copyDtoToEntity(dto, entity);
            entity.setDataEmprestimo(LocalDate.now());
            entity.setSituacao(EReservaEmprestimoDevolucao.EM_DIA);
            LocalDate localDate = entity.getDataEmprestimo();
            entity.setDataDevolucao(localDate.plusDays(30));
            entity = reservaEmprestimoDevolucaoRepository.save(entity);
        } else {
            entity = null;
        }

        return new ReservaEmprestimoDevolucao(entity);
    }

    @Override
    public ReservaEmprestimoDevolucaoDTO realizarDevolucao(Long id, ReservaEmprestimoDevolucaoDTO dto) {
        try {
            Livro livro = livroRepository.getOne(dto.getLivroId());
            ReservaEmprestimoDevolucao entity = reservaEmprestimoDevolucaoRepository.getOne(id);
            if (entity.getLivro().getId().equals(dto.getLivroId()) && (entity.getSituacao().equals(EReservaEmprestimoDevolucao.EM_DIA) || entity.getSituacao().equals(EReservaEmprestimoDevolucao.PERDIDO))) {
                copyDtoToEntity(dto, entity);
                entity.setDataEmprestimo(entity.getDataEmprestimo());
                entity.setDataDevolucao(LocalDate.now());
                entity.setSituacao(EReservaEmprestimoDevolucao.DEVOLVIDO);
                livro.setQuantidade(livro.getQuantidade() + 1);
                entity = reservaEmprestimoDevolucaoRepository.save(entity);
            } else {
                entity = null;
            }
            return new ReservaEmprestimoDevolucaoDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Empréstimo não encontrado " + id);
        }
    }

    @Override
    public ReservaEmprestimoDevolucaoDTO realizarCancelamento(Long id, ReservaEmprestimoDevolucaoDTO dto) {
        try {
            Livro livro = livroRepository.getOne(dto.getLivroId());
            ReservaEmprestimoDevolucao entity = reservaEmprestimoDevolucaoRepository.getOne(id);
            if (entity.getLivro().getId().equals(dto.getLivroId()) && entity.getSituacao().equals(EReservaEmprestimoDevolucao.RESERVADO)) {
                copyDtoToEntity(dto, entity);
                entity.setDataEmprestimo(entity.getDataEmprestimo());
                entity.setDataDevolucao(LocalDate.now());
                entity.setSituacao(EReservaEmprestimoDevolucao.CANCELADO);
                livro.setQuantidade(livro.getQuantidade() + 1);
                entity = reservaEmprestimoDevolucaoRepository.save(entity);
            } else {
                entity = null;
            }
            return new ReservaEmprestimoDevolucaoDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Reserva não encontrada " + id);
        }
    }

    @Override
    public ReservaEmprestimoDevolucaoDTO findById(Long id) {
        Optional<ReservaEmprestimoDevolucao> obj = reservaEmprestimoDevolucaoRepository.findById(id);
        ReservaEmprestimoDevolucao entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
        return new ReservaEmprestimoDevolucaoDTO(entity);
    }

    @Override
    public Page<ReservaEmprestimoDevolucaoDTO> findAll(Pageable pageable) {
        Page<ReservaEmprestimoDevolucao> list = reservaEmprestimoDevolucaoRepository.findAll(pageable);
        return list.map(ReservaEmprestimoDevolucaoDTO::new);
    }

    @Override
    public List<ReservaEmprestimoDevolucaoDTO> findByUsuarioId(Long usuarioId) {
        return jdbcTemplate.query("SELECT * FROM tb_emprestimo_devolucao WHERE usuario_id=?", BeanPropertyRowMapper.newInstance(ReservaEmprestimoDevolucaoDTO.class), usuarioId);
    }

    @Override
    public List<RelatorioUsuariosResponse> relatorioUsuarios() {
        return jdbcTemplate.query("SELECT \n" +
                "A.ID,\n" +
                "CONCAT(B.NOME, ' ', B.SOBRENOME) NOME_USUARIO,\n" +
                "C.TITULO,\n" +
                "A.SITUACAO,\n" +
                "A.DATA_EMPRESTIMO,\n" +
                "A.DATA_DEVOLUCAO\n" +
                "FROM tb_emprestimo_devolucao A, tb_usuario B, tb_livro C WHERE a.livro_id = c.id AND a.usuario_id = b.id AND a.situacao = 'EM_DIA' AND data_emprestimo = CURRENT_DATE - interval '1 day'",
                BeanPropertyRowMapper.newInstance(RelatorioUsuariosResponse.class));
    }

    @Override
    public List<RelatorioSaidaResponse> relatorioSaida() {
        return jdbcTemplate.query("SELECT\n" +
                "\tCOUNT(a.livro_id) saida,\n" +
                "\tb.TITULO\n" +
                "FROM \n" +
                "\ttb_emprestimo_devolucao a, \n" +
                "\ttb_livro b \n" +
                "WHERE \n" +
                "\ta.livro_id = b.id \n" +
                "GROUP BY \n" +
                "\tb.TITULO \n" +
                "ORDER BY \n" +
                "\tCOUNT(a.livro_id) DESC",
                BeanPropertyRowMapper.newInstance(RelatorioSaidaResponse.class));
    }

    @Override
    public List<RelatorioAtrasosResponse> relatorioAtrasos() {
        return jdbcTemplate.query("SELECT \n" +
                "A.ID,\n" +
                "CONCAT(B.NOME, ' ', B.SOBRENOME) nome_usuario,\n" +
                "C.TITULO,\n" +
                "A.SITUACAO,\n" +
                "A.DATA_EMPRESTIMO,\n" +
                "A.DATA_DEVOLUCAO\n" +
                "FROM tb_emprestimo_devolucao A, tb_usuario B, tb_livro C WHERE a.livro_id = c.id AND a.usuario_id = b.id AND a.situacao = 'EM_ATRASO'",
                BeanPropertyRowMapper.newInstance(RelatorioAtrasosResponse.class));
    }

    @Override
    public List<RelatorioEmprestimosResponse> relatorioEmprestimos() {
        return jdbcTemplate.query("SELECT \n" +
                "\tA.ID,\n" +
                "\tCONCAT(B.NOME, ' ', B.SOBRENOME) nome_usuario,\n" +
                "\tC.TITULO,\n" +
                "\tA.SITUACAO,\n" +
                "\tA.DATA_EMPRESTIMO,\n" +
                "\tA.DATA_DEVOLUCAO\n" +
                "FROM \n" +
                "\ttb_emprestimo_devolucao A, \n" +
                "\ttb_usuario B, \n" +
                "\ttb_livro C \n" +
                "WHERE \n" +
                "\ta.livro_id = c.id \n" +
                "AND \n" +
                "\ta.usuario_id = b.id \n" +
                "AND \n" +
                "\ta.situacao = 'EM_DIA'",
                BeanPropertyRowMapper.newInstance(RelatorioEmprestimosResponse.class));
    }

    public List<ReservaEmprestimoDevolucaoDTO> findAllUsuarioIdComDevolucaoEmDoisDias() {
        return jdbcTemplate.query("SELECT DISTINCT * FROM tb_emprestimo_devolucao WHERE data_devolucao = CURRENT_DATE + interval '2 day'",
                BeanPropertyRowMapper.newInstance(ReservaEmprestimoDevolucaoDTO.class));
    }

    public ReservaEmprestimoDevolucaoDTO findREDReservadoByUsuarioId(Long usuarioId) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM tb_emprestimo_devolucao WHERE usuario_id=? AND situacao = 'RESERVADO'", BeanPropertyRowMapper.newInstance(ReservaEmprestimoDevolucaoDTO.class), usuarioId);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public ReservaEmprestimoDevolucaoDTO findREDEmDiaByUsuarioId(Long usuarioId) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM tb_emprestimo_devolucao WHERE usuario_id=? AND situacao = 'EM_DIA'", BeanPropertyRowMapper.newInstance(ReservaEmprestimoDevolucaoDTO.class), usuarioId);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public List<ReservaEmprestimoDevolucaoDTO> listaUsuariosComUmDiaDeAtrasoDeDevolucao() {
        return jdbcTemplate.query("SELECT \n" +
                "id,\n" +
                "usuario_id\n" +
                "FROM \n" +
                "tb_emprestimo_devolucao \n" +
                "WHERE \n" +
                "data_devolucao = CURRENT_DATE - interval '1 day'\n" +
                "AND\n" +
                "situacao = 'EM_DIA'",
                BeanPropertyRowMapper.newInstance(ReservaEmprestimoDevolucaoDTO.class));
    }

    public List<ReservaEmprestimoDevolucaoDTO> listaUsuariosComQuinzeDiasDeAtrasoDeDevolucao() {
        return jdbcTemplate.query("SELECT \n" +
                "id,\n" +
                "usuario_id\n" +
                "FROM \n" +
                "tb_emprestimo_devolucao \n" +
                "WHERE \n" +
                "data_devolucao = CURRENT_DATE - interval '15 day'\n" +
                "AND\n" +
                "situacao = 'EM_ATRASO'",
                BeanPropertyRowMapper.newInstance(ReservaEmprestimoDevolucaoDTO.class));
    }

    public List<ReservaEmprestimoDevolucaoDTO> listaUsuariosIrregularesApos30DiadDePunicao() {
        return jdbcTemplate.query("SELECT\n" +
                "a.*\n" +
                "FROM \n" +
                "tb_emprestimo_devolucao a,\n" +
                "tb_usuario b\n" +
                "WHERE\n" +
                "a.usuario_id = b.id\n" +
                "AND\n" +
                "data_devolucao = CURRENT_DATE - interval '30 day'\n" +
                "AND\n" +
                "a.situacao = 'DEVOLVIDO'\n" +
                "AND\n" +
                "b.situacao = 'IRREGULAR'\n" +
                "AND\n" +
                "b.situacao = 'BANIDO'",
                BeanPropertyRowMapper.newInstance(ReservaEmprestimoDevolucaoDTO.class));
    }

    public void updateSituacaoUsuario(UsuarioDTO usuario) {
        jdbcTemplate.update("UPDATE tb_usuario SET situacao=?, observacao=? WHERE id=?",
                usuario.getSituacao(), usuario.getObservacao(), usuario.getId());
    }

    public void updateSituacaoReservaEmprestimoDevolucao(ReservaEmprestimoDevolucaoDTO reservaEmprestimoDevolucao) {
        jdbcTemplate.update("UPDATE tb_emprestimo_devolucao SET situacao=? WHERE id=?",
                reservaEmprestimoDevolucao.getSituacao(), reservaEmprestimoDevolucao.getId());
    }

    private void copyDtoToEntity(ReservaEmprestimoDevolucaoDTO dto, ReservaEmprestimoDevolucao entity) {
        Usuario usuario = usuarioRepository.getOne(dto.getUsuarioId());
        entity.setUsuario(usuario);

        Livro livro = livroRepository.getOne(dto.getLivroId());
        entity.setLivro(livro);
    }

}
