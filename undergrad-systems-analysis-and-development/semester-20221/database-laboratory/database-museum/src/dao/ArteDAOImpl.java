package dao;

import model.Arte;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArteDAOImpl implements ArteDAO {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean inserir(Arte arte) {
        String sql = "INSERT INTO `TB_ARTE`(`NOME_OBRA`, `NOME_ARTISTA`, `DATA_CRIACAO`,`DESCRICAO`) VALUES (?, ?, ?, ?);";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, arte.getNomeObra());
            stmt.setString(2, arte.getNomeArtista());
            stmt.setDate(3, java.sql.Date.valueOf(arte.getDataCriacao()));
            stmt.setString(4, arte.getDescricao());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ArteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean alterar(Long id, Arte arte) {
        String sql = "UPDATE `TB_ARTE` SET `NOME_OBRA`=?, `NOME_ARTISTA`=?, `DATA_CRIACAO`=?,`DESCRICAO`=? WHERE `ID`=?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, arte.getNomeObra());
            stmt.setString(2, arte.getNomeArtista());
            stmt.setDate(3, java.sql.Date.valueOf(arte.getDataCriacao()));
            stmt.setString(4, arte.getDescricao());
            stmt.setLong(5, id);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ArteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean deletar(Long id) {
        String sql = "DELETE FROM `TB_ARTE` WHERE `ID`=?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ArteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<Arte> listar() {
        String sql = "SELECT `ID`,`NOME_OBRA`, `NOME_ARTISTA`, `DATA_CRIACAO`,`DESCRICAO` FROM `TB_ARTE`;";
        List<Arte> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Arte arte = new Arte();
                arte.setId(resultado.getLong("ID"));
                arte.setNomeObra(resultado.getString("NOME_OBRA"));
                arte.setNomeArtista(resultado.getString("NOME_ARTISTA"));
                arte.setDataCriacao(resultado.getDate("DATA_CRIACAO").toLocalDate());
                arte.setDescricao(resultado.getString("DESCRICAO"));
                retorno.add(arte);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @Override
    public Arte buscar(String nomeObra) {
        String sql = "SELECT `ID`,`NOME_OBRA`, `NOME_ARTISTA`, `DATA_CRIACAO`,`DESCRICAO` FROM `TB_ARTE` WHERE LOWER(`NOME_OBRA`) LIKE LOWER(?);";
        Arte arte = new Arte();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%" + nomeObra + "%");
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                arte.setId(resultado.getLong("ID"));
                arte.setNomeObra(resultado.getString("NOME_OBRA"));
                arte.setNomeArtista(resultado.getString("NOME_ARTISTA"));
                arte.setDataCriacao(resultado.getDate("DATA_CRIACAO").toLocalDate());
                arte.setDescricao(resultado.getString("DESCRICAO"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arte;
    }

}
