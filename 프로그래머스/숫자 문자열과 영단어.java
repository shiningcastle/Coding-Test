import java.io.IOException;
import java.util.HashMap;

class Solution {
    public int solution(String s) {
        StringBuilder answer = new StringBuilder();
        char[] input = s.toCharArray();
        // 숫자와 영단어로 HashMap 만들기
        HashMap<String, Character> map = new HashMap<String, Character>() {{
            put("zero", '0');
            put("one", '1');
            put("two", '2');
            put("three", '3');
            put("four", '4');
            put("five", '5');
            put("six", '6');
            put("seven", '7');
            put("eight", '8');
            put("nine", '9');
        }};
        // 영어 단어를 만들기 위한 임시 문자열
        StringBuilder sb = new StringBuilder();
        for (Character ch : input) {
            // 문자가 알파벳일 경우
            if (!Character.isDigit(ch)) {
                // 임시 문자열에 넣는다
                sb.append(ch);
                // 임시 문자열의 길이가 3이상 쌓이면 단어 충족하는지 체킹
                if (sb.length() >= 3) {
                    // 글자가 모자라면 map에서 null 반환,충분하면 해당 숫자 문자 반환
                    Character num = map.get(sb.toString());
                    // 숫자 문자가 반환되면 정답 문자열에 붙여주고, 임시 문자열 초기화
                    if (num != null) {
                        answer.append(num);
                        sb.setLength(0);
                    }
                }
            }
            // 문자가 숫자일 경우 정답 문자열에 그대로 붙인다
            else
                answer.append(ch);
        }
        // 정답 문자열을 정수 타입으로 변환
        return Integer.parseInt(answer.toString());
    }
}