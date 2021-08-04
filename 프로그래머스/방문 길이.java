import java.util.Arrays;

public class Solution {
    public int solution(String dirs) {
        // 방문했었는지 체크하는 배열 (앞뒤 지점의 순서바꾼 경우도 체크하기 위한 4차원 배열)
        boolean[][][][] check = new boolean[11][11][11][11];
        // 현재 위치, 정답 카운트
        int[] position = {0, 0};
        int count = 0;
        for (char d : dirs.toCharArray()) {
            switch (d) {
                case 'U':
                    if (position[1] < 5) {
                        // 해당 전후 경로가 방문한적 없는 경로라면 false, 카운트하고 true로 바꿔줌
                        if (!check[position[0]+5][position[1]+5][position[0]+5][position[1]+6]) {
                            count++;
                            check[position[0]+5][position[1]+5][position[0]+5][position[1]+6] = true;
                            check[position[0]+5][position[1]+6][position[0]+5][position[1]+5] = true;
                        }
                        // 범위를 넘지 않았다면 명령대로 현재 위치 옮겨줌
                        position[1]++;
                    }
                    break;
                case 'D':
                    if (position[1] > -5) {
                        if (!check[position[0]+5][position[1]+5][position[0]+5][position[1]+4]) {
                            count++;
                            check[position[0]+5][position[1]+5][position[0]+5][position[1]+4] = true;
                            check[position[0]+5][position[1]+4][position[0]+5][position[1]+5] = true;
                        }
                        position[1]--;
                    }
                    break;
                case 'L':
                    if (position[0] > -5) {
                        if (!check[position[0]+5][position[1]+5][position[0]+4][position[1]+5]) {
                            count++;
                            check[position[0]+5][position[1]+5][position[0]+4][position[1]+5] = true;
                            check[position[0]+4][position[1]+5][position[0]+5][position[1]+5] = true;
                        }
                        position[0]--;
                    }
                    break;
                case 'R':
                    if (position[0] < 5) {
                        if (!check[position[0]+5][position[1]+5][position[0]+6][position[1]+5]) {
                            count++;
                            check[position[0]+5][position[1]+5][position[0]+6][position[1]+5] = true;
                            check[position[0]+6][position[1]+5][position[0]+5][position[1]+5] = true;
                        }
                        position[0]++;
                    }
            }
        }
        return count;
    }
}