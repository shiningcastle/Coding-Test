public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        // 오른손잡이 = true
        boolean prefRight = hand.equals("right");
        // 왼손, 오른손 엄지손가락의 좌표 위치를 나타내는 변수(처음엔 *,# 위치)
        int[] leftPos = {4, 1}, rightPos = {4, 3};
        // 모든 숫자(0~9)의 좌표 위치를 HashMap에 등록
        int[][] numLoc = {{4, 2}, {1, 1}, {1, 2}, {1, 3}, {2, 1}, {2, 2}, {2, 3}, {3, 1}, {3, 2}, {3, 3}};

        for (int num : numbers) {
            switch (num) {
                case 1: case 4: case 7:
                    sb.append('L');
                    leftPos = numLoc[num];
                    break;
                case 3: case 6: case 9:
                    sb.append('R');
                    rightPos = numLoc[num];
                    break;
                default:
                    int leftDis = Math.abs(numLoc[num][0] - leftPos[0]) + Math.abs(numLoc[num][1] - leftPos[1]);
                    int rightDis = Math.abs(numLoc[num][0] - rightPos[0]) + Math.abs(numLoc[num][1] - rightPos[1]);
                    if (leftDis > rightDis) {
                        sb.append('R');
                        rightPos = numLoc[num];
                    } else if (rightDis > leftDis) {
                        sb.append('L');
                        leftPos = numLoc[num];
                    } else {
                        if (prefRight) {
                            sb.append('R');
                            rightPos = numLoc[num];
                        } else {
                            sb.append('L');
                            leftPos = numLoc[num];
                        }
                    }
            }
        }
        return sb.toString();
    }