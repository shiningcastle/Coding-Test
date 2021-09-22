import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    private static int findCases(int n) {
        int[] dp = new int[n+2]; // n+1로 하면 n=1 일 때 dp[2]에서 인덱스 에러 발생
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++)
            dp[i] = (dp[i-2] + dp[i-1]) % 10007;
        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();
        System.out.print(findCases(n));
    }
}