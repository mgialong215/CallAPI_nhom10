import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class GetListSuggestedFriends {

    public static void main(String[] args) throws IOException {
        testCase1();
    }

    private static void testCase1() throws IOException {
        System.out.println("Test case 1: Lấy danh sách gợi ý thành công");
        ResponseData res = Login.login();
        String token = res.getData().getToken();
        Integer index = 30;
        Integer count = 5;
        System.out.println("token: " + token);
        System.out.println("index: " + index);
        System.out.println("count: " + count.toString());
        ResponseData responseData = getListSuggestedFriends(token, index, count);
        responseData.printResponseData();
    }

    public static ResponseData getListSuggestedFriends(String token, Integer index, Integer count) throws IOException {
        URL url = new URL(Constant.GET_LIST_SUGGESTED_FRIENDS +
                "?token=" + token +
                "&index=" + index +
                "&count=" + count);
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
