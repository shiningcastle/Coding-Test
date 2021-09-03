class Solution {
    public int coinChange(int[] coins, int amount) {
        // DP 배열, 0부터 시작해서 N까지 칸을 만들기위해 N+1
        int[] dp = new int[amount + 1];
        int len = dp.length;
        // 배열을 0번째 칸 빼고 나머지를 불가능한 값인 amount+1로 초기화
        // 정답 숫자의 칸에 amount+1이 그대로면 정답 존재안하는 것
        for (int i = 1; i < len; i++)
            dp[i] = amount + 1;
        // DP
        for (int i = 1; i < len; i++) {
            for (int coin : coins) {
                // 앞에서 해당 타겟 숫자를 만드는데 필요한 코인이 존재할 경우만
                if (i - coin >= 0)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}