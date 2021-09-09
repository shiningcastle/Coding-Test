import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    private long maxCard(int n, long[] nums) throws IOException {
        // 정렬 해주기
        Arrays.sort(nums);
        long maxNum = nums[0];
        int maxCount = 1, curCount = 1;
        /** 정렬하면 해당 순서 숫자는 전 순서 숫자와 다르면 새로운 숫자 시작
         *  같으면 연속된 숫자가 이어지고 있는 것
         */
        for (int i = 1; i < n; i++) {
            // 새로운 숫자 나오면 누적 카운트 1로
            if (nums[i-1] != nums[i]) {
                curCount = 1;
            // 같은 숫자 나오면 누적 카운트+1, 최빈값이면 최대 카운트, 최대 값 갱신
            } else {
                curCount++;
                if (maxCount < curCount) {
                    maxCount = curCount;
                    maxNum = nums[i];
                }
            }
        }
        return maxNum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] nums = new long[n];
        for (int i = 0; i < n; i++)
            nums[i] = Long.parseLong(br.readLine());
        br.close();
        Main main = new Main();
        System.out.print(main.maxCard(n, nums));
    }
}