import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    class State {
        int[] bucket;
        State(int[] b) {
            bucket = b;
        }
        State move(int from, int to, int[] limit) {
            int[] tmp = new int[] {bucket[0], bucket[1], bucket[2]};
            if (limit[to] < tmp[from] + tmp[to]) {
                tmp[from] -= (limit[to] - tmp[to]);
                tmp[to] = limit[to];
            } else {
                tmp[to] += tmp[from];
                tmp[from] = 0;
            }
            return new State(tmp);
        }
    }

    private boolean[] possible = new boolean[201];
    private boolean[][][] visited = new boolean[201][201][201];

    private String findCases(int[] limit) {
        Queue<State> queue = new LinkedList<>();
        // 첫 시작 큐에 넣기
        queue.add(new State(new int[] {0, 0, limit[2]}));
        visited[0][0][limit[2]] = true;
        // bfs
        while (!queue.isEmpty()) {
            State state = queue.poll();
            // 첫 양동이가 비었으면, 그 때의 세번째 양동이 값에 해당하는 인덱스 체크
            if (state.bucket[0] == 0)
                possible[state.bucket[2]] = true;
            // 해당 상태에서 일어날 수 있는 모든 상태
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j) // 같은 양동이 경우 제외
                        continue;
                    // i번째 양동이의 물을 j번째 양동이로 옮기기
                    State tmp = state.move(i, j, limit);
                    // 만약 옮긴 상태가 전에 있었던 경우가 아니라면 방문체크, 큐에 넣기
                    if (!visited[tmp.bucket[0]][tmp.bucket[1]][tmp.bucket[2]]) {
                        visited[tmp.bucket[0]][tmp.bucket[1]][tmp.bucket[2]] = true;
                        queue.add(tmp);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        // 정답출력
        for (int i = 0; i <= limit[2]; i++) {
            if (possible[i])
                sb.append(i).append(' ');
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] limit = new int[3];
        for (int i = 0; i < 3; i++)
            limit[i] = Integer.parseInt(st.nextToken());
        System.out.print(new Main().findCases(limit));
    }
}