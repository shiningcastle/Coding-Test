import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // 우선 순위 기준 comparaotr를 정의한 우선순위 큐(힙)을 만들고 원소를 넣어줌
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]));
        for (int[] p : points)
            queue.offer(p);
        int[][] answer = new int[k][2];
        for (int i = 0; i < k; i++)
            answer[i] = queue.poll();
        return answer;
    }
}