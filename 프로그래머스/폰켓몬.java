import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> hs = new HashSet();
        for (int num : nums)
            hs.add(num);
        return (hs.size() > nums.length / 2) ? nums.length / 2 : hs.size();
    }
}