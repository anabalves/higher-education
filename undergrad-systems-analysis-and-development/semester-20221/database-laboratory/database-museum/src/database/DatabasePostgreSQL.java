package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabasePostgreSQL implements Database {

    private static Connection connection;
    private static String HOST = "localhost";
    private static int PORTA = 5432;
    private static String DB_NOME = "database-museum";
    private static String USERNAME = "postgres";
    private static String SENHA = "1234567";

    @Override
    public Connection conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(String.format("jdbc:postgresql://%s:%d/%s", HOST, PORTA, DB_NOME), USERNAME, SENHA);
            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("O driver expecificado nao foi encontrado.");
            Logger.getLogger(DatabasePostgreSQL.class.getName()).log(Level.SEVERE, null, e);
            return null;
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            Logger.getLogger(DatabasePostgreSQL.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public void desconectar(Connection connection) {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabasePostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
