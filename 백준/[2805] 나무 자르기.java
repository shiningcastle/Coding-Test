import java.io.IOException;
import java.util.Scanner;

class Main {
    private int findHeight(int m, int[] trees) {
        // 최대 가능한 높이, 찾을 최소 & 최대 범위
        int max = 0, left = 0, right = 999999999, height = 0;
        while (left <= right) {
            // 높이 범위 중간 지점을 기준으로, 획득한 나무 높이
            height = (left + right) / 2;
            long earned = 0;
            // 높이가 height 이하인 나무는 획득량 0
            for (int t : trees)
                earned += (t - height <= 0) ? 0 : t - height;
            // 우연히 찾으면 반환
            if (earned == m)
                return height;
            // 얻은게 목표보다 적으면 최고 높이 height보다 낮게, 반대면 높게하고 높이 최대값 갱신
            if (earned < m) {
                right = height-1;
            } else {
                left = height+1;
                max = height;
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] trees = new int[n];
        for (int i = 0; i < n; i++)
            trees[i] = sc.nextInt();
        sc.close();
        Main main = new Main();
        System.out.println(main.findHeight(m, trees));
    }
}