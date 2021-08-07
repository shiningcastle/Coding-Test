import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0, current_weight = 0;
        Queue<Integer> bridge = new LinkedList<>();
        for (int truck : truck_weights) {
            while (true) {
                // 다리에 트럭이 한대도 없으면 넣어주고 시간 +1, 무게 갱신
                if (bridge.isEmpty()) {
                    bridge.offer(truck);
                    answer++;
                    current_weight += truck;
                    break;
                // 다리가 꽉 찼으면 앞의 트럭을 빼주고, 무게 갱신
                } else if (bridge.size() == bridge_length) {
                    current_weight -= bridge.poll();
                // 다리에 다음 트럭이 들어올 여유가 있으면 추가하고, 시간 +1, 무게 갱신
                } else if (current_weight + truck <= weight) {
                    bridge.offer(truck);
                    answer++;
                    current_weight += truck;
                    break;
                // 다리에 무게 여유가 없으면 트럭이 안들어오고(무게 0), 시간 +1
                } else {
                    bridge.offer(0);
                    answer++;
                }
            }
        }
        return answer + bridge_length; // 마지막 트럭이 다리에 올라간 순간 for문 종료, 다 빠져나오는데 걸리는 시간(길이)
    }
}