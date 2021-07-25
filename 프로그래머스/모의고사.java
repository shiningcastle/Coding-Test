import java.util.ArrayList;
import java.util.List;

class Solution {
    public static int[] solution(int[] answers) {
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};
        int a1 = 0, a2 = 0, a3 = 0;
        List<Integer> al = new ArrayList<>(3);

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == p1[i % p1.length])
                a1++;
            if (answers[i] == p2[i % p2.length])
                a2++;
            if (answers[i] == p3[i % p3.length])
                a3++;
        }
        int win = Math.max(a1, Math.max(a2, a3));
        if (a1 == win)
            al.add(1);
        if (a2 == win)
            al.add(2);
        if (a3 == win)
            al.add(3);
        return al.stream().mapToInt(i -> i).toArray();
    }
}