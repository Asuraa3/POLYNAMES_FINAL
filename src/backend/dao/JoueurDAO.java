package backend.dao;

import backend.models.Joueur;
import database.PolyNamesDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JoueurDAO {
    private PolyNamesDatabase database;

    public JoueurDAO(PolyNamesDatabase database) {
        this.database = database;
    }

    public boolean addJoueur(Joueur joueur) {
        try (Connection conn = database.getConnection()) {
            String sql = "INSERT INTO joueurs (nom) VALUES (?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, joueur.getNom());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
