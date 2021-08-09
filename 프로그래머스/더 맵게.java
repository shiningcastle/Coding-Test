import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int count = 0;
        for (int s : scoville)
            heap.offer(s);
        while (heap.peek() < K && heap.size() > 1) {
            int mixed = heap.poll() + (heap.poll() * 2);
            heap.offer(mixed);
            count++;
        }
        return (heap.peek() >= K) ? count : -1;
    }
}