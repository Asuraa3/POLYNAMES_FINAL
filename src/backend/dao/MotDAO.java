package backend.dao;

import backend.models.Mot;
import database.PolyNamesDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MotDAO {
    private final PolyNamesDatabase database;

    public MotDAO(PolyNamesDatabase database) {
        this.database = database;
    }

    public List<Mot> getRandomMots(int limit) throws SQLException {
        Connection connection = database.getConnection();
        String sql = "SELECT * FROM mot ORDER BY RAND() LIMIT ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, limit);
            ResultSet resultSet = statement.executeQuery();
            List<Mot> mots = new ArrayList<>();
            while (resultSet.next()) {
                mots.add(new Mot(resultSet.getInt("id"), resultSet.getString("texteMot")));
            }
            return mots;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error when retrieving random mots: " + e.getMessage());
            return null;
        }
    }
}
