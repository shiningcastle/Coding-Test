class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (char a : arr) {
            if (a == ')' && !stack.isEmpty() && stack.peek() == '(')
                stack.pop();
            else
                stack.push(a);
        }
        return (stack.size() != 0) ? false : true;
    }
}