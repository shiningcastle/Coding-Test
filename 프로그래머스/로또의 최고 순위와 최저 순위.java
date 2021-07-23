class Solution {
    public int grade(int n) {
            if (n != 0)
                return 7 - n;
            else
                return 6;
        }

        public int[] solution(int[] lottos, int[] win_nums) {
            int[] pick = new int[46];
            int answer = 0;
            for (int p : lottos)
                pick[p]++;
            for (int w : win_nums) {
                if (pick[w] != 0)
                    answer++;
            }
            return new int[] {grade(answer + pick[0]), grade(answer)};
        }
}