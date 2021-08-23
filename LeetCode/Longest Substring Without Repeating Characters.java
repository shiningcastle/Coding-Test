import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, max = 0;
        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        while (right < arr.length) {
            if (!set.contains(arr[right])) {
                set.add(arr[right]);
                max = Math.max(max, set.size());
                right++;
            } else {
                set.remove(arr[left]);
                left++;
            }
        }
        return max;
    }
}