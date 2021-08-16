class Solution {
    private int rec(int[] numbers, int target, int idx, int sum) {
        if (idx == numbers.length-1) {
            if (sum == target)
                return 1;
            return 0;
        }
        return rec(numbers, target, idx+1, sum-numbers[idx+1]) + rec(numbers, target, idx+1, sum+numbers[idx+1]);
    }

    public int solution(int[] numbers, int target) {
        return rec(numbers, target, 0, -numbers[0]) + rec(numbers, target, 0, numbers[0]);
    }
}