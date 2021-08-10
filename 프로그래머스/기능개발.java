import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> progress = new LinkedList<>();
        Queue<Integer> speed = new LinkedList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (int p : progresses)
            progress.offer(p);
        for (int s : speeds)
            speed.offer(s);

        while (!progress.isEmpty()) {
            for (int i = 0; i < progress.size(); i++) {
                int work = speed.poll();
                progress.offer(progress.poll() + work);
                speed.offer(work);
            }
            int count = 0;
            while (!progress.isEmpty() && progress.peek() >= 100) {
                progress.poll();
                speed.poll();
                count++;
            }
            if (count > 0)
                answer.add(count);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}