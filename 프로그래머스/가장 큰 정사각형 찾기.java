public class Solution {
    public int solution(int [][]board) {
        int maximum = 0;
        // (0,0), (1,0), (0,1), (1,1) 중 존재하는 것들의 가장 큰 값을 최대값의 초기값으로
        for (int i = 0; i < Math.min(2, board.length); i++) {
            for (int j = 0; j < Math.min(2, board[i].length); j++)
                maximum = Math.max(board[i][j], maximum);
        }
        // (1,1)부터 마지막까지 (왼쪽 대각선 위, 왼쪽, 오른쪽) 숫자들 중 최솟값+1이 해당 시점의 최대 크기 정사각형 변의 길이
        // 단 해당 위치의 수가 0이면 전에 무슨 수가 나왔던 해당 자리는 0
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                int check = Math.min(board[i-1][j-1], Math.min(board[i-1][j], board[i][j-1]));
                board[i][j] = (board[i][j] == 0) ? 0 : check+1;
                // 최대값을 끝나고 다시 찾으면 비효율적이므로 계속 최대값 갱신해줌
                maximum = Math.max(maximum, board[i][j]);
            }
        }
        return (int) Math.pow(maximum, 2);
    }
}