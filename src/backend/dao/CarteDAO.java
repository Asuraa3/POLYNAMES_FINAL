package backend.dao;

import backend.models.Carte;
import database.PolyNamesDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CarteDAO {
    private final PolyNamesDatabase database;

    public CarteDAO(PolyNamesDatabase database) {
        this.database = database;
    }

    public boolean insertCartes(List<Carte> cartes) throws SQLException {
        Connection connection = database.getConnection();
        String sql = "INSERT INTO carte (idMot, idPartie, idCouleur) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (Carte carte : cartes) {
                statement.setInt(1, carte.getIdMot());
                statement.setInt(2, carte.getIdPartie());
                statement.setInt(3, carte.getIdCouleur());
                statement.addBatch();
            }
            int[] affectedRows = statement.executeBatch();
            return affectedRows.length == cartes.size();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error when inserting Cartes: " + e.getMessage());
            return false;
        }
    }
}
