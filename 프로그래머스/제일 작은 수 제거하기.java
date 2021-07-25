import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        int mini = Arrays.stream(arr).min().getAsInt();
        int[] answer = Arrays.stream(arr).filter(i -> i > mini).toArray();
        return (answer.length == 0) ? new int[] {-1} : answer;
    }
}