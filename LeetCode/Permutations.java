import java.util.ArrayList;
import java.util.List;

class Solution {
    private void dfs(List<List<Integer>> answer, List<Integer> oneCase, int[] nums, boolean[] used) {
        // 한개의 경우의 수가 완성되어 추가
        // 해당 케이스 리스트는 새로운 리스트에 담아서 넣기, 뒤의 원소 지우고 재사용되기 때문
        if (oneCase.size() == nums.length) {
            answer.add(new ArrayList<>(oneCase));
            return;
        }
        // 조합 만들기
        for (int i = 0; i < nums.length; i++) {
            // 해당 원소가 이미 앞쪽에 들어있으면 스킵
            if (used[i])
                continue;
            used[i] = true;
            oneCase.add(nums[i]);
            // 다음 차례 원소 찾아 넣기
            dfs(answer, oneCase, nums, used);
            // n개 모두 채워서 정답처리했으면 끝 원소 제거해서 다른 원소 넣어 반복
            used[i] = false;
            oneCase.remove(oneCase.size()-1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        // 해당 순서의 원소 사용했는지 체크하는 배열
        boolean[] used = new boolean[nums.length];
        dfs(answer, new ArrayList<>(), nums, used);
        return answer;
    }
}