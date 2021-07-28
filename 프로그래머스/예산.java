import java.util.Arrays;

public class Solution {
    public int solution(int[] d, int budget) {
        int count = 0;
        Arrays.sort(d);
        for (int m : d) {
            if (m > budget)
                return count;
            budget -= m;
            count++;
        }
        return count;
    }
}