import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class SetRequestFriend {

    public static void main(String[] args) throws IOException {
        testCase1();
        testCase2();
        testCase3();
        testCase4();
    }

    private static void testCase1() throws IOException {
        System.out.println("Test case 1: Tự gửi chính mình");
        ResponseData res = Login.login();
        String token = res.getData().getToken();
//        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjVmYmZkNmMyYThmZGY4MzhmNDgwZGMwMCIsImRhdGVMb2dpbiI6IjIwMjAtMTItMDZUMDk6MzU6MjEuNTU1WiIsImlhdCI6MTYwNzI0NzMyMSwiZXhwIjoxNjA3MzMzNzIxfQ.-2hTWpQ-Xd8tEzsgYBM19anCipfK2qhCRK3MrbBcfuk";
        String userId = "5fcadc49eb6dab2094ebf067";
        System.out.println("token: " + token);
        System.out.println("user_id: " + userId);
        ResponseData responseData = setRequestFriend(token, userId);
        responseData.printResponseData();
    }

    private static void testCase2() throws IOException {
        System.out.println("Test case 2: Sai user_id");
        ResponseData res = Login.login();
        String token = res.getData().getToken();
//        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjVmYmZkNmMyYThmZGY4MzhmNDgwZGMwMCIsImRhdGVMb2dpbiI6IjIwMjAtMTItMDZUMDk6MzU6MjEuNTU1WiIsImlhdCI6MTYwNzI0NzMyMSwiZXhwIjoxNjA3MzMzNzIxfQ.-2hTWpQ-Xd8tEzsgYBM19anCipfK2qhCRK3MrbBcfuk";
        String userId = "5fcadc49eb6dab2094ebf068";
        System.out.println("token: " + token);
        System.out.println("user_id: " + userId);
        ResponseData responseData = setRequestFriend(token, userId);
        responseData.printResponseData();
    }

    private static void testCase3() throws IOException {
        System.out.println("Test case 3: Success");
        ResponseData res = Login.login();
        String token = res.getData().getToken();
//        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjVmYmZkNmMyYThmZGY4MzhmNDgwZGMwMCIsImRhdGVMb2dpbiI6IjIwMjAtMTItMDZUMDk6MzU6MjEuNTU1WiIsImlhdCI6MTYwNzI0NzMyMSwiZXhwIjoxNjA3MzMzNzIxfQ.-2hTWpQ-Xd8tEzsgYBM19anCipfK2qhCRK3MrbBcfuk";
        String userId = "5fcadc49eb6dab2094ebf068";
        System.out.println("token: " + token);
        System.out.println("user_id: " + userId);
        ResponseData responseData = setRequestFriend(token, userId);
        responseData.printResponseData();
    }

    private static void testCase4() throws IOException {
        System.out.println("Test case 4: Send 2 lần");
        ResponseData res = Login.login();
        String token = res.getData().getToken();
//        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjVmYmZkNmMyYThmZGY4MzhmNDgwZGMwMCIsImRhdGVMb2dpbiI6IjIwMjAtMTItMDZUMDk6MzU6MjEuNTU1WiIsImlhdCI6MTYwNzI0NzMyMSwiZXhwIjoxNjA3MzMzNzIxfQ.-2hTWpQ-Xd8tEzsgYBM19anCipfK2qhCRK3MrbBcfuk";
        String userId = "5fcadc49eb6dab2094ebf068";
        System.out.println("token: " + token);
        System.out.println("user_id: " + userId);
        ResponseData responseData = setRequestFriend(token, userId);
        responseData.printResponseData();
    }

    public static ResponseData setRequestFriend(String token, String userId) throws IOException {
        URL url = new URL(Constant.SET_REQUEST_FRIEND +
                "?token=" + token +
                "&user_id=" + userId);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        System.out.println(url);
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        try (DataOutputStream writer = new DataOutputStream(connection.getOutputStream())) {
            StringBuilder content;
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                content = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            } catch (IOException e){
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                String line;
                content = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }
            System.out.println("JSON response: " + content.toString());
            Gson g = new Gson();
            return g.fromJson(content.toString(), ResponseData.class);
        } finally {
            connection.disconnect();
        }
    }
}
