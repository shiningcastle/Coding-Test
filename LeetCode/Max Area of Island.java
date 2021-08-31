class Solution {
    // 전체 2차원 배열의 가로, 세로, 해당 지점 방문 여부
    private int ver, hor;
    private boolean[][] visited;

    // dfs로 해당 섬의 면적을 반환
    private int dfs(int[][] grid, int i, int j) {
        // 지정된 범위를 넘거나, 물이거나, 이미 체크한 지점인 경우 +0
        if (i < 0 || i >= ver || j < 0 || j >= hor || grid[i][j] == 0 || visited[i][j] == true)
            return 0;
        // 방문 체크
        visited[i][j] = true;
        // 상하좌우 체크 + 현재 지점 = 전체 면적
        return dfs(grid, i - 1, j) + dfs(grid, i + 1, j) + dfs(grid, i, j - 1) + dfs(grid, i, j + 1) + 1;
    }

    public int maxAreaOfIsland(int[][] grid) {
        // 받은 2차원 배열의 정보로 가로, 세로, 해당 지점 방문 여부 세팅
        ver = grid.length;
        hor = grid[0].length;
        visited = new boolean[ver][hor];
        int max = 0;
        for (int i = 0; i < ver; i++) {
            for (int j = 0; j < hor; j++) {
                if (grid[i][j] == 1 && visited[i][j] == false)
                    // 나온 해당 섬의 전체 면적을 최대값과 비교해 갱신
                    max = Math.max(dfs(grid, i, j), max);
            }
        }
        return max;
    }
}