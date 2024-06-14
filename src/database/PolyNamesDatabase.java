package database;
import java.sql.SQLException;



public class PolyNamesDatabase extends MySQLDatabase {
    private static PolyNamesDatabase instance;

    public PolyNamesDatabase(String host, int port, String databaseName, String user, String password) throws SQLException {
        super(host, port, databaseName, user, password);
    }

    public static PolyNamesDatabase getInstance(String host, int port, String databaseName, String user, String password) throws SQLException {
        if (instance == null) {
            instance = new PolyNamesDatabase(host, port, databaseName, user, password);
        }
        return instance;
    }

}
