import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        // 트리 노드의 원소가 하나도 없는 경우 제외
        if (root != null)
            queue.offer(root);
        // 큐의 모든 원소를 리스트에 넣을 때까지 반복
        while (!queue.isEmpty()) {
            // 아래 반복문에서 i < queue.size로 하면 가변적이라 변수로 
            int size = queue.size();
            // 안쪽 채워줄 리스트 선언
            List<Integer> list = new ArrayList<>();
            // 현재 시점의 큐 사이즈만큼 반복하면 Level별 개수만큼 리스트에 넣는다
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                list.add(treeNode.val);
                // 만약 자식 트리 노드가 null이면 큐에 넣지 않는다
                if (treeNode.left != null)
                    queue.offer(treeNode.left);
                if (treeNode.right != null)
                    queue.offer(treeNode.right);
            }
            // 만든 리스트를 최종 리스트에 넣는다
            answer.add(list);
        }
        return answer;
    }
}