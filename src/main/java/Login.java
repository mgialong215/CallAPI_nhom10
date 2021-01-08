import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Login {
    public static ResponseData login() throws IOException {
        URL url = new URL("https://it4895-nhom5.herokuapp.com/it4788/auth/login?phonenumber=0123456700&password=123456");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//        System.out.println(url);
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        try (DataOutputStream writer = new DataOutputStream(connection.getOutputStream())) {
            StringBuilder content;
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {
                String line;
                content = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }
//            System.out.println("JSON response: " + content.toString());
            System.out.println("Login complete");
            Gson g = new Gson();
            return g.fromJson(content.toString(), ResponseData.class);
        } finally {
            connection.disconnect();
        }
    }
}
