import java.util.ArrayList;
import java.util.List;

class Solution {
    private void dfs(List<String> answer, int open, int close, String str) {
        // 괄호 개수 제한을 넘어가거나, 여는 괄호보다 닫는 괄호의 남은 수가 더 많을 경우 탈락
        if (open < 0 || open > close)
            return;
        // 정답 체크
        if (open == 0 && close == 0) {
            answer.add(str);
            return;
        }
        // 여는 괄호, 닫는 괄호 경우의 수 모두 DFS
        dfs(answer, open-1, close, str+"(");
        dfs(answer, open, close-1, str+")");
    }

    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        // 올바른 괄호가 되려면 무조건 시작은 여는 괄호로 시작해야 한다
        dfs(answer, n-1, n, "(");
        return answer;
    }
}