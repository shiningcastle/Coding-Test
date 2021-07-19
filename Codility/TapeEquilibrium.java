import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        int arraySum = 0, partSum = 0, min = 1000 * 100000;
        for (int a : A)
            arraySum += a;
        for (int i = 0; i < A.length-1; i++) {
            partSum += A[i];
            int check = Math.abs(2*partSum - arraySum);
            if (check < min) 
                min = check;
        }
        return min;
    }
}