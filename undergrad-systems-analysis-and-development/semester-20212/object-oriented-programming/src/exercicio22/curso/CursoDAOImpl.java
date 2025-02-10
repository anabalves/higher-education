package exercicio22.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAOImpl implements CursoDAO {
	private static final String DBURL = "jdbc:mysql://localhost:3306/alunocursodb?allowMultiQueries=true";
	private static final String DBUSER = "root";
	private static final String DBPASS= "Aeic19202527";

	public CursoDAOImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void adicionar(Curso c) {
		try {
			Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);

			String sql = "INSERT INTO tbl_curso (nome, descricao, ativo, inicio, termino)  " +
					"VALUES (?, ?, ?, ?, ?)";
			System.out.println(sql);
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getDescricao());
			stmt.setBoolean(3, c.getAtivo());
			stmt.setDate(4, java.sql.Date.valueOf(c.getInicio()));
			stmt.setDate(5, java.sql.Date.valueOf(c.getTermino()));
			stmt.executeUpdate();

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Curso> pesquisarPorNome(String nome) {
		List<Curso> encontrados = new ArrayList<>();
		try {
			Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);

			String sql = "SELECT * FROM tbl_curso WHERE nome like '%" + nome + "%'";
			System.out.println(sql);

			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {

				Curso c = new Curso();
				c.setId( rs.getLong("id") );
				c.setNome( rs.getString("nome") );
				c.setDescricao( rs.getString("descricao") );
				c.setAtivo( rs.getBoolean("ativo") );
				c.setInicio( rs.getDate("inicio").toLocalDate() );
				c.setTermino( rs.getDate("termino").toLocalDate() );
				encontrados.add(c);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return encontrados;
	}

	@Override
	public void atualizar(long id, Curso c) {
        try (Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS)) {
            String sql = "UPDATE tbl_curso SET nome = ?, descricao = ?," +
                    "ativo = ?, inicio = ?, termino = ? WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getDescricao());
            stmt.setBoolean(3, c.getAtivo());
            stmt.setDate(4, java.sql.Date.valueOf(c.getInicio()));
            stmt.setDate(5, java.sql.Date.valueOf(c.getTermino()));
            stmt.setLong(6, id);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void remover(long id) {
		try (Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS)) {
			String sql = "DELETE FROM tbl_curso WHERE id = ?";
			System.out.println(sql);
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
