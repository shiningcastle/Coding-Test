import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    private static int findMaxValue(int n, int[] arr) {
        int[][] matrix = new int[n+1][2];
        matrix[1][0] = arr[1]; // 첫 계단은 1가지 경우뿐
        for (int i = 2; i <= n; i++) {
            // 0은 바로 앞 계단을 밟지 않는 경우, 전전의 계단의 두개의 경우 모두 가능
            matrix[i][0] = arr[i] + Math.max(matrix[i-2][0], matrix[i-2][1]);
            // 1은 바로 앞 계단을 밟는 경우, 그래서 전계단이 전전계단을 밟지 않는 경우[0]만 해당
            matrix[i][1] = arr[i] + matrix[i-1][0];
        }
        return Math.max(matrix[n][0], matrix[n][1]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        br.close();
        System.out.println(findMaxValue(n, arr));
    }
}