public class Solution {
    public int solution(int num) {
        int count = 0;
        // 계산 중에 int의 범위를 넘는 수가 생기므로 long으로 바꿔서 계산
        long copy = num;
        while (count <= 501 && copy != 1) {
            if (copy % 2 == 0)
                copy /= 2;
            else
                copy = copy * 3 + 1;
            count++;
        }
        return (count > 500) ? -1 : count;
    }
}