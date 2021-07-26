class Solution {
    boolean solution(String s) {
        char[] input = s.toCharArray();
        int count = 0;
        for (char ch : input) {
            if (ch == 'p' || ch == 'P')
                count++;
            else if (ch == 'y' || ch == 'Y')
                count--;
        }
        return (count == 0) ? true : false;
    }
}