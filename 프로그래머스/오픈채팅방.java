import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] solution(String[] record) {
        // 닉네임 변화 기록, 키는 아이디, 값은 닉네임
        Map<String, String> map = new HashMap<>();
        // 각 위치별 아이디 기록
        List<String> idList = new ArrayList<>();
        // 정답 리스트
        List<StringBuilder> result = new ArrayList<>();
        for (String r : record) {
            String[] split = r.split(" ");
            StringBuilder sb = new StringBuilder();
            // 정답 리스트에 결과먼저 넣기
            switch (split[0].charAt(0)) {
                case 'E':
                    result.add(sb.append("님이 들어왔습니다."));
                    // 인덱스별 아이디 기록
                    idList.add(split[1]);
                    // 아이디 : 닉네임 기록
                    map.put(split[1], split[2]);
                    break;
                case 'L':
                    result.add(sb.append("님이 나갔습니다."));
                    // 인덱스별 아이디 기록
                    idList.add(split[1]);
                    break;
                case 'C':
                    // 아이디 : 닉네임 기록
                    map.put(split[1], split[2]);
            }
        }
        // 정답 배열 만들기
        String[] answer = new String[result.size()];
        // StringBuilder로 넣어준 문자열 앞에 닉네임 붙여주고 String으로 변환 후 정답 배열에 넣기
        for (int i = 0; i < answer.length; i++)
            answer[i] = result.get(i).insert(0, map.get(idList.get(i))).toString();
        return answer;
    }
}