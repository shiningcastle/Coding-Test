import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length, answer = 1;
        int[] dp = new int[len];
        // 부분 배열 길이의 최소값은 1
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
            answer = Math.max(dp[i], answer);
        }
        return answer;
    }
}