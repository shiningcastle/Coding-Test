import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static long countSupervisor(String[] studentNum, int main, int sub) {
        long answer = 0;
        for (String n : studentNum) {
            // 주 감독관 처리 후
            long afterMain = Integer.parseInt(n) - main;
            answer++;
            // 주 감독관 혼자 처리 가능
            if (afterMain <= 0)
                continue;
            // 부 감독관 처리
            answer += (afterMain / sub);
            answer += (afterMain % sub == 0) ? 0 : 1;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer.parseInt(br.readLine());
        String[] studentNum = br.readLine().split(" ");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int main = Integer.parseInt(st.nextToken()), sub = Integer.parseInt(st.nextToken());
        System.out.print(countSupervisor(studentNum, main, sub));
    }
}