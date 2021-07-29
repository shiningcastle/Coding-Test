class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String tree : skill_trees) {
            if (skill.indexOf(tree.replaceAll("[^" + skill + "]", "")) == 0)
                answer++;
        }
        return answer;
    }
}