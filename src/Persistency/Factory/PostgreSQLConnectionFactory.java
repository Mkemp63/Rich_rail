package Persistency.Factory;

import Persistency.Connection;
import Persistency.PostgreSQLConnection;

public class PostgreSQLConnectionFactory implements ConnectionFactory {

    @Override
    public Connection getConnection() {
        return new PostgreSQLConnection();
    }

}