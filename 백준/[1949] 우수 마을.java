import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    private static int[][] dp; // DP 배열
    private static int[] people; // 마을별 사람수

    private static void dfs(int x, int prev, List<Integer>[] arr) {
        dp[x][0] = 0; // 첫 시작점 수 안고른 경우
        dp[x][1] = people[x]; // 고른 경우
        for(Integer next : arr[x]) {
            if(next.intValue() == prev) // 연결된 정점 중에 부모는 스킵
                continue;
            dfs(next, x, arr); // 자식 정점으로 탐색
            // 현재 부모 노드를 안고른 경우, 자식 서브 트리의 루트 노드 포함 여부 관계없이 최대값을 현재 노드 값없이 더하기
            dp[x][0] += Math.max(dp[next][0], dp[next][1]);
            // 현재 부모 노드를 고른 경우, 자식 서브 트리의 루트 노드를 포함하지 않는 경우의 최대값을 현재 노드의 값과 더하기
            dp[x][1] += dp[next][0];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        people = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= n; i++)
            people[i] = Integer.parseInt(st.nextToken());
        List<Integer>[] arr = new ArrayList[n+1]; // 양방향 그래프 생성
        for(int i = 1; i <= n; i++)
            arr[i] = new ArrayList<>();
        dp = new int[n+1][2];
        for (int i = 1; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken()), b = Integer.parseInt(st2.nextToken());
            arr[a].add(b); // 양방향이므로 둘다 반대쪽 노드 넣기
            arr[b].add(a);
        }
        br.close();
        dfs(1, -1, arr); // DFS 탐색으로 DP 배열 완성
        System.out.print(Math.max(dp[1][0], dp[1][1])); // 시작 루트 노드가 우수 마을인 경우, 아닌 경우 중 최대값
    }
}