import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Main {
    private void sortScore(String[] names, Map<String, int[]> map) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 조건대로 정렬
        Arrays.sort(names, (o1, o2) -> {
            int[] score1 = map.get(o1), score2 = map.get(o2);
            // 국어 점수 낮은 경우
            if (score1[0] < score2[0])
                return 1;
                // 국어 점수 높은 경우
            else if (score1[0] > score2[0])
                return -1;
                // 국어 점수 같으면 영어 점수 오름차순
            else {
                if (score1[1] < score2[1])
                    return -1;
                else if (score1[1] > score2[1])
                    return 1;
                    // 영어 점수 같으면 수학 점수 내림차순
                else {
                    if (score1[2] < score2[2])
                        return 1;
                    else if (score1[2] > score2[2])
                        return -1;
                        // 수학 점수 같으면 이름 사전순 오름차순
                    else
                        return o1.compareTo(o2);
                }
            }
        });
        // 정렬 완료된 배열로 문자열 만들기
        for (String name : names) {
            bw.write(name);
            bw.write('\n');
        }
        // 완성된 정답 문자열 출력
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] names = new String[n];
        /*
           comparator 사용시 해당 이름의 점수들을 찾기위한 인덱스를 사용할 수 없으므로
           HashMap으로 이름으로 점수를 조회할 수 있게 만들어서 사용
        */
        Map<String, int[]> map = new HashMap();
        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");
            names[i] = arr[0];
            int[] scores = new int[3];
            scores[0] = Integer.parseInt(arr[1]);
            scores[1] = Integer.parseInt(arr[2]);
            scores[2] = Integer.parseInt(arr[3]);
            map.put(names[i], scores);
        }
        br.close();
        Main main = new Main();
        main.sortScore(names, map);
    }
}