class Solution {
    public int solution(int[] A) {
        double min = 10000;
        int answer = 0;
        // 두개씩 짝인 경우
        for (int i = 0; i < A.length-1; i++) {
            double check = (double) (A[i] + A[i+1]) / 2;
            if (check < min) {
                min = check;
                answer = i;
            }
        }
        // 세개씩 짝인 경우
        for (int i = 0; i < A.length-2; i++) {
            double check = (double) (A[i] + A[i+1] + A[i+2]) / 3;
            if (check < min) {
                min = check;
                answer = i;
            }
        }
        return answer;
    }
}