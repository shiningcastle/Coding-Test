import java.util.ArrayList;
import java.util.List;

class Solution {
    private void dfs(List<List<Integer>> answer, List<Integer> oneCase, int[] nums, int limit) {
        answer.add(new ArrayList<>(oneCase));
        for (int i = limit; i < nums.length; i++) {
            oneCase.add(nums[i]);
            dfs(answer, oneCase, nums, i + 1);
            oneCase.remove(oneCase.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        dfs(answer, new ArrayList<>(), nums, 0);
        return answer;
    }
}