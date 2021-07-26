public class Solution {
    public String solution(String s) {
        // -1 포함하면 길이가 0인 문자열도 무시하지 않고 포함
        String[] arr = s.split(" ", -1);
        StringBuilder sb = new StringBuilder();
        for (String word : arr) {
            for (int i = 0; i < word.length(); i++) {
                if (i % 2 == 0)
                    sb.append((Character.isLowerCase(word.charAt(i))) ? (char) (word.charAt(i) - 32) : word.charAt(i));
                else
                    sb.append((Character.isUpperCase(word.charAt(i))) ? (char) (word.charAt(i) + 32) : word.charAt(i));
            }
            // 단어 사이에 공백 넣기
            sb.append(" ");
        }
        // 마지막 단어 뒤에도 " " 공백 붙어있어서 제거해주기
        return sb.deleteCharAt(sb.length()-1).toString();
    }
}