class Solution {
    public boolean solution(int x) {
        // 정답, x를 복사한 변수
        int ssum = 0, copy = x;
        // x를 한자리씩 ssum에 더함, 10으로 계속 나누어 다음 자리 수로
        while (copy != 0) {
            ssum += copy % 10;
            copy /= 10;
        }
        return (x % ssum == 0) ? true : false;
    }
}