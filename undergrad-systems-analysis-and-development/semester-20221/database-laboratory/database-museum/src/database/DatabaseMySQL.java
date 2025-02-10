package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseMySQL implements Database {

    private static Connection connection;
    private static String HOST = "localhost";
    private static int PORTA = 3306;
    private static String DB_NOME = "database-museum";
    private static String USERNAME = "root";
    private static String SENHA = "1234567";

    @Override
    public Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s", HOST, PORTA, DB_NOME), USERNAME, SENHA);
            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("O driver expecificado nao foi encontrado.");
            Logger.getLogger(DatabaseMySQL.class.getName()).log(Level.SEVERE, null, e);
            return null;
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            Logger.getLogger(DatabaseMySQL.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public void desconectar(Connection connection) {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
