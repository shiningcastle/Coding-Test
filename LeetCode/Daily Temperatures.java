import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && stack.peek()[0] < temperatures[i]) {
                int idx = stack.pop()[1];
                answer[idx] = i - idx;
            }
            stack.push(new int[] {temperatures[i], i});
        }
        return answer;
    }
}