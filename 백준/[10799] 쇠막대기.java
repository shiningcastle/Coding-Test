import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        // 쌓인 막대 수, 문자열 현재 인덱스, 정답 개수
        int stick = 0, idx = 0, answer = 0;
        while (idx < input.length) {
            // 여는 괄호를 만나면 레이저인지 그냥 막대인지 구분
            if (input[idx] == '(') {
                // 인덱스가 최대 범위 넘는 경우에 에러뜨는 것 방지로 체크
                if (idx+1 < input.length) {
                    // 바로 뒤에 ')'가 나오면 레이저
                    if (input[idx+1] == ')') {
                        answer += stick;
                        idx += 2;
                    // 아니면 막대 추가
                    } else {
                        stick++;
                        idx++;
                    }
                }
            // ')'가 나오면 레이저는 위에서 모두 걸러지므로 끝나는 막대
            } else {
                stick--;
                answer++;
                idx++;
            }
        }
        System.out.print(answer);
    }
}