class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        for (int i = 3; i <= sum/3; i++) {
            int width = sum / i, height = sum / width;
            if (((width - 2) * (height - 2)) == yellow && width >= height) {
                answer[0] = width;
                answer[1] = height;
                return answer;
            }
        }
        return answer;
    }
}