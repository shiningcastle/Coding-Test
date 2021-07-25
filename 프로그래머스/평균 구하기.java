import java.util.Arrays;

class Solution {
    public static double solution(int[] arr) {
        int ssum = Arrays.stream(arr).sum();
        return (double) ssum / arr.length;
    }
}