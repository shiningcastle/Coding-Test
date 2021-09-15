import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    private static int countGoodCase(int n, int[] nums) {
        int answer = 0;
        for (int i = 0; i < n; i++)
            answer += (isGood(n, nums, i, nums[i])) ? 1 : 0;
        return answer;
    }
    // 한가지 케이스라도 찾았는지 여부
    private static boolean isGood(int n, int[] nums, int i, int target) {
        // 짝숫자를 빨리 찾기위한 Map
        Set<Integer> set = new HashSet<>();
        for (int j = 0; j < n; j++) {
            if (i == j) // 더할 두 숫자가 같은 수를 가르키는 경우 제외
                continue;
            // 지나간 수와 더해서 target 숫자를 만들 수 있는 숫자 발견, 알리고 중단
            if (set.contains(nums[j]))
                return true;
            // 못만드는 경우 해당 수와 짝이 되는 수를 수배목록에 추가
            else
                set.add(target - nums[j]);
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(st.nextToken());
        br.close();
        System.out.println(countGoodCase(n, nums));
    }
}