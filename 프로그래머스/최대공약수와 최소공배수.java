class Solution {
	// 최대공약수를 구하는 함수
    private static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    
    public int[] solution(int n, int m) {
        int gy = gcd(n, m);
        return new int[] {gy, n * m / gy};
    }
}