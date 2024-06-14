package backend.dao;

import backend.models.Partie;
import database.PolyNamesDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PartieDAO {
    private final PolyNamesDatabase database;

    public PartieDAO(PolyNamesDatabase database) {
        this.database = database;
    }

    public int createPartie() throws SQLException {
        Connection connection = database.getConnection();
        String query = "INSERT INTO partie (ScoreFinal) VALUES (0)";
        PreparedStatement stmt = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return -1;
    }

    public Partie getPartie(int id) throws SQLException {
        Connection connection = database.getConnection();
        String query = "SELECT Id, ScoreFinal FROM partie WHERE Id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return new Partie(
                    rs.getInt("Id"),
                    rs.getInt("ScoreFinal")
            );
        }
        return null;
    }

    public boolean updatePartie(Partie partie) throws SQLException {
        Connection connection = database.getConnection();
        String query = "UPDATE partie SET ScoreFinal = ? WHERE Id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, partie.getScoreFinal());
        stmt.setInt(2, partie.getId());
        int rowsAffected = stmt.executeUpdate();
        return rowsAffected > 0;
    }

    public boolean deletePartie(int id) throws SQLException {
        Connection connection = database.getConnection();
        String query = "DELETE FROM partie WHERE Id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, id);
        int rowsAffected = stmt.executeUpdate();
        return rowsAffected > 0;
    }

}
