package Persistency.Factory;

import Persistency.Connection;
import Persistency.MySQLConnection;

public class MySQLConnectionFactory implements ConnectionFactory {

    @Override
    public Connection getConnection() {
        return new MySQLConnection();
    }

}