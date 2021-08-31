class Solution {
    // 최대 level 변수
    private int maxLevel = 0;

    // dfs로 재귀적으로 level의 최대값 갱신
    private void dfs(TreeNode node, int level) {
        // 해당 지점의 노드가 없는 경우
        if (node == null)
            return;
        // 노드가 있는 경우 레벨 카운트
        maxLevel = Math.max(maxLevel, ++level);
        dfs(node.left, level);
        dfs(node.right, level);
    }

    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return maxLevel;
    }
}