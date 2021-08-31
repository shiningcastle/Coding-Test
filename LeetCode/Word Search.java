class Solution {
    private boolean[][] visited;

    private boolean dfs(char[][] board, String word, int x, int y, int idx) {
        // 인덱스가 범위를 넘거나, 해당 순서의 글자가 안맞거나, 이미 사용한 글자인 경우 탈락
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(idx) || visited[x][y])
            return false;
        // 위에서 통과했고 마지막 순서 글자면 정답 존재
        if (idx == word.length() - 1)
            return true;
        // 중복사용 안하도록 체크
        visited[x][y] = true;
        // 상하좌우 체크해서 한쪽이라도 만족하면 true로 계속 진행
        if (dfs(board, word, x - 1, y, idx + 1) || dfs(board, word, x + 1, y, idx + 1)
            || dfs(board, word, x, y - 1, idx + 1) || dfs(board, word, x, y + 1, idx + 1))
            return true;
        // 상하좌우에 맞는 케이스가 없는 경우 방문 배열 원복하고 false
        visited[x][y] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int vertical = board.length;
        int horizontal = board[0].length;
        visited = new boolean[vertical][horizontal];
        // DFS로 모든 지점에서 스타트
        for (int i = 0; i < vertical; i++) {
            for (int j = 0; j < horizontal; j++) {
                // 원래 순서, 역순의 단어와 첫글자가 일치할 경우 DFS실시, 방문 여부 배열은 매번 초기화
                if (dfs(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }
}