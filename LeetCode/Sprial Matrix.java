import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        int rowStart = 0, rowEnd = matrix.length;
        int colStart = 0, colEnd = matrix[0].length;
        // 나선형 회전
        while (answer.size() != (matrix.length * matrix[0].length)) {
            // 위쪽
            for (int i=colStart; i<colEnd; i++)
                answer.add(matrix[rowStart][i]);
            rowStart++;
            // 오른쪽
            for (int i=rowStart; i<rowEnd; i++)
                answer.add(matrix[i][colEnd-1]);
            colEnd--;
            // 아래쪽
            for (int i=colEnd-1; i >=colStart && answer.size() != (matrix.length * matrix[0].length); i--)
                answer.add(matrix[rowEnd-1][i]);
            rowEnd--;
            // 왼쪽
            for (int i=rowEnd-1; i>=rowStart && answer.size() != (matrix.length * matrix[0].length); i--)
                answer.add(matrix[i][colStart]);
            colStart++;
        }
        return answer;
    }
}