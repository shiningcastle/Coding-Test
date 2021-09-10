import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main {
    private String twoLiquid(int n, Integer[] nums) {
        int min = Integer.MAX_VALUE, num1 = 0, num2 = 0;
        // 절대값 기준으로 정렬, 음수와 양수 관계없이 절대값 크기가 비슷한 것끼리 모이게 한다
        Arrays.sort(nums, Comparator.comparingInt(Math::abs));
        // 정답 찾기
        for (int i = 0; i < n - 1; i++) {
            // 두 인접한 정수의 합의 절대값, 합의 절대값의 최소값이 0에 가장 가까운 값이다
            int absSum = Math.abs(nums[i] + nums[i + 1]);
            // 지금까지 중에 최소값이면 최소값, 두 숫자 갱신
            if (absSum < min) {
                min = absSum;
                num1 = nums[i];
                num2 = nums[i + 1];
            }
        }
        return Math.min(num1, num2) + " " + Math.max(num1, num2); // 오름차순
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        br.close();
        Main main = new Main();
        System.out.println(main.twoLiquid(N, arr));
    }
}