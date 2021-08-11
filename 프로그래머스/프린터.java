import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        // 우선순위가 높은 순으로 반환해줄 힙과 대기목록인 큐
        PriorityQueue heap = new PriorityQueue(Collections.reverseOrder());
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[] {i, priorities[i]}); // 인덱스, 우선순위
            heap.offer(priorities[i]);
        }
        while (true) {
            if ((int) heap.peek() == queue.peek()[1]) {
                int[] printOut = queue.poll();
                heap.poll();
                count++;
                if (printOut[0] == location)
                    return count;
            } else {
                queue.offer(queue.poll());
            }
        }
    }
}