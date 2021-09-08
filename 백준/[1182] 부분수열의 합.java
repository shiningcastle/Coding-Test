import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    private static int answer = 0;

    private void dfs(int n, int s, int[] arr, int idx, int sum) {
        // 해당 경우의 수의 숫자들이 완성되면 총합이 정답과 같은 경우 카운트,
        if (idx == n-1) {
            if (sum == s)
                answer++;
            return;
        }
        // 해당 인덱스 숫자 택하지 않은 경우
        dfs(n, s, arr, idx+1, sum);
        // 해당 인덱스 숫자 택한 경우
        dfs(n, s, arr, idx+1, sum + arr[idx+1]);
    }

    private void subSequence(int n, int s, int[] arr) {
        // 첫번째 원소 경우의 수에 포함 안한 경우 & 포함한 경우로 시작
        dfs(n, s, arr, 0, 0);
        dfs(n, s, arr, 0, arr[0]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main main = new Main();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), s = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();
        main.subSequence(n, s, arr);
        // s가 0이고 모든 수열 숫자 사용안하고 sum이 0인 경우는 정답이 아니지만 카운트 되므로 제외
        System.out.print((s == 0) ? answer-1 : answer);
    }
}