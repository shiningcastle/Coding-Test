class Solution {
    public int climbStairs(int n) {
        // dp 배열
        int[] dp = new int[n+1];
        // 초기 2번째 까지 경우의 수 넣기
        dp[1] = 1;
        if (n >= 2)
            dp[2] = 2;
        // 해당 계단의 경우의 수는 전 계단의 경우의 수(1) + 전전 계단의 경우의 수(2)
        for (int i = 3; i <= n; i++)
            dp[i] = dp[i-1] + dp[i-2];
        return dp[n];
    }
}