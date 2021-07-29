class Solution {
    public int solution(int n) {
        // 자기 자신의 경우의 수 +1
        int count = 1;
        // 연속된 수이기 때문에 그 수의 절반 언저리부터 체크하면 된다
        for (int i = n/2 + 1; i > 0; i--) {
            int sum = 0;
            // 1씩 감소하면서 합해주고 총합이 정답이거나 정답보다 커지면 탈출
            for (int j = i; j > 0; j--) {
                sum += j;
                if (sum == n) {
                    count++;
                    break;
                }
                if (sum > n)
                    break;
            }
        }
        return count;
    }
}