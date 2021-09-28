import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    private static int combineFile(int n, int[] arr) {
        // 1~n번째 숫자까지의 구간 합 배열 생성
        int[][] sums = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++)
                sums[i][j] = sums[i][j-1] + arr[j];
        }
        int[][] dp = new int[n+1][n+1];
        // 범위가 1짜리 자리는 이미 0으로 초기화 되어있어서 2부터
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n-len+1; i++) {
                int j = len + i - 1;
                dp[i][j] = Integer.MAX_VALUE; // 최소값을 찾기위해 0을 매우 큰값으로 바꾸기
                for (int k = i; k < j; k++)
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + sums[i][j]);
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[n+1];
            for (int j = 1; j <= n; j++)
                arr[j] = Integer.parseInt(st.nextToken());
            System.out.println(combineFile(n, arr));
        }
        br.close();
    }
}