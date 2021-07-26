public class Solution {
    public int solution(String dartResult) {
        int answer = 0, before = 0, now = 0;
        for (int i = 0; i < dartResult.length(); i++) {
            char ch = dartResult.charAt(i);
            // 점수
            if (Character.isDigit(ch)) {
                // 점수가 두자리수 = 10점 경우
                if (ch == '1' && dartResult.charAt(i+1) == '0') {
                    now = 10;
                    i++;
                } else
                    now = ch - '0';
                // 보너스
            } else if (Character.isUpperCase(ch)) {
                if (ch == 'D')
                    now = (int) Math.pow(now, 2);
                else if (ch == 'T')
                    now = (int) Math.pow(now, 3);
                // 옵션
            } else {
                if (ch == '*') {
                    answer += before;
                    now *= 2;
                } else
                    now *= -1;
            }
            // 마지막 점수 구간인 경우 or 다음 글자가 숫자인 경우 하나의 점수 구간이 완료되므로 총합 계산, 직전 점수 갱신
            if (i == dartResult.length()-1 || Character.isDigit(dartResult.charAt(i+1))) {
                answer += now;
                before = now;
            }
        }
        return answer;
    }
}