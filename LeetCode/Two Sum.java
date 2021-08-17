import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        // 해당 값과 인덱스를 같이 보관할 map
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // nums[i]의 값과 짝을 이룰수 있는 값
            int pair = target - nums[i];
            // 이미 전순서에 넣어져있다면 정답 반환
            if (map.containsKey(pair)) {
                answer[0] = i;
                answer[1] = map.get(pair);
                break;
            }
            // 아직 해당 수의 짝의 값이 map에 없으면 해당 수 넣고 조회 재개
            else
                map.put(nums[i], i);
        }
        return answer;
    }
}