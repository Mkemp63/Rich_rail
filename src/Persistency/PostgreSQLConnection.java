package Persistency;

import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLConnection implements Connection {

    @Override
    public void connect() throws SQLException {
        DriverManager.getConnection("jdbc:postgresql://localhost:5432/Trains", "postgres", "Matthijs95");
    }

}