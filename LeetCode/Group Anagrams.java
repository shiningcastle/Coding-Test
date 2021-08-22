import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sorted = String.valueOf(arr);
            if (map.containsKey(sorted))
                map.get(sorted).add(s);
            else
                map.put(sorted, new ArrayList<>(Arrays.asList(s)));
        }
        answer.addAll(map.values());
        return answer;
    }
}