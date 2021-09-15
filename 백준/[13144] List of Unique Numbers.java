import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    private static long findUniqueCase(int n, int[] nums) {
        long answer = 0;
        // 해당 수 등장했었는지 개수 표시하는 배열
        int[] check = new int[n + 1];
        // 다음 수를 확인하고 중복아닌 경우만 right 증가시키기 위해 -1로 초기화해 0부터 확인
        for (int left = 0, right = -1; left < n; left++) {
            // 다음 수가 중복이 아니면 right+1, check도 해당 수 카운트
            while (right < n - 1 && check[nums[right+1]] == 0)
                check[nums[++right]]++;
            // 반복문 탈출시, 정답 카운트하고 해당 left 숫자 등장 숫자에서 지우기
            answer += (right - left + 1);
            check[nums[left]]--;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(st.nextToken());
        br.close();
        System.out.println(findUniqueCase(n, nums));
    }
}