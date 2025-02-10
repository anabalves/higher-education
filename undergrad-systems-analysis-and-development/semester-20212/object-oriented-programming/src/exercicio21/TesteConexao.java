package exercicio21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TesteConexao {
	
    private static final String DBURL = "jdbc:mysql://localhost:3306/petdb";
    private static final String DBUSER = "root";
    private static final String DBPASS= "Aeic19202527";

    public static void main(String[] args) throws Exception {
    	
        System.out.println("Teste de conexão em DB");
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Classe de conexao carregada");
        Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        System.out.println("Conectado no banco de dados");

//        String sql = "INSERT INTO pet (id, nome, raca, peso, nascimento) " +
//                "VALUES (1, 'Garu', 'Siamês', 5.36, '2019-04-27')";
//
//        PreparedStatement stmt = con.prepareStatement(sql);
//        stmt.executeUpdate();

        String sql = "SELECT * FROM pet";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while(rs.next()) {
        	System.out.println("\nId: " + rs.getInt("id") + "\nNome: " + rs.getString("nome") + "\nRaça: " 
                	+ rs.getString("raca") + "\nPeso: " + rs.getDouble("peso") + "\nNascimento: " + rs.getDate("nascimento"));
        }

        con.close();
    }
    
}