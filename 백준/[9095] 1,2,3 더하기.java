import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    private static StringBuilder findCases(int n, int[] cases) {
        StringBuilder answer = new StringBuilder();
        // DP를 위한 배열, 1,2,3을 만드는 경우의 수 넣기
        int[] dp = new int[11]; // 숫자는 1~10까지
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int c : cases) {
            for (int i = 4; i <= c; i++) { // 4부터 구하는 수까지 경우의 수 다 구해서 배열 채우기
                if (dp[i] == 0) // 이미 앞에서 구한 적있으면 계산 x
                    dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
            }
            answer.append(dp[c]).append('\n');
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cases = new int[n];
        for (int i = 0; i < n; i++)
            cases[i] = Integer.parseInt(br.readLine());
        br.close();
        System.out.print(findCases(n, cases));
    }
}