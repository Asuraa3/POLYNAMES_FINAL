package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDatabase {
    private final String host;
    private final int port;
    private final String databaseName;
    private final String user;
    private final String password;
    private Connection connection;

    public MySQLDatabase(String host, int port, String databaseName, String user, String password) throws SQLException {
        this.host = host;
        this.port = port;
        this.databaseName = databaseName;
        this.user = user;
        this.password = password;
        this.connect();
    }

    private void connect() throws SQLException {
        String url = String.format("jdbc:mysql://%s:%d/%s", this.host, this.port, this.databaseName);
        this.connection = DriverManager.getConnection(url, user, password);
    }

    public Connection getConnection() {
        return this.connection;
    }
}
