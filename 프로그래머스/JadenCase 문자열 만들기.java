class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] word = s.toLowerCase().split("");
        boolean flag = true;
        for (String w : word) {
            sb.append(flag ? w.toUpperCase() : w);
            flag = w.equals(" ") ? true : false;
        }
        return sb.toString();
    }
}