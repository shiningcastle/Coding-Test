public class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            char[] binArr = String.format("%0" + n + "d", Long.parseLong(Integer.toBinaryString(arr1[i] | arr2[i]))).toCharArray();
            for (char ch : binArr) {
                sb.append((ch == '1') ? '#' : 0x20);
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}