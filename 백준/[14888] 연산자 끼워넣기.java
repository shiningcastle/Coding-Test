import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    private static int max = -1000000000, min = 1000000000;
    // 사칙 연산 처리
    private int calculator(int tmp, int i, int idx, int[] nums) {
        switch (i) {
            case 0:
                tmp += nums[idx];
                break;
            case 1:
                tmp -= nums[idx];
                break;
            case 2:
                tmp *= nums[idx];
                break;
            case 3:
                tmp /= nums[idx];
        }
        return tmp;
    }
    
    private void findMaxMin(int n, int[] nums, int[] operators, int idx, int sum) {
        // 식이 완성된 경우 해당 식의 결과값으로 최대값, 최소값 갱신 후 종료
        if (idx == n) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }
        for (int i = 0; i < operators.length; i++) {
            // 해당 연산 기호를 모두 소진한 경우 스킵
            if (operators[i] <= 0)
                continue;
            // 연산한 것을 다시 되돌리기 어려우므로 값을 복사해서 연산 후 전달하여 복구 안해도 된다
            int tmp = sum;
            // 해당 연산자 사용 표시 후에 다음 연산자와 숫자 넣도록 재귀호출, 다시 해당 연산자 미사용 처리
            operators[i]--;
            findMaxMin(n, nums, operators, idx + 1, calculator(tmp, i, idx, nums));
            operators[i]++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // String으로 입력된 배열의 원소들을 int로 바꾼 배열 생성
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] operators = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();
        Main main = new Main();
        main.findMaxMin(n, nums, operators, 1, nums[0]);
        System.out.println(max);
        System.out.print(min);
    }
}