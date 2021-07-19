import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        int answer = 0;
        Arrays.sort(A);
        for (int n : A) {
            if (n > 0) {
                if (n > answer + 1)
                    return answer + 1;
                else if (n == answer + 1)
                    answer++;
            }
        }
        return answer + 1;
    }
}