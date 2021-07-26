import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> lis = new ArrayList<>();
        // 바로 전의 수를 기록해서 비교, 초기값은 나올 수 없는 원소
        int before = 10;
        for (int n : arr) {
            // 직전 값과 다른 수일 때만 추가
            if (n != before)
                lis.add(n);
            // 지금 수를 직전 수로 갱신
            before = n;
        }
        // 리스트를 조건대로 배열로 만들어줌
        int[] answer = new int[lis.size()];
        for (int i = 0; i < lis.size(); i++) {
            answer[i] = lis.get(i).intValue();
        }
        return answer;
    }
}