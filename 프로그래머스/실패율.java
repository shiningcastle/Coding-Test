public class Solution {
    class FailInfo {
        private int stage;
        private double failRate;

        private FailInfo(int stage, double failRate) {
            this.stage = stage;
            this.failRate = failRate;
        }
    }

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        // 총 실패율 계산 대상 유저 수
        int total = stages.length;
        // 모두 클리어한 유저로 인해 길이가 +1
        int[] stageUser = new int[N+1];
        // 각 스테이지 별 유저 수 배열 생성
        for (int s : stages)
            stageUser[s-1]++;
        // 계산한 실패율을 스테이지별로 보관할 리스트 (인덱스 = 스테이지 숫자-1)
        ArrayList<FailInfo> rateList = new ArrayList<>();
        // 실패율 계산
        for (int i = 0; i < N; i++) {
            // 해당 스테이지의 유저 수가 0인 경우 실패율 0 처리
            if (stageUser[i] == 0)
                rateList.add(new FailInfo(i+1, 0));
            else
                rateList.add(new FailInfo(i+1,  (double) stageUser[i]/total));
            // 앞의 스테이지 도달한 사람 수를 전체 수에서 뺀 수가 다음 실패율 분모임
            total -= stageUser[i];
        }
        // rateList를 정렬해주기
        Collections.sort(rateList, new Comparator<FailInfo>() {
            @Override
            public int compare(FailInfo o1, FailInfo o2) {
                if (o1.failRate < o2.failRate)
                    return 1;
                else if (o1.failRate > o2.failRate)
                    return -1;
                else {
                    if (o1.stage < o2.stage)
                        return -1;
                    // 여기서 스테이지 숫자가 같을리는 없다
                    else
                        return 1;
                }
            }
        });
        // 정답 배열 만들기
        for (int i = 0; i < N; i++)
            answer[i] = rateList.get(i).stage;
        return answer;
    }
}