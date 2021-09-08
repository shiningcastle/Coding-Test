import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    private static int answer = 0;

    private void dfs(int n, int s, int[] arr, int idx, int sum, boolean used) {
        // 총합이 정답과 같은 경우 카운트, used : 전 순서까지의 수열이 정답인데 이번 순서의 숫자를 사용안해서 중복 정답되는 경우 방지
        if (s == sum && used)
            answer++;
        // 수열의 마지막 숫자까지 사용해 만든 케이스를 위 조건문에서 체크했으므로 종료
        if (idx == n-1)
            return;
        // 해당 인덱스 숫자 택하지 않은 경우
        dfs(n, s, arr, idx+1, sum, false);
        // 해당 인덱스 숫자 택한 경우
        dfs(n, s, arr, idx+1, sum + arr[idx+1], true);
    }

    private void subSequence(int n, int s, int[] arr) {
        // 첫번째 원소 경우의 수에 포함 안한 경우 & 포함한 경우로 시작
        dfs(n, s, arr, 0, 0, false);
        dfs(n, s, arr, 0, arr[0], true);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main main = new Main();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), s = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();
        main.subSequence(n, s, arr);
        System.out.print(answer);
    }
}