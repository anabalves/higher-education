package dao;

import model.Reserva;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ReservaDAO {

    boolean inserir(Reserva reserva);
    boolean alterar(Long id, Reserva reserva);
    boolean deletar(Long id);
    List<Reserva> listar();
    Reserva buscar(String nome);

    Map<Integer, ArrayList> listarQuantidadeVisitasPorMes();


}
