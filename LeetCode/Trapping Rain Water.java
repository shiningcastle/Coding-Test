class Solution {
    public int trap(int[] height) {
        // 배열의 길이, 정답
        int len = height.length, answer = 0;
        int[] leftWall = new int[len], rightWall = new int[len];
        // 벽의 최대 높이를 보관할 변수 선언
        int max = height[0];
        leftWall[0] = height[0];
        // 해당 인덱스 시점에 왼쪽 벽 최고 높이, 0번째는 문제에서 체킹안함
        for (int i=1; i<len; i++) {
            max = Math.max(max, height[i]);
            leftWall[i] = max;
        }
        // 해당 인덱스 시점에 오른쪽 벽 최고 높이
        max = height[len-1]; // 기준이 오른쪽으로 변해서 초기화
        rightWall[len-1] = height[len-1];
        for (int i=len-2; i>=0; i--) {
            max = Math.max(max, height[i]);
            rightWall[i] = max;
        }
        // 왼쪽, 오른쪽 벽중에 최소값만큼 물이 찬다(단 해당 위치의 벽의 높이만큼 덜찬다)
        for (int i=1; i<len; i++) {
            answer += Math.min(leftWall[i], rightWall[i]) - height[i];
        }
        return answer;
    }
}