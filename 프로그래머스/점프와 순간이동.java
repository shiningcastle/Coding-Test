public class Solution {
    public int solution(int n) {
        int count = 0;
        for (char one : Integer.toBinaryString(n).toCharArray()) {
            if (one == '1')
                count++;
        }
        return count;
    }
}