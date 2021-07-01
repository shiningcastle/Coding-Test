import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int luckBalance(int n, int k, int[][] arr) {
        int answer = 0;
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Integer.compare(o2[0], o1[0]);
            } else {
                return Integer.compare(o2[1], o1[1]);
            }
        });
        
        for (int i = 0; i < n; i++) {
            int standard = arr[i][1];
            if (k > 0 && standard == 1) {
                answer += arr[i][0];
                k--;
            } else if (standard == 1) {
                answer -= arr[i][0];
            } else {
                answer += arr[i][0];
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st2.nextToken());
            arr[i][1] = Integer.parseInt(st2.nextToken());
        }
        br.close();
        System.out.println(luckBalance(n, k, arr));
    }
}