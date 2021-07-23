class Solution {
    public int grade(int n) {
            switch (n) {
                case 6:
                    return 1;
                case 5:
                    return 2;
                case 4:
                    return 3;
                case 3:
                    return 4;
                case 2:
                    return 5;
                default :
                    return 6;
            }
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