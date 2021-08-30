class Solution {
    // 섬 개수, 전체 가로, 세로 길이
    private int count, vertical, horizontal;
    // 방문한 지점을 이미 체크했는지 여부
    private boolean[][] visited;
    // 해당 지점과 상하좌우로 붙어 있어서 같은 섬인 경우 방문 체크
    private void dfs(char[][] grid, int i, int j) {
        // 범위 넘거나, 이미 체크한 땅인 경우
        if (i < 0 || i >= vertical || j < 0 || j >= horizontal || visited[i][j] == true || grid[i][j] == '0')
            return;
        // 아니면 방문 체크하고 상하좌우 체크 반복
        visited[i][j] = true;
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }

    public int numIslands(char[][] grid) {
        vertical = grid.length;
        horizontal = grid[0].length;
        visited = new boolean[vertical][horizontal];
        for (int i = 0; i < vertical; i++) {
            for (int j = 0; j < horizontal; j++) {
                // 해당 지점이 물이 아니고, 전에 체크 안했던 지점인 경우 전체 섬의 수 + 1
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
}