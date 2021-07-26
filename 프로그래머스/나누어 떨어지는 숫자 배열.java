import java.util.Arrays;

public class Solution {
    public int[] solution(int[] arr, int divisor) {
        // divisor로 나누어 떨어지는 수로만 배열을 만든다
        int[] answer = Arrays.stream(arr).filter(i -> i % divisor == 0).toArray();
        // 오름차순 정렬
        Arrays.sort(answer);
        return (answer.length == 0) ? new int[]{-1} : answer;
    }
}