class Solution {
    public int maxSubArray(int[] nums) {
        int curMax = nums[0], allMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 부분 누적 최대값, 현재 1개짜리 원소로 다시 시작할지, 누적값으로 계속갈지 더 큰값으로 정하는 기능도 한다
            curMax = Math.max(nums[i], curMax+nums[i]);
            // 전체 최대 값
            allMax = Math.max(allMax, curMax);
        }
        return allMax;
    }
}