class Solution {
    private int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    public long solution(int w, int h) {
        long count = gcd(w, h);
        long all = (long) w * h;
        return all - (w/count + h/count - 1) * count;
    }
}