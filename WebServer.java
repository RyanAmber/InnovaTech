import static spark.Spark.*;
import com.google.gson.*;
import java.util.*;

public class WebServer {
    public static void main(String[] args) {
        port(4567);

        // Allow requests from anywhere (CORS)
        before((req, res) -> {
            res.header("Access-Control-Allow-Origin", "*");
            res.header("Access-Control-Allow-Methods", "GET,POST");
            res.header("Access-Control-Allow-Headers", "Content-Type");
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
