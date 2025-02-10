package database;

import java.sql.Connection;

public interface Database {

    Connection conectar();
    void desconectar(Connection connection);

}
