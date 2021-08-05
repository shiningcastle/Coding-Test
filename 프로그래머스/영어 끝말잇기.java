import java.util.HashSet;

public class Solution {
    public int[] solution(int n, String[] words) {
        // 중복 체크할 Set
        HashSet<String> set = new HashSet<>();
        // 처음 단어의 끝 글자, set에 첫 단어 넣기
        char last = words[0].charAt(words[0].length()-1);
        set.add(words[0]);
        // 두번째 단어부터 시작
        for (int i = 1; i < words.length; i++) {
            // 끝말잇기에 실패하거나, 중복단어를 말한 경우
            if (words[i].charAt(0) != last || !set.add(words[i]))
                return new int[]{i % n + 1, i / n + 1};
            // 끝 글자 갱신
            last = words[i].charAt(words[i].length()-1);
        }
        return new int[] {0, 0};
    }
}