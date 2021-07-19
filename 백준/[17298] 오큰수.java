import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 입력 받은 숫자들을 int 배열로 변환
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            // 스택에 넣은 위치 인덱스가 존재하면 그걸로 값을 가져와 현재 원소와 비교한다
            // 만약 현재 원소가 더 크면 스택의 원소를 제거하면서 배열의 해당 위치 값을 현재 원소로 바꾼다
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                arr[stack.pop()] = arr[i];
            }
            // 현재 원소가 더 작거나, 스택에 비교할 수가 없으면 현재의 원소를 넣는다
            stack.push(i);
        }
        // 스택에 남아 있는 인덱스는 오큰수가 없는 것들이므로 스택에서 모두 뽑아서 해당 배열 값을 -1로 바꿈
        while (!stack.isEmpty()) {
            arr[stack.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num).append(" ");
        }
        System.out.print(sb);
    }
}