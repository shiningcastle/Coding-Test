import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> answer = new ArrayList<>();
        int left = 0, right = 0, count = p.length();
        // 알파벳 별 개수 카운트
        int[] alphabet = new int[26];
        for (int i = 0; i < p.length(); i++)
            alphabet[p.charAt(i)-'a']++;
        // Slding Window 방식의 투포인터
        while (right < s.length()) {
            // s의 글자가 anagram 타겟 문자열에 포함된 문자이면 찾을 개수 -1
            // 알파벳 배열에서도 해당 글자 횟수 차감, 오른쪽 인덱스 전진
            if (alphabet[s.charAt(right)-'a']-- >= 1)
                count--;
            right++;
            // anagram 비교 가능한 상태면 비교해서 정답 넣어줌
            if (count == 0)
                answer.add(left);
            // 단어 개수가 다 찼으면, 창을 오른쪽 이동하면서 왼쪽 인덱스의 글자가 anagram 해당 글자면 배열에서 해당 글자와 count를 다시 +1
            if (right-left == p.length()) {
                if (alphabet[s.charAt(left) - 'a']++ >= 0)
                    count++;
                left++;
            }
        }
        return answer;
    }
}