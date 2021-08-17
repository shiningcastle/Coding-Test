class Solution {
    public int[] solution(String s) {
        int times = 0, counts = 0;
        while (!s.equals("1")) {
            int original = s.length(), replaced = s.replaceAll("0", "").length();
            s = Integer.toBinaryString(replaced);
            counts += (original - replaced);
            times++;
        }
        return new int[] {times, counts};
    }
}