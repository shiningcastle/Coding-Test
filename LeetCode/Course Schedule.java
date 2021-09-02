import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> queue = new LinkedList<>();
        int[] graph = new int[numCourses];
        int length = prerequisites.length;
        // 위상정렬 수행할 그래프 배열 만들기
        for (int[] prerequisite : prerequisites)
            graph[prerequisite[0]]++;
        // 배열에서 값이 0인 가장 먼저 들어야 하는 강의 찾아 큐에 넣기
        for (int i = 0; i < numCourses; i++) {
            if (graph[i] == 0)
                queue.offer(i);
        }
        // 큐로 BFS를 수행하여 순차적으로 간선을 지우며 최종적으로 모두 0이 되는지 판별
        // 싸이클이 존재하면 해당 관련 원소들이 모두 0보다 커서 큐에 진입하지 못한다 -> 그래프에서 0으로 못만듦
        while (!queue.isEmpty()) {
            // 우선순위 빠른 강의로 다음 우선순위 강의와 연결을 끊어줌 (0으로 만들기)
            int num = queue.poll();
            for (int i = 0; i < length; i++) {
                if (prerequisites[i][1] == num) {
                    graph[prerequisites[i][0]]--;
                    // 만약 0이 되면 최우선 순위 강의가 되어 다음 우선순위 강의를 찾기위해 큐에 넣음
                    if (graph[prerequisites[i][0]] == 0)
                        queue.offer(prerequisites[i][0]);
                }
            }
        }
        // 그래프에서 모두 0으로 바뀌었는지 확인 -> 위상정렬 가능
        for (int n : graph) {
            if (n != 0)
                return false;
        }
        return true;
    }
}