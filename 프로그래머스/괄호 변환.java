import java.util.Stack;

class Solution {
    // 문자열 s에서 어디까지 작업했는지 인덱스
    private int idx = 0;
    // 올바른 괄호인지 체크, 처음부터 끝까지 한번에 체크 안하고 잘라서 붙임
    private boolean isCorrect(String s) {
        Stack<Character> stack = new Stack<>();
        // 왼쪽, 오른쪽 방향 괄호의 개수 체크
        int left = 0, right = 0;
        boolean check = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
                left++;
            } else {
                right++;
                // 올바른 괄호가 아니더라도 '(',')'의 개수가 맞도록 맞춰야해서 return 안하고 반복 ()(())()
                if (stack.isEmpty())
                    check = false;
                else
                    stack.pop();
            }
            if (left == right) {
                // 다음 번에 체크할 시작점 갱신
                idx = i + 1;
                return check;
            }
        }
        // 여기는 조건상 올 수 없다.
        return true;
    }

    public String solution(String p) {
        // 입력이 빈 문자열
        if (p.isEmpty())
            return p;
        // 올바른 괄호인 경우
        boolean correct = isCorrect(p);
        // 올바른 괄호 아닌 경우
        StringBuilder u = new StringBuilder(p.substring(0, idx));
        StringBuilder v = new StringBuilder(p.substring(idx));
        // u가 올바른 괄호인 경우
        if (correct)
            return u.append(solution(v.toString())).toString();
        // u가 올바른 괄호가 아닌 경우
        StringBuilder tmp = new StringBuilder();
        // v 처리
        tmp.append('(').append(solution(v.toString())).append(')');
        // u의 첫, 마지막 글자는 빼고 괄호들 뒤집어서 처리한 v 뒤에 붙이기
        for (int i = 1; i < u.length()-1; i++) {
            char c = u.charAt(i);
            if (c == '(')
                tmp.append(')');
            else
                tmp.append('(');
        }
        return tmp.toString();
    }
}