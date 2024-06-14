package webserver;

import database.PolyNamesDatabase;
import backend.dao.MotDAO;
import backend.controllers.MotController;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.SQLException;
import java.util.List;
import backend.models.Mot;

public class WebServer {
    public static List<Mot> grille;

    public static void main(String[] args) throws IOException, SQLException {
        PolyNamesDatabase database = new PolyNamesDatabase("localhost", 3306, "poly_names", "root", "");
        MotDAO motDAO = new MotDAO(database);

        // Générer la grille une fois et la stocker
        grille = motDAO.getRandomMots(25);

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/getMots", new CorsHandler(new MotController(motDAO)));
        server.createContext("/getGrille", new CorsHandler(new GetGrilleHandler()));
        server.setExecutor(null);
        server.start();
        System.out.println("Server started on port 8080");
    }

    static class GetGrilleHandler implements com.sun.net.httpserver.HttpHandler {
        @Override
        public void handle(com.sun.net.httpserver.HttpExchange exchange) throws IOException {
            if ("GET".equals(exchange.getRequestMethod())) {
                com.google.gson.Gson gson = new com.google.gson.Gson();
                String response = gson.toJson(WebServer.grille);
                exchange.sendResponseHeaders(200, response.getBytes().length);
                try (java.io.OutputStream os = exchange.getResponseBody()) {
                    os.write(response.getBytes());
                }
            }
        }
    }
}
