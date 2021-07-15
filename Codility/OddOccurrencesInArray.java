import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        // 길이가 1이면 유일한 원소가 답
        if (A.length == 1)
            return A[0];
        // 같은 숫자끼리 모이도록 정렬
        Arrays.sort(A);
        // 두개씩 단독으로 짝지어서 조회 
        for (int i = 0; i < A.length; i+=2) {
            // 짝지은 숫자끼리 다르면 앞의 숫자가 정답
            // 정답 숫자 빼고는 모두 짝수라 다른 수는 무조건 앞에 온다.
            // 마지막 원소전까지 통과하면 마지막 원소가 정답
            if (i == A.length-1 || A[i] != A[i+1])
                return A[i];
        }
        // 여기는 문법상 적은 return이고 여기로 빠질 수는 없다.
        return 0;
    }
}