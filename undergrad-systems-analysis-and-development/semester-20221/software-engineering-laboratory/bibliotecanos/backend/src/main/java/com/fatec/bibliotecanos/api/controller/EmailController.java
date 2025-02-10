package com.fatec.bibliotecanos.api.controller;

import com.fatec.bibliotecanos.api.dto.ReservaEmprestimoDevolucaoDTO;
import com.fatec.bibliotecanos.api.dto.LivroDTO;
import com.fatec.bibliotecanos.api.dto.UsuarioDTO;
import com.fatec.bibliotecanos.domain.service.EmailServiceImpl;
import com.fatec.bibliotecanos.domain.service.ReservaEmprestimoDevolucaoServiceImpl;
import com.fatec.bibliotecanos.domain.service.LivroServiceImpl;
import com.fatec.bibliotecanos.domain.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Configuration
@EnableScheduling
public class EmailController {

    @Autowired
    EmailServiceImpl emailService;

    @Autowired
    private ReservaEmprestimoDevolucaoServiceImpl reservaEmprestimoDevolucaoServiceImpl;

    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    @Autowired
    private LivroServiceImpl livroServiceImpl;

    @Scheduled(cron="0 0 8 * * *", zone="America/Sao_Paulo")
    public void sendMail() {
        List<ReservaEmprestimoDevolucaoDTO> usuariosComDevolucaoEmDoisDias = reservaEmprestimoDevolucaoServiceImpl.findAllUsuarioIdComDevolucaoEmDoisDias();

        for (ReservaEmprestimoDevolucaoDTO emprestimoDevolucao : usuariosComDevolucaoEmDoisDias) {
            UsuarioDTO usuario = usuarioServiceImpl.findById(emprestimoDevolucao.getUsuarioId());
            LivroDTO livro = livroServiceImpl.findById(emprestimoDevolucao.getLivroId());
            emailService.sendMail(
                    usuario.getEmail(),
                    "Olá " + usuario.getNome() + "!\n\nEstamos enviando esse e-mail para te lembrar que faltam apenas 2 dias para o vencimento do seu empréstimo do livro " + livro.getTitulo() + ".\nFaça a devolucação para que sua situação não se torne irregular, impossibilitando a realização de empréstimos por 30 dias.\n\nDesejamos uma ótima semana ;) \n\nAtenciosamente,\nEquipe Bibliotecanos",
                    usuario.getNome() + " seu Empréstimo vence em 2 dias!!");
        }
    }

}
