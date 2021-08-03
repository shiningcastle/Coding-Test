import java.util.Arrays;

class Solution {
    int solution(int[][] land) {
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                int max = 0;
                for (int k = 0; k < 4; k++)
                    max = (j == k) ? max : Math.max(land[i-1][k], max);
                land[i][j] += max;
            }
        }
        return Arrays.stream(land[land.length-1]).max().getAsInt();
    }
}