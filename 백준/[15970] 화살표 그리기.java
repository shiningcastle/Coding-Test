import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    private int drawArrow(int n, int[][] arr) {
        int answer = 0;
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] == o2[1])
                return o1[0] - o2[0];
            else
                return o1[1] - o2[1];
        });
        // 반복문 돌면서 체크
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                answer += (arr[1][0] - arr[0][0]);
            } else if (i == n - 1) {
                answer += (arr[n-1][0] - arr[n-2][0]);
            } else {
                // 왼쪽 오른쪽 같은 색
                if (arr[i][1] == arr[i-1][1] && arr[i][1] == arr[i+1][1])
                    answer += Math.min(arr[i][0] - arr[i-1][0], arr[i+1][0] - arr[i][0]);
                // 왼쪽만 같은 색
                else if (arr[i][1] == arr[i-1][1])
                    answer += (arr[i][0] - arr[i-1][0]);
                // 오른쪽만 같은 색
                else
                    answer += (arr[i+1][0] - arr[i][0]);
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }
        br.close();
        Main main = new Main();
        System.out.print(main.drawArrow(n, arr));
    }
}