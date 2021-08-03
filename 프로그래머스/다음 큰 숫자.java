class Solution {
    public int solution(int n) {
        int countOne1 = 0;
        for (char b : Integer.toBinaryString(n).toCharArray()) {
            if (b == '1')
                countOne1++;
        }
        while (true) {
            n++;
            int countOne2 = 0;
            for (char b : Integer.toBinaryString(n).toCharArray()) {
                if (b == '1')
                    countOne2++;
            }
            if (countOne1 == countOne2)
                return n;
        }
    }
}