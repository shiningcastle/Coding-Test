import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        // 1부터 n까지의 원소를 가지는 배열 생성
        Integer[] intArr = new Integer[n];
        for (int i = 0; i < n; i++)
            intArr[i] = i+1;
        StringBuilder sb = new StringBuilder();
        // 만든 배열을 큐로 만들기
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(intArr));
        // 큐의 원소가 모두 사라질 때까지 반복
        while (!queue.isEmpty()) {
            // k번째 사람 순서까지 회전
            for (int i = 0; i < k-1; i++) {
               queue.add(queue.poll());
            }
            // 원소가 1개인 경우는 출력 형태의 예외 케이스라 따로 처리
            if (n == 1)
                sb.append(String.format("<%d>", queue.poll()));
            // 처음 제거된 경우, 마지막 제거된 경우, 그 외의 경우
            else if (queue.size() == n)
                sb.append(String.format("<%d, ", queue.poll()));
            else if (queue.size() == 1)
                sb.append(String.format("%d>", queue.poll()));
            else
                sb.append(String.format("%d, ", queue.poll()));
        }
        System.out.print(sb);
    }
}