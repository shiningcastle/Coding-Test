import java.util.Arrays;

class Solution {
    public String solution(String s) {
        char[] input = s.toCharArray();
        Arrays.sort(input);
        return new StringBuilder(new String(input)).reverse().toString();
    }
}