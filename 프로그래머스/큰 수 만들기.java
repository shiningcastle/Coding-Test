import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            // 뒤의 수가 앞의 stack의 수보다 크면 stack에서 작은 수 제거
            while (!stack.isEmpty() && stack.peek() < c && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        // k만큼 위에서 제거 못했으면 뒤에서 남은 수 만큼 빼주기
        for (int i = 0; i < result.length; i++)
            result[i] = stack.get(i);
        return new String(result);
    }
}