class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int charNum = ch + n;
            if (Character.isUpperCase(ch))
                sb.append((char) ((charNum > 90) ? (charNum % 90 - 1) + 'A' : charNum));
            else if (Character.isLowerCase(ch))
                sb.append((char) ((charNum > 122) ? (charNum % 122 - 1) + 'a' : charNum));
            else
                sb.append(ch);
        }
        return sb.toString();
    }
}