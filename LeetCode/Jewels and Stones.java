import java.util.HashSet;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> set = new HashSet<>();
        int answer = 0;
        for (char j : jewels.toCharArray())
            set.add(j);
        for (char s : stones.toCharArray()) {
            if (set.contains(s))
                answer++;
        }
        return answer;   
    }
}