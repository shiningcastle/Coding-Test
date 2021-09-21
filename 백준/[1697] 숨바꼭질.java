import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    private int findMinSeconds(int n, int m) {
        // n과 m이 같은 지점일 경우 예외 처리
        if (n == m)
            return 0;
        int time = 0;
        boolean[] visited = new boolean[200001]; // 0~200000까지 가능
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n-1);
        queue.add(n+1);
        queue.add(n*2);
        // BFS
        while(!queue.isEmpty()) {
            time++; // 1초 증가
            int size = queue.size(); // 큐의 크기만큼의 원소들이 같은 시간초 시점
            for (int i = 0; i < size; i++) {
                int point = queue.poll();
                if (point == m) // 목표 지점 도달 시간초 반환
                    return time;
                // 조건상 불가능한 범위, 이미 방문했던 지점이면 스킵
                if (point < 0 || point > 200000 || visited[point])
                    continue;
                visited[point] = true; // 현 지점 방문 처리
                queue.add(point-1);
                queue.add(point+1);
                queue.add(point*2);
            }
        }
        return 0; // 여기는 올일이 없는 return
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        br.close();
        System.out.print(new Main().findMinSeconds(n, m));
    }
}