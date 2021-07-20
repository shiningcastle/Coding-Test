class Solution {
    public int solution(int[] A) {
        // 동쪽으로 가는 차 P의 누적 개수
        int p = 0;
        // (P,Q) 쌍의 개수, int의 범위를 넘는게 가능해서 long
        long answer = 0;
        for (int n : A) {
            // 동쪽으로 가는 차 P가 등장하면 카운트
            if (n == 0)
                p++;
            // 앞에 나왔던 차 P의 개수만큼 카운트
            else
                answer += p;
        }
        // 10억 보다 클경우 -1
        return (answer > 1000000000) ? -1 : (int) answer;
    }
}