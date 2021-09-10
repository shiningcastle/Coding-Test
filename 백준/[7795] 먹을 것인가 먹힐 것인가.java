import java.util.Arrays;
import java.util.Scanner;

class Main {
    private int eatOrEaten(int[][] arr) {
        int[] manyA = arr[0], manyB = arr[1];
        int answer = 0, lenA = manyA.length, lenB = manyB.length;
        // b를 정렬
        Arrays.sort(manyB);
        // 이분탐색 시행
        for (int i = 0; i < lenA; i++) {
            int left = 0, right = lenB - 1, idx = 0;
            // 왼쪽 경계가 오른쪽 경계보다 커지면 종료
            while (left <= right) {
                idx = (left + right) / 2;
                // 현재 위치의 B의 값이 A의 값보다 작은 경우, 왼쪽 경계 갱신
                if (manyA[i] > manyB[idx])
                    left = idx + 1;
                    // 현재 위치의 B의 값이 A의 값보다 크거나 같은 경우, 오른쪽 경계 갱신
                else
                    right = idx - 1;
            }
            // 타겟 숫자와 가장 근접한 B의 인덱스 숫자가 타겟 숫자보다 작으면 그 수도 카운트해준다
            answer += (manyA[i] > manyB[idx]) ? idx + 1 : idx;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();
        int n = sc.nextInt();
        int[][] arr = new int[2][];
        for (int i = 0; i < n; i++) {
            int numA = sc.nextInt(), numB = sc.nextInt();
            int[] manyA = new int[numA], manyB = new int[numB];
            for (int j = 0; j < numA; j++)
                manyA[j] = sc.nextInt();
            for (int k = 0; k < numB; k++)
                manyB[k] = sc.nextInt();
            arr[0] = manyA;
            arr[1] = manyB;
            System.out.println(main.eatOrEaten(arr));
        }
        sc.close();
    }
}