class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        // 정답 배열 생성
        int[] answer = new int[queries.length];
        // 초기 행렬 원소 채워서 만들기
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            int tmp = i * columns;
            for (int j = 0; j < columns; j++)
                matrix[i][j] = tmp + j + 1;
        }
        // 행렬 테두리 회전하기
        for (int j = 0; j < queries.length; j++) {
            int[] q = queries[j];
            // 왼쪽 위 기준 숫자 보관 변수, 최소값 변수
            int keep = matrix[q[0]-1][q[1]-1], min = keep;
            // 왼쪽 변
            for (int i = q[0]; i < q[2]; i++) {
                int element = matrix[i][q[1]-1];
                matrix[i-1][q[1]-1] = element;
                min = Math.min(min, element);
            }
            // 아래쪽 변
            for (int i = q[1]; i < q[3]; i++) {
                int element = matrix[q[2]-1][i];
                matrix[q[2]-1][i-1] = element;
                min = Math.min(min, element);
            }
            // 오른쪽 변
            for (int i = q[2]-2; i >= q[0]-1; i--) {
                int element = matrix[i][q[3]-1];
                matrix[i+1][q[3]-1] = element;
                min = Math.min(min, element);
            }
            // 위쪽 변
            for (int i = q[3]-2; i >= q[1]-1; i--) {
                int element = matrix[q[0]-1][i];
                matrix[q[0]-1][i+1] = element;
                min = Math.min(min, element);
            }
            // 보관한 원소 해당 위치 삽입
            matrix[q[0]-1][q[1]] = keep;
            // 최소값 정답 배열에 넣기
            answer[j] = min;
        }
        return answer;
    }
}