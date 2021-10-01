import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    private static StringBuilder lineUp(int n, int[] lines, List<Integer>[] edges) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (lines[i] == 0) // 가장 키가 작은(연결된 간선 0인) 사람 찾아서 큐에 넣기
                queue.add(i);
        }
        // 위상 정렬
        while (!queue.isEmpty()) {
            int man = queue.poll();
            sb.append(man).append(' '); // 앞에서 부터 채우면서 정답 완성
            for (int bigger : edges[man]) {
                lines[bigger]--; // 이번에 줄세운 사람과 비교해서 컸던 각각 사람들의 앞에 세울 사람 수를 줄임
                if (lines[bigger] == 0) // 이번에 줄세운 사람과 비교해서 컸던 각각 사람중 자신보다 작은 사람 없는 경우 큐 추가
                    queue.add(bigger);
            }
        }
        return sb;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        List<Integer>[] edges = new ArrayList[n + 1]; // 해당 인덱스보다 큰 사람 인덱스 넣기
        // 그래프 리스트 초기화
        for (int i = 1; i <= n; i++)
            edges[i] = new ArrayList<>();
        int[] lines = new int[n+1]; // 각 인덱스 사람보다 키작은 사람 수
        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int small = Integer.parseInt(st2.nextToken()), big = Integer.parseInt(st2.nextToken());
            edges[small].add(big); // 해당 사람보다 키큰 사람 누군지 저장
            lines[big]++; // 해당 사람보다 키작은 사람 수 저장
        }
        System.out.print(lineUp(n, lines, edges));
    }
}