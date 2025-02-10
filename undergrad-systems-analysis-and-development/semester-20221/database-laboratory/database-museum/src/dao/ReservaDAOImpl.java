package dao;

import model.Reserva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReservaDAOImpl implements ReservaDAO {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean inserir(Reserva reserva) {
        String sql = "INSERT INTO `TB_RESERVA`(`NOME`, `CPF`, `TELEFONE`, `QUANTIDADE_PESSOAS`, `DATA_RESERVA`, `HORA_INICIO`) VALUES (?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, reserva.getNome());
            stmt.setString(2, reserva.getCpf());
            stmt.setString(3, reserva.getTelefone());
            stmt.setInt(4, reserva.getQuantidadePessoas());
            stmt.setDate(5, java.sql.Date.valueOf(reserva.getDataReserva()));
            stmt.setString(6, reserva.getHoraInicio());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean alterar(Long id, Reserva reserva) {
        String sql = "UPDATE `TB_RESERVA` SET `NOME`=?, `CPF`=?, `TELEFONE`=?, `QUANTIDADE_PESSOAS`=?, `DATA_RESERVA`=?, `HORA_INICIO`=? WHERE `ID`=?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, reserva.getNome());
            stmt.setString(2, reserva.getCpf());
            stmt.setString(3, reserva.getTelefone());
            stmt.setInt(4, reserva.getQuantidadePessoas());
            stmt.setDate(5, java.sql.Date.valueOf(reserva.getDataReserva()));
            stmt.setString(6, reserva.getHoraInicio());
            stmt.setLong(7, id);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean deletar(Long id) {
        String sql = "DELETE FROM `TB_RESERVA` WHERE `ID`=?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<Reserva> listar() {
        String sql = "SELECT `ID`, `NOME`, `CPF`, `TELEFONE`, `QUANTIDADE_PESSOAS`, `DATA_RESERVA`, `HORA_INICIO` FROM `TB_RESERVA`;";
        List<Reserva> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Reserva reserva = new Reserva();
                reserva.setId(resultado.getLong("ID"));
                reserva.setNome(resultado.getString("NOME"));
                reserva.setCpf(resultado.getString("CPF"));
                reserva.setTelefone(resultado.getString("TELEFONE"));
                reserva.setQuantidadePessoas(resultado.getInt("QUANTIDADE_PESSOAS"));
                reserva.setDataReserva(resultado.getDate("DATA_RESERVA").toLocalDate());
                reserva.setHoraInicio(resultado.getString("HORA_INICIO"));
                retorno.add(reserva);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @Override
    public Reserva buscar(String nome) {
        String sql = "SELECT `ID`, `NOME`, `CPF`, `TELEFONE`, `QUANTIDADE_PESSOAS`, `DATA_RESERVA`, `HORA_INICIO` FROM `TB_RESERVA` WHERE LOWER(`NOME`) LIKE LOWER(?);";
        Reserva reserva = new Reserva();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%");
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                reserva.setId(resultado.getLong("ID"));
                reserva.setNome(resultado.getString("NOME"));
                reserva.setCpf(resultado.getString("CPF"));
                reserva.setTelefone(resultado.getString("TELEFONE"));
                reserva.setQuantidadePessoas(resultado.getInt("QUANTIDADE_PESSOAS"));
                reserva.setDataReserva(resultado.getDate("DATA_RESERVA").toLocalDate());
                reserva.setHoraInicio(resultado.getString("HORA_INICIO"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reserva;
    }

    @Override
    public Map<Integer, ArrayList> listarQuantidadeVisitasPorMes() {
        String sql = "CALL GRAFICO_QUANTIDADE_VISITAS_POR_MES();";
        Map<Integer, ArrayList> retorno = new HashMap();

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                ArrayList linha = new ArrayList();
                if (!retorno.containsKey(resultado.getInt("ANO"))) {
                    linha.add(resultado.getInt("MES"));
                    linha.add(resultado.getInt("QUANTIDADE_PESSOAS_POR_MES"));
                    retorno.put(resultado.getInt("ANO"), linha);
                } else {
                    ArrayList linhaNova = retorno.get(resultado.getInt("ANO"));
                    linhaNova.add(resultado.getInt("MES"));
                    linhaNova.add(resultado.getInt("QUANTIDADE_PESSOAS_POR_MES"));
                }
            }
            return retorno;
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

}
