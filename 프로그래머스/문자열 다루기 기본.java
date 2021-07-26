class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        if (s.length() == 4 || s.length() == 6)
            answer =  s.chars().allMatch(Character::isDigit);
        return answer;
    }
}