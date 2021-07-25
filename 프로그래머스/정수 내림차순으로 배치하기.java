import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        String[] input = String.valueOf(n).split("");
        Arrays.sort(input, Collections.reverseOrder());
        return Long.valueOf(String.join("", input));
    }
}