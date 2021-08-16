import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> answer = new ArrayList<>();
        // start 기준으로 오름차순 정렬
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        // 첫 원소로 기준 만들기
        int start = intervals[0][0], end = intervals[0][1];
        // 두번째 원소부터 조회 시작
        for (int i = 1; i < intervals.length; i++) {
            // 앞의 start가 뒤의 end 이하인 경우, start는 그대로 end는 둘중에 더 긴쪽 채택
            if (intervals[i][0] <= end)
                end = Math.max(end, intervals[i][1]);
            // 앞의 start가 뒤의 end가 겹치지 않는 경우, 정답 리스트에 넣어주고 start, end 현재 원소로 갱신
            else {
                answer.add(new int[] {start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        // 마지막 원소는 반복문에서 들어가지 않으므로 여기서 넣기
        answer.add(new int[] {start, end});
        return answer.toArray(new int[answer.size()][]);
    }
}