class Solution {
    public int solution(int N) {
        String binInt = Integer.toBinaryString(N);
        int max = 0, count = 0;
        boolean flag = false;
        for (char chr : binInt.toCharArray()) {
            if (flag) {
                if (chr == '0')
                    count++;
            }
            if (chr == '1') {
                flag = true;
                if (count > max)
                    max = count;
                count = 0;
            }
        }
        return max;
    }
}