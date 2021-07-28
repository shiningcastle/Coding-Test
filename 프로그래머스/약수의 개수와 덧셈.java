public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            // 약수의 개수
            int count = 0;
            // 약수의 대칭성에 따라 n의 약수의 개수 판별은 1부터 루트 n까지만 살펴보고 2개씩 카운트
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (i % j == 0)
                    // 만약 루트로 딱 떨어지는 제곱수면 1개만 카운트 아니면 대칭으로 2개 카운트
                    count += (Math.pow(j, 2) == i) ? 1 : 2;
            }
            // 약수의 개수 짝수면 +, 홀수면 -
            answer += (count % 2 == 0) ? i : -i;
        }
        return answer;
    }
}