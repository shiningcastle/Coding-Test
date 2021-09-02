import java.util.*;

class Solution {
    // 괄호 짝의 개수가 맞고 형태가 올바른지 체크
    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(')
                count++;
            else if (c == ')') {
                // )가 (보다 먼저 나오면 탈락
                if (count == 0)
                    return false;
                count--;
            }
        }
        return count == 0;
    }

    public List<String> removeInvalidParentheses(String s) {
        Queue<String> queue = new LinkedList<>();
        Set<String> exist = new HashSet<>();
        List<String> list = new ArrayList<>();
        // 이미 해당 순서에서 답을 찾았으면 더는 제거 안하도록
        boolean notFound = true;
        // 체크할 대상인 큐에 넣고, 중복체크할 Set에도 넣어준다
        queue.offer(s);
        exist.add(s);
        // BFS 시행
        while (!queue.isEmpty() && notFound) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                String check = queue.poll();
                // 올바른 괄호 체크, 찾으면 true, 리스트에 정답 넣기
                if (isValid(check)) {
                    notFound = false;
                    list.add(check);
                }
                // 한글자씩 제거한 문자열 재생성해서 중복 아니면 Set와 Queue에 넣기
                // 앞에서 최초 정답 찾았으면 더이상 제거한 단어 재생산 필요 없으므로 중단
                for (int j = 0; j < check.length() && notFound; j++) {
                    String newWord = check.substring(0, j) + check.substring(j+1);
                    if (!exist.contains(newWord)) {
                        exist.add(newWord);
                        queue.offer(newWord);
                    }
                }
            }
        }
        return list;
    }
}