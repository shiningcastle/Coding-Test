import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        int[] answer = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            answer[i] = Integer.parseInt(arr[i]);
        Arrays.sort(answer);
        return String.format("%d %d", answer[0], answer[answer.length-1]);
    }
}