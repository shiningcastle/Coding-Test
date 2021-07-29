class Solution {
    private int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public int solution(int[] arr) {
        int result = 1;
        for (int i = 0; i < arr.length; i++)
            result = arr[i] * result / gcd(arr[i], result);
        return result;
    }
}