import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        // 뽑은 인형 담을 바구니 스택
        Stack<Integer> basket = new Stack<>();
        for (int m : moves) {
            for (int i = 0; i < board.length; i++) {
                // 인형이 있을 때만 뽑기
                if (board[i][m-1] != 0) {
                    // 바구니에 인형이 존재하고, 뽑은 인형과 바구니 위의 인형이 일치
                    if (!basket.isEmpty() && basket.peek() == board[i][m-1]) {
                        // 바구니에서 인형 제거, 격자에서 인형 제거, 두개씩 사라짐
                        basket.pop();
                        board[i][m-1] = 0;
                        answer += 2;
                        break;
                    // 뽑은 인형과 바구니 위의 인형이 불일치
                    } else {
                        // 바구니에 인형 넣기, 격자에서 인형 제거
                        basket.push(board[i][m-1]);
                        board[i][m-1] = 0;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}