import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static class Edge { // ~지점으로 ~만큼 비용
        public int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Info { // ~지점까지 가는 최단거리는 ~이다
        public int idx, dist;

        public Info() {
        }

        public Info(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    static int[] dist;
    static ArrayList<Edge>[] edges;

    private static void findMinCost(int n, int start) {
        // 거리배열 초기화를 최대로 해서 최단거리로 갱신되게 한다
        for (int i = 1; i <= n; i++)
            dist[i] = Integer.MAX_VALUE;
        // 거리가 작은 값을 우선적으로 뽑아줄 힙
        PriorityQueue<Info> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist)); // 오름차순 정렬
        heap.add(new Info(start, 0)); // 시작점을 힙에 넣기
        dist[start] = 0; // 시작점의 최단거리는 0
        // 다익스트라 알고리즘
        while (!heap.isEmpty()) {
            Info info = heap.poll();
            // 만약 뽑은 거리가 최단 거리가 아니면 스킵, 거리가 같아도 간선은 볼가치가 있으므로 스킵 안함
            if (dist[info.idx] < info.dist)
                continue;
            dist[info.idx] = info.dist; // idx 도시의 최단거리 갱신해주기
            // 간선에 연결된 인접 도시의 최소 비용이 지금 도시까지 비용 + 인접 도시로 가는 간선 비용보다 크면 갱신
            for (Edge edge : edges[info.idx]) {
                if (dist[edge.to] > dist[info.idx] + edge.weight) {
                    dist[edge.to] = dist[info.idx] + edge.weight;
                    heap.add(new Info(edge.to, dist[edge.to])); // 힙에 후보 등록해서 정렬
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), m = Integer.parseInt(br.readLine());
        dist = new int[n + 1]; // 해당 인덱스 도시까지 가는데 드는 비용을 저장
        edges = new ArrayList[n + 1]; // 해당 인덱스 도시에서 다른 도시로 가는 데 비용이 얼마나 드는지 간선모음
        // 리스트 초기화
        for (int i = 1; i <= n; i++)
            edges[i] = new ArrayList<>();
        // 간선 입력
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            edges[Integer.parseInt(st.nextToken())]
                    .add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        br.close();
        int start = Integer.parseInt(st2.nextToken()), goal = Integer.parseInt(st2.nextToken());
        findMinCost(n, start);
        System.out.print(dist[goal]);
    }
}