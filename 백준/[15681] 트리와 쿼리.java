import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    private static int[] dp;
    private static void dfs(int x, int prev, List<Integer>[] arr) {
        dp[x] = 1; // 현재 위치 정점 카운트
        for(Integer next : arr[x]) {
            if(next.intValue() == prev) // 연결된 정점 중에 부모는 스킵
                continue;
            dfs(next, x, arr); // 자식 정점으로 탐색
            dp[x] += dp[next]; // 하위 그래프의 정점들 수를 부모에 더해주기
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken()), q = Integer.parseInt(st.nextToken());
        List<Integer>[] arr = new ArrayList[n+1];
        for(int i = 1; i <= n; i++)
            arr[i] = new ArrayList<>();
        dp = new int[n+1];
        for (int i = 1; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st2.nextToken()), v = Integer.parseInt(st2.nextToken());
            arr[u].add(v); // 양방향이므로 둘다 반대쪽 노드 넣기
            arr[v].add(u);
        }
        dfs(r, -1, arr); // DFS 탐색으로 DP 배열 완성
        for (int i = 0; i < q; i++)
            System.out.println(dp[Integer.parseInt(br.readLine())]);
        br.close();
    }
}