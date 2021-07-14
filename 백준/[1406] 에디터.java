import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());
        // 입력받은 문자열은 left스택에 넣어주고, 명령에 따라 right스택과 서로 주고 받는다.
        Stack<String> rightStack = new Stack<>();
        Stack<String> leftStack = new Stack<>();
        for (String chr : str.split("")) {
            leftStack.push(chr);
        }
        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            switch (command) {
                case "L" :
                    if (!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                    break;
                case "D" :
                    if (!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }
                    break;
                case "B" :
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                    break;
                default :
                    leftStack.push(String.valueOf(command.charAt(2)));
            }
        }
        // 출력값은 left 스택의 맨 아래 원소부터이다. 그리고 right 스택의 원소와 합쳐야 하므로
        // left 스택값들을 right 스택으로 옮겨주면 원래 출력할 문자열 순서가 된다.
        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }
        // right 스택 문자열을 위에서 부터 pop한다. 출력을 빠르게하기 위해 BufferedWriter 사용
        while (!rightStack.isEmpty()) {
            bw.write(rightStack.pop());
        }
        // 모두 출력하고 버퍼를 비움
        bw.flush();
        bw.close();
    }
}