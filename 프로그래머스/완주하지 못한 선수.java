import java.util.HashMap;

public class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        String answer = "";
        // 참가자들을 HashMap에 넣어준다. 같은 이름이면 value를 1씩 증가
        for (String name : participant) {
            if (map.containsKey(name))
                map.replace(name, map.get(name)+1);
            else
                map.put(name, 1);
        }
        // 완주자들을 조회, 같은 이름이 다수면 value를 -1씩 감소, 이름이 하나면 map에서 삭제
        for (String name : completion) {
            if (map.get(name) > 1)
                map.replace(name, map.get(name)-1);
            else
                map.remove(name);
        }
        // 반복문은 한번만 실행되고, HashMap에 유일하게 남은 key가 정답
        for (String key : map.keySet())
            answer = key;
        return answer;
    }
}