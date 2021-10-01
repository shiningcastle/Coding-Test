import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    private static StringBuilder answer = new StringBuilder();

    private static void lineUp(int n, int[] cost, int[] needed, List<Integer>[] edges, int target) {
        Queue<Integer> queue = new LinkedList<>();
        int[] done = new int[n + 1]; // 해당 인덱스 건물 건설완료 시간 기록 배열
        for (int i = 1; i <= n; i++) {
            if (needed[i] == 0) { // 가장 선행으로 필요한 건물(needed[i] = 0)찾아서 큐에 넣기
                queue.add(i);
                done[i] = cost[i]; // 시작하는 건물 건설에 걸리는 시간은 기본이 답
            }
        }
        // 위상 정렬
        while (!queue.isEmpty()) {
            int one = queue.poll(); // 선행 건물
            for (int another : edges[one]) { // 다음 예정 건물들
                needed[another]--; // 다음에 지을 건물의 선행 건물수를 줄이기
                if (needed[another] == 0) // 다음에 지을 건물의 선행 건물이 없으면 큐 추가
                    queue.add(another);
                done[another] = Math.max(done[another], done[one] + cost[another]); // 시간이 더걸리는 경우 발견하면 갱신
            }
        }
        answer.append(done[target]).append('\n'); // 정답 문자열 이어붙여 만들기
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st1.nextToken()), k = Integer.parseInt(st1.nextToken());
            int[] cost = new int[n + 1];
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            // 시간 배열
            for (int j = 1; j <= n; j++)
                cost[j] = Integer.parseInt(st2.nextToken());
            // 간선 입력
            List<Integer>[] edges = new ArrayList[n + 1];
            // 그래프 리스트 초기화
            for (int j = 1; j <= n; j++)
                edges[j] = new ArrayList<>();
            int[] needed = new int[n + 1]; // 각 인덱스 사람보다 키작은 사람 수
            for (int j = 1; j <= k; j++) {
                StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
                int before = Integer.parseInt(st3.nextToken()), after = Integer.parseInt(st3.nextToken());
                edges[before].add(after); // 먼저 건설할 건물의 다음 건물을 그래프에 넣기
                needed[after]++; // 선행으로 필요한 건물수 기록
            }
            lineUp(n, cost, needed, edges, Integer.parseInt(br.readLine()));
        }
        System.out.print(answer);
    }
}