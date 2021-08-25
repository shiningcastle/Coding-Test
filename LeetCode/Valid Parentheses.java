import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        boolean answer = false;
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : arr) {
            switch (c) {
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(')
                        return answer;
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{')
                        return answer;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[')
                        return answer;
                    break;
                default:
                    stack.push(c);
            }
        }
        answer = (stack.isEmpty()) ? true : false;
        return answer;
    }
}