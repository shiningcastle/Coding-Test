class Solution {
	public static int[] solution(long n) {
		int[] answer = new int[(int) Math.log10(n) + 1];
        int reverse = 0;
        for (int i = 0; n != 0; i++) {
            answer[i] = (int) (n % 10); 
            n /= 10;
        }
        return answer;
	}
}