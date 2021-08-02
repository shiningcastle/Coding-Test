class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int[] arr = {1, 2, 4};
        while (n != 0) {
            sb.append(arr[(n-1) % 3]);
            n = (n-1) / 3;
        }
        return sb.reverse().toString();
    }
}