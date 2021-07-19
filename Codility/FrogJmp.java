class Solution {
    public int solution(int X, int Y, int D) {
        double result = (Y-X) / (double) D;
        return (int) Math.ceil(result);
    }
}