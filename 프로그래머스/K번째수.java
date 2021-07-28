import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++) {
            answer[i] = Arrays.stream(array).skip(commands[i][0]-1)
                    .limit(commands[i][1]-commands[i][0]+1).sorted().skip(commands[i][2]-1).limit(1).sum();
        }
        return answer;
    }
}