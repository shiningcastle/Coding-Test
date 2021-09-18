import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    private static StringBuilder dfsString = new StringBuilder();
    private static StringBuilder bfsString = new StringBuilder();

    private static void dfs(int v, ArrayList<Integer>[] adj, boolean[] visitedD) {
        visitedD[v] = true;
        dfsString.append(v).append(' ');
        // 해당 원소와 연결된 모든 원소들 다음 순서로 조회
        for (Integer num : adj[v]) {
            // 방문한적 없는 원소만 다음으로 조회
            if (!visitedD[num])
                dfs(num, adj, visitedD);
        }
    }

    private static void bfs(int v, ArrayList<Integer>[] adj, boolean[] visitedB) {
        Queue<Integer> queue = new LinkedList<>();
        // 첫원소 넣어주고 방문 체크
        queue.add(v);
        visitedB[v] = true;
        // 큐의 원소가 모두 사라질 때까지 반복
        while (!queue.isEmpty()) {
            int next = queue.poll();
            bfsString.append(next).append(' ');
            for (Integer num : adj[next]) {
                // 방문한적 없는 원소만 다음으로 조회
                if (!visitedB[num]) {
                    queue.add(num);
                    visitedB[num] = true;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        // 배열의 각 인덱스별 ArrayList로 채워주기
        for (int i = 1; i <= n; i++)
            adj[i] = new ArrayList<>();
        // 이미 방문한적 있는지 확인 배열
        boolean[] visitedD = new boolean[n + 1], visitedB = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st2.nextToken()), n2 = Integer.parseInt(st2.nextToken());
            adj[n1].add(n2); // 양방향 그래프 이므로 반대로도 입력해주어야 한다
            adj[n2].add(n1);
        }
        // 작은 숫자 순으로 방문하라고 했으므로 정렬해주기
        for (int i = 1; i <= n; i++)
            Collections.sort(adj[i]);
        br.close();
        dfs(v, adj, visitedD);
        bfs(v, adj, visitedB);
        System.out.println(dfsString);
        System.out.print(bfsString);
    }
}