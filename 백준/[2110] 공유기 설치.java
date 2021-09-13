import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    // 해당 거리만큼 떨어진 공유기 C개 이상 설치 가능한지 판별
    private boolean isPossible(int n, int c, int[] houses, int distance) {
        // 설치한 공유기 수, 직전 공유기 위치, 최초 시작점에 하나 설치 고정(최대한 많이 설치하려면 되는대로 설치)
        int count = 1, before = houses[0];
        for (int i = 1; i < n; i++) {
            if (houses[i] - before >= distance) {
                count++;
                before = houses[i];
            }
        }
        return count >= c;
    }

    private int findRouterDistance(int n, int c, int[] houses) {
        // 집들을 좌표순으로 정렬
        Arrays.sort(houses);
        // 문제를 거꾸로 생각해서 공유기를 c개 놓는게 가능한 거리중 최대값을 구함
        int left = 0, right = 1000000000, max = 0;
        while (left <= right) {
            int distance = (left + right) / 2;
            // 해당 거리간격으로 공유기를 c개 이상 설치가능 OR 불가능
            if (isPossible(n, c, houses, distance)) {
                left = distance+1;
                max = distance;
            } else {
                right = distance-1;
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
        int[] houses = new int[n];
        for (int i = 0; i < n; i++)
            houses[i] = Integer.parseInt(br.readLine());
        br.close();
        Main main = new Main();
        System.out.println(main.findRouterDistance(n, c, houses));
    }
}