class Solution {
    public int solution(int n) {
        int count = 0;
        // 소수의 배수들을 소수가 아닌 수로 기록하기 위한 배열
        boolean[] isNotPrime = new boolean[n+1];
        // 0과 1은 소수가 아니므로 true
        isNotPrime[0] = true; isNotPrime[1] = true;
        // 약수의 대칭 성질로 루트 n까지 반복
        for (int i = 2; i <= Math.sqrt(n); i++) {
            // 소수가 맞으면 그 소수의 배수들을 n 이하까지 소수가 아니라고 배열에 기록
            if (!isNotPrime[i]) {
                for (int j = 2*i; j < n+1; j += i)
                    isNotPrime[j] = true;
            }
        }
        // 소수 여부 배열을 조회해 소수 개수를 카운트
        for (boolean c : isNotPrime) {
            if (!c)
                count++;
        }
        return count;
    }
}