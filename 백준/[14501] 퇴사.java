import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 최대값, 상담 일정과 보수 배열
    public static int max = 0;
    public static int[][] counsel;

    public static void resign(int n, int day, int pay) {
        // 날짜한도를 다 채운 경우 각 경우의 수별 보수가 최대값인지 판별, 갱신하고 재귀 종료
        if (n == day) {
            max = Math.max(max, pay);
            return;
        }
        // 해당 순서의 날짜 선택한 경우, 단 날짜 범위를 넘는 경우 아래의 day+1만 해준다
        if (n >= day + counsel[day][0])
            resign(n, day + counsel[day][0], pay + counsel[day][1]);
        // 해당 순서의 날짜 선택하지 않고 다음 날짜로 간 경우
        resign(n, day + 1, pay);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        counsel = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split(" ");
            counsel[i][0] = Integer.parseInt(tmp[0]);
            counsel[i][1] = Integer.parseInt(tmp[1]);
        }
        resign(n, 0, 0);
        System.out.print(max);
    }
}