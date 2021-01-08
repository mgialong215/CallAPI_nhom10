import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class SetAcceptFriend {

    public static void main(String[] args) throws IOException {
        testCase1();
        testcase2();
        testcase3();
        testcase4();
        testcase5();
        testcase6();
        testcase7();
    }

    private static void testCase1() throws IOException {
        System.out.println("Test case 1: Tự kết bạn");
        ResponseData res = Login.login();
        String token = res.getData().getToken();
//        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjVmYmZkNmMyYThmZGY4MzhmNDgwZGMwMCIsImRhdGVMb2dpbiI6IjIwMjAtMTItMDZUMDk6MzU6MjEuNTU1WiIsImlhdCI6MTYwNzI0NzMyMSwiZXhwIjoxNjA3MzMzNzIxfQ.-2hTWpQ-Xd8tEzsgYBM19anCipfK2qhCRK3MrbBcfuk";
        String userId = "5fcadc49eb6dab2094ebf067";
        Integer isAccept = 1;
        System.out.println("token: " + token);
        System.out.println("user_id: " + userId);
        System.out.println("is_accept: " + isAccept.toString());
        ResponseData responseData = setAcceptFriend(token, userId, isAccept);
        responseData.printResponseData();
    }

    private static void testcase2() throws IOException {
        System.out.println("Test case 2: Không có lời mời");
        ResponseData res = Login.login();
        String token = res.getData().getToken();
//        String token = "yJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjVmYmZkNmMyYThmZGY4MzhmNDgwZGMwMCIsImRhdGVMb2dpbiI6IjIwMjAtMTItMDZUMDk6MzU6MjEuNTU1WiIsImlhdCI6MTYwNzI0NzMyMSwiZXhwIjoxNjA3MzMzNzIxfQ.-2hTWpQ-Xd8tEzsgYBM19anCipfK2qhCRK3MrbBcfuk";
        String userId = "5fcadc4feb6dab2094ebf068";
        Integer isAccept = 1;
        System.out.println("token: " + token);
        System.out.println("user_id: " + userId);
        System.out.println("is_accept: " + isAccept.toString());
        ResponseData responseData = setAcceptFriend(token, userId, isAccept);
        responseData.printResponseData();
    }

    private static void testcase3() throws IOException {
        System.out.println("Test case 3: Success accept");
        ResponseData res = Login.login();
        String token = res.getData().getToken();
//        String token = "yJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjVmYmZkNmMyYThmZGY4MzhmNDgwZGMwMCIsImRhdGVMb2dpbiI6IjIwMjAtMTItMDZUMDk6MzU6MjEuNTU1WiIsImlhdCI6MTYwNzI0NzMyMSwiZXhwIjoxNjA3MzMzNzIxfQ.-2hTWpQ-Xd8tEzsgYBM19anCipfK2qhCRK3MrbBcfuk";
        String userId = "5fcadc4feb6dab2094ebf067";
        Integer isAccept = 1;
        System.out.println("token: " + token);
        System.out.println("user_id: " + userId);
        System.out.println("is_accept: " + isAccept.toString());
        ResponseData responseData = setAcceptFriend(token, userId, isAccept);
        responseData.printResponseData();
    }

    private static void testcase4() throws IOException {
        System.out.println("Test case 4: Sai user_id");
        ResponseData res = Login.login();
        String token = res.getData().getToken();
//        String token = "yJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjVmYmZkNmMyYThmZGY4MzhmNDgwZGMwMCIsImRhdGVMb2dpbiI6IjIwMjAtMTItMDZUMDk6MzU6MjEuNTU1WiIsImlhdCI6MTYwNzI0NzMyMSwiZXhwIjoxNjA3MzMzNzIxfQ.-2hTWpQ-Xd8tEzsgYBM19anCipfK2qhCRK3MrbBcfuk";
        String userId = "5fcadc49eb6dab2094ebf061";
        Integer isAccept = 1;
        System.out.println("token: " + token);
        System.out.println("user_id: " + userId);
        System.out.println("is_accept: " + isAccept.toString());
        ResponseData responseData = setAcceptFriend(token, userId, isAccept);
        responseData.printResponseData();
    }

    private static void testcase5() throws IOException {
        System.out.println("Test case 5: Sai giá trị is_accept");
        ResponseData res = Login.login();
        String token = res.getData().getToken();
//        String token = "yJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjVmYmZkNmMyYThmZGY4MzhmNDgwZGMwMCIsImRhdGVMb2dpbiI6IjIwMjAtMTItMDZUMDk6MzU6MjEuNTU1WiIsImlhdCI6MTYwNzI0NzMyMSwiZXhwIjoxNjA3MzMzNzIxfQ.-2hTWpQ-Xd8tEzsgYBM19anCipfK2qhCRK3MrbBcfuk";
        String userId = "5fcadc49eb6dab2094ebf061";
        Integer isAccept = 2;
        System.out.println("token: " + token);
        System.out.println("user_id: " + userId);
        System.out.println("is_accept: " + isAccept.toString());
        ResponseData responseData = setAcceptFriend(token, userId, isAccept);
        responseData.printResponseData();
    }

    private static void testcase6() throws IOException {
        System.out.println("Test case 6*: Thiếu user_id");
        ResponseData res = Login.login();
        String token = res.getData().getToken();
//        String token = "yJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjVmYmZkNmMyYThmZGY4MzhmNDgwZGMwMCIsImRhdGVMb2dpbiI6IjIwMjAtMTItMDZUMDk6MzU6MjEuNTU1WiIsImlhdCI6MTYwNzI0NzMyMSwiZXhwIjoxNjA3MzMzNzIxfQ.-2hTWpQ-Xd8tEzsgYBM19anCipfK2qhCRK3MrbBcfuk";
        String userId = null;
        Integer isAccept = 1;
        System.out.println("token: " + token);
        System.out.println("user_id: " + userId);
        System.out.println("is_accept: " + isAccept.toString());
        ResponseData responseData = setAcceptFriend(token, userId, isAccept);
        responseData.printResponseData();
    }

    private static void testcase7() throws IOException {
        System.out.println("Test case 7: Success not accept");
        ResponseData res = Login.login();
        String token = res.getData().getToken();
//        String token = "yJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjVmYmZkNmMyYThmZGY4MzhmNDgwZGMwMCIsImRhdGVMb2dpbiI6IjIwMjAtMTItMDZUMDk6MzU6MjEuNTU1WiIsImlhdCI6MTYwNzI0NzMyMSwiZXhwIjoxNjA3MzMzNzIxfQ.-2hTWpQ-Xd8tEzsgYBM19anCipfK2qhCRK3MrbBcfuk";
        String userId = "5fcadc49eb6dab2094ebf067";
        Integer isAccept = 0;
        System.out.println("token: " + token);
        System.out.println("user_id: " + userId);
        System.out.println("is_accept: " + isAccept.toString());
        ResponseData responseData = setAcceptFriend(token, userId, isAccept);
        responseData.printResponseData();
    }

    public static ResponseData setAcceptFriend(String token, String userId, Integer isAccept) throws IOException {
        URL url = new URL(Constant.SET_ACCEPT_FRIEND +
                "?token=" + token +
                "&user_id=" + userId +
                "&is_accept=" + isAccept);
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
