package exercicio22.aluno;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAOImpl implements AlunoDAO {
	private static final String DBURL = "jdbc:mysql://localhost:3306/alunocursodb?allowMultiQueries=true";
	private static final String DBUSER = "root";
	private static final String DBPASS= "Aeic19202527";

	public AlunoDAOImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void adicionar(Aluno a) {
		try {
			Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);

			String sql = "INSERT INTO tbl_aluno (ra, nome, nascimento)  " +
					"VALUES (?, ?, ?)";
			System.out.println(sql);
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, a.getRa());
			stmt.setString(2, a.getNome());
			stmt.setDate(3, java.sql.Date.valueOf(a.getNascimento()));
			stmt.executeUpdate();

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Aluno> pesquisarPorNome(String nome) {
		List<Aluno> encontrados = new ArrayList<>();
		try {
			Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);

			String sql = "SELECT * FROM tbl_aluno WHERE nome like '%" + nome + "%'";
			System.out.println(sql);

			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {

				Aluno a = new Aluno();
				a.setId( rs.getLong("id") );
				a.setRa( rs.getString("ra") );
				a.setNome( rs.getString("nome") );
				a.setNascimento( rs.getDate("nascimento").toLocalDate() );
				encontrados.add(a);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return encontrados;
	}

	@Override
	public void atualizar(long id, Aluno a) {
        try (Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS)) {
            String sql = "UPDATE tbl_aluno SET ra = ?, nome = ?," +
                    "nascimento = ? WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, a.getRa());
            stmt.setString(2, a.getNome());
            stmt.setDate(3, java.sql.Date.valueOf(a.getNascimento()));
            stmt.setLong(4, id);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void remover(long id) {
		try (Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS)) {
			String sql = "DELETE FROM tbl_aluno WHERE id = ?";
			System.out.println(sql);
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
