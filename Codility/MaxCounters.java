class Solution {
    public int[] solution(int N, int[] A) {
        int[] arr = new int[N];
        int unActivemax = 0, activeMax = 0;
        for (int n : A) {
            if (n == N + 1)
                activeMax = unActivemax;
            else {
                if (arr[n - 1] < activeMax) 
                    arr[n - 1] = activeMax;
                arr[n - 1]++;
                if (arr[n - 1] > unActivemax)
                    unActivemax = arr[n - 1];
            }
        }
        for (int i = 0; i < N; i++) {
            if (arr[i] < activeMax)
                arr[i] = activeMax;
        }
        return arr;
    }
}