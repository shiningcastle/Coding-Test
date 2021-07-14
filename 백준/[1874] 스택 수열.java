import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    private static String stackSequence(int n, Queue<Integer> input) {
        StringBuilder strBuilder = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= n; i++) {
            int check = input.peek().intValue();
            if (i <= check) {
                strBuilder.append("+");
                strBuilder.append(System.getProperty("line.separator"));
                stack.push(i);
            }
            if (i == check) {
                // 안에 int가 아닌 Integer들이 들어서 intValue() 사용안하면 값이아닌 객체의 주소 같은지 비교가 됨
                // 웬만한 입력에서는 잘 돌아가는 이유는, 자바의 경우 -128부터 127까지의 Integer 객체는 미리 만들어두고
                // 이 범위 내의 값을 가질 경우 해당 객체를 사용하고, 그 외의 경우에만 새로운 객체를 만듭니다.
                while(input.peek().intValue() == stack.peek().intValue()) {
                    strBuilder.append("-");
                    input.poll();
                    stack.pop();
                    if (input.size() == 0) {
                        break;
                    }
                    strBuilder.append(System.getProperty("line.separator"));
                    if (stack.size() == 0) {
                        break;
                    }
                    if (input.peek().intValue() < stack.peek().intValue()) {
                        return "NO";
                    }
                }
            }
        }
        return strBuilder.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> input = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            input.offer(Integer.parseInt(br.readLine()));
        }
        System.out.println(stackSequence(n, input));
    }
}