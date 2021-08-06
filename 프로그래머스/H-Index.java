import java.util.*;
 
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length-i)
                return citations.length-i;
        }
        // 여기는 올 수 없다
        return 0;
    }
}