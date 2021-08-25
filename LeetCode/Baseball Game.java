import java.util.Stack;

class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for (String op : ops) {
            switch (op) {
                case "C":
                    answer -= stack.pop();
                    break;
                case "D":
                    int tmp = stack.peek() * 2;
                    stack.push(tmp);
                    answer += tmp;
                    break;
                case "+":
                    int last = stack.pop(), sum = stack.peek() + last;
                    stack.push(last);
                    stack.push(sum);
                    answer += sum;
                    break;
                // 숫자는 stack에 넣기
                default:
                    int n = Integer.parseInt(op);
                    stack.push(n);
                    answer += n;
            }
        }
        return answer;
    }
}