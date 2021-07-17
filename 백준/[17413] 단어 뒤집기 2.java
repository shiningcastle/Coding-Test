import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        // 태그 안인지 알려주는 변수
        boolean flag = false;

        for (char ch : input) {
            // 태그 시작
            if (ch == '<') {
                // 앞에 글자들 아직 뒤집어서 정답에 반영 안했으면 처리
                while (!stack.isEmpty())
                    answer.append(stack.pop());
                answer.append('<');
                flag = true;
            // 태그 종료
            } else if (ch == '>') {
                answer.append('>');
                flag = false;
            // 태그 안의 내용은 그대로 넣기
            } else if (flag) {
                answer.append(ch);
            // 태그 밖일 때, 공백 만났을 경우
            } else if (ch == ' ') {
                // 공백 직전까지 글자를 뒤집어서 넣어줌 = 스택에서 pop()
                while (!stack.isEmpty())
                    answer.append(stack.pop());
                answer.append(' ');
            // 태그 밖에서 공백아닌 글자들은 전부 스택에 넣어줌
            } else {
                stack.push(ch);
            }
        }
        // for문을 다돌았을때 아직 처리안된 stack의 글자들을 뒤집어서 넣기
        while (!stack.isEmpty())
            answer.append(stack.pop());
        System.out.print(answer);
    }
}