package backend.controllers;

import backend.dao.MotDAO;
import backend.models.Mot;
import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.List;

public class MotController implements HttpHandler {
    private static final Gson gson = new Gson();
    private final MotDAO motDAO;

    public MotController(MotDAO motDAO) {
        this.motDAO = motDAO;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if ("GET".equals(exchange.getRequestMethod())) {
            try {
                List<Mot> mots = motDAO.getRandomMots(25);
                if (mots == null || mots.isEmpty()) {
                    System.out.println("No mots found");
                    exchange.sendResponseHeaders(500, -1);
                    return;
                }
                String response = gson.toJson(mots);
                System.out.println("Response: " + response);
                exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
                exchange.sendResponseHeaders(200, response.getBytes(StandardCharsets.UTF_8).length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes(StandardCharsets.UTF_8));
                os.close();
            } catch (SQLException e) {
                e.printStackTrace();
                exchange.sendResponseHeaders(500, -1);
            }
        } else {
            exchange.sendResponseHeaders(405, -1);
        }
    }
}

