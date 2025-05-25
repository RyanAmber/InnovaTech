import static spark.Spark.*;
import com.google.gson.*;
import java.util.*;

public class WebServer {
    public static void main(String[] args) {
        port(4567);

        // Allow requests from anywhere (CORS)
        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Request-Method", "*");
            response.header("Access-Control-Allow-Headers", "*");
            response.type("application/json");
        });

        // Route to handle login
        post("/api/signin", (req, res) -> {
            res.type("application/json");
            Gson gson = new Gson();

            Map<String, String> body = gson.fromJson(req.body(), Map.class);
            String username = body.get("username");
            String password = body.get("password");

            // Fake hardcoded credentials
            if ("user@example.com".equals(username) && "password123".equals(password)) {
                return gson.toJson(Map.of("success", true, "role", "Student"));
            } else {
                return gson.toJson(Map.of("success", false));
            }
        });
    }
}
