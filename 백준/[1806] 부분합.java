import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    private int findShortest(int n, int s, int[] nums) {
        // 정답 길이의 최대 가능한 값은 n이므로, 성립 안되는 경우 판별을 위해 초기값을 n+1
        int min = n+1, right = 0, sum = nums[0];
        for (int i = 0; i < n; i++) {
            // 첫기준 시작 케이스는 전 순서의 숫자를 누적합에서 빼주는게 아님
            if (i != 0)
                sum -= nums[i-1];
            // 오른쪽에 더할 수가 더이상 없거나, 이미 s보다 누적합이 클때까지 더하기
            while (right + 1 < n && sum < s) {
                right++;
                sum += nums[right];
            }
            // 합계가 s보다 크다면 길이 최소값 갱신, 위에서 s보다 작아도 수를 다 더해서 내려오는 것 예외처리
            if (sum >= s)
                min = Math.min(min, right-i+1);
        }
        return (min == n+1) ? 0 : min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()), s = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(st2.nextToken());
        br.close();
        Main main = new Main();
        System.out.println(main.findShortest(n, s, nums));
    }
}