import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    private String sequenceSort(int n, int[][] b) {
        StringBuilder sb = new StringBuilder();
        // B를 조건대로 정렬
        Arrays.sort(b, (o1, o2) -> {
            // 값으로 오름차순
            if (o1[0] != o2[0])
                return o1[0] - o2[0];
            // 값이 같다면 인덱스로 오름차순
            return o1[1] - o2[1];
        });
        int[] p = new int[n];
        // B를 돌면서 P를 만들기
        for (int i = 0; i < n; i++)
            p[b[i][1]] = i;
        // P의 원소를 순서대로 꺼내 정답 문자열 만들기
        for (int s : p)
            sb.append(s).append(' ');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] b = new int[n][2];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            b[i][0] = num;
            b[i][1] = i;
        }
        sc.close();
        Main main = new Main();
        System.out.print(main.sequenceSort(n, b));
    }
}