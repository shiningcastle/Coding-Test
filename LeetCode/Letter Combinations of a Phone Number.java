import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Solution {
    private void dfs(List<String> answer, Map<Character, char[]> map, String digits, String word, int idx) {
        // 개수가 다차서 단어가 완성되면 정답 리스트에 넣기
        if (word.length() == digits.length())
            answer.add(word);
        // 해당 글자의 알파벳 배열에서 한글자씩 골라서 모든 경우의 수 단어를 만든다
        for (int i = idx; i < digits.length(); i++) {
            char[] alphabet = map.get(digits.charAt(i));
            for (char a : alphabet)
                dfs(answer, map, digits, word + a, i + 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
        // 숫자별 알파벳 정의
        Map<Character, char[]> map = Map.of(
                '2', new char[]{'a', 'b', 'c'},
                '3', new char[]{'d', 'e', 'f'},
                '4', new char[]{'g', 'h', 'i'},
                '5', new char[]{'j', 'k', 'l'},
                '6', new char[]{'m', 'n', 'o'},
                '7', new char[]{'p', 'q', 'r', 's'},
                '8', new char[]{'t', 'u', 'v'},
                '9', new char[]{'w', 'x', 'y', 'z'}
        );
        // 숫자 아무것도 안누르는 경우 예외처리
        if (digits.equals(""))
            return answer;
        dfs(answer, map, digits, "", 0);
        return answer;
    }
}