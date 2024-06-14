import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 3306;
        String databaseName = "poly_names";
        String user = "root";
        String password = "";

        Connection connection = null;

        try {
            // Chargement du driver JDBC MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // URL de connexion
            String url = String.format("jdbc:mysql://%s:%d/%s", host, port, databaseName);

            // Établissement de la connexion
            connection = DriverManager.getConnection(url, user, password);

            // Vérification de la connexion
            if (connection != null) {
                System.out.println("Connexion à la base de données établie avec succès !");
            } else {
                System.out.println("Échec de la connexion à la base de données.");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC non trouvé : " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Erreur de connexion à la base de données : " + e.getMessage());
        } finally {
            // Fermeture de la connexion
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Connexion fermée.");
                } catch (SQLException e) {
                    System.err.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
                }
            }
        }
    }
}

