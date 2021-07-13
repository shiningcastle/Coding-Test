import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static String parentheses(String input) {
        int check = 0;
        for (char pt : input.toCharArray()) {
            // 여는 괄호면 +1, 닫는 괄호면 -1
            check += (pt == '(') ? 1 : -1;
            // 음수로 한번이라도 내려가면 올바른 괄호아님
            if (check < 0) {
                return "NO";
            }
        }
        // 0이면 여는 괄호와 닫는 괄호의 개수가 일치함
        String result = (check == 0) ? "YES" : "NO";
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            System.out.println(parentheses(br.readLine()));
        }
    }
}