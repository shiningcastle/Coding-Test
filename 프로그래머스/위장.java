import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        int answer = 1;
        for (String[] c: clothes) {
            if (map.containsKey(c[1]))
                map.replace(c[1], map.get(c[1])+1);
            else
                map.put(c[1], 1);
        }
        for (String k : map.keySet()) {
            answer *= (map.get(k)+1);
        }
        return answer-1;
    }
}