import static spark.Spark.*;
import com.google.gson.*;
import java.io.*;
import java.util.*;

public class WebServer {
    public static void main(String[] args) {
        port(4567);

        post("/api/signin", (req, res) -> {
            Gson gson = new Gson();
            Map<String, String> body = gson.fromJson(req.body(), Map.class);

            String username = body.get("username");
            String password = body.get("password");

            Map<String, String[]> users = MainPage.readUserData();
            String[] userInfo = users.get(username);

            res.type("application/json");

            if (userInfo == null || !userInfo[0].equals(password)) {
                return gson.toJson(Map.of("success", false));
            }

            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("role", userInfo[1]);

            if ("Student".equals(userInfo[1])) {
                response.put("group", 5); // Example group number
            }

            return gson.toJson(response);
        });
    }
}
