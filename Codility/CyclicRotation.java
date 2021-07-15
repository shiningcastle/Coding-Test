import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    public int[] solution(int[] A, int K) {
        // 빈 배열이나 회전 횟수가 0이면 그대로 반환
        if (A.length == 0 || K == 0)
            return A;
        // int타입 배열을 Integer타입 LinkedList로 변환
        Integer[] integerArr = Arrays.stream(A).boxed().toArray(Integer[]::new);
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(integerArr));
        // 마지막 원소를 제거해서 맨 앞으로 넣어주는 것을 K번 반복
        for (int i = 0; i < K; i++) {
            linkedList.addFirst(linkedList.removeLast());
        }
        // Integer타입 LinkedList를 int타입 배열로 다시 변환
        integerArr = linkedList.toArray(new Integer[linkedList.size()]);
        return Arrays.stream(integerArr).mapToInt(Integer::intValue).toArray();
    }
}