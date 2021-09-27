import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    private static int ascending(int n) {
        int[][] matrix = new int[n+1][10];
        // 자리수 = 1 경우는 끝자리가 0~9인 모든 경우의 수 각각 1가지씩
        for (int j = 0; j <= 9; j++)
            matrix[1][j] = 1;
        // 자리수 = 2~n 경우는 하나 작은 자리수의 끝자리 0~n까지 경우 모두 더한 값
        for (int i = 2; i <= n; i++) {
            int sum = 0;
            for (int j = 0; j <= 9; j++) {
                sum += matrix[i-1][j];
                matrix[i][j] = sum % 10007; // int 범위 안넘게 매번 10007로 나눠준다
            }
        }
        int answer = 0;
        // 정답 구하기
        for (int i = 0; i <= 9; i++)
            answer += matrix[n][i];
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(ascending(Integer.parseInt(br.readLine())));
        br.close();
    }
}