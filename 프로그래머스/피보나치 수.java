class Solution {
    private int fibo(int num) {
        // 각 수의 피보나치 숫자를 담아줄 배열 선언
        int[] fiboArr = new int[num + 1];
        // 0과 1의 경우 초기화
        fiboArr[0] = 0; fiboArr[1] = 1;
        // 0과 1의 경우
        if (num < 2)
            return fiboArr[num];
        // 그 앞의 배열의 피보나치 수를 이용해서 피보나치 수를 구해 배열에 기록
        else {
            for (int i = 2; i < num; i++)
                fiboArr[i] = (fiboArr[i-1] + fiboArr[i-2]) % 1234567;
        }
        return (fiboArr[num - 1] + fiboArr[num - 2]) % 1234567;
    }

    public int solution(int n) {
        return fibo(n);
    }
}