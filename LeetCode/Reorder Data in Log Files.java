import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] arr1 = o1.split(" ", 2), arr2 = o2.split(" ", 2);
                boolean isDigit1 = Character.isDigit(arr1[1].charAt(0)), isDigit2 = Character.isDigit(arr2[1].charAt(0));
                if (!isDigit1 && !isDigit2) {
                    if (arr1[1].compareTo(arr2[1]) == 0)
                        return arr1[0].compareTo(arr2[0]);
                    else
                        return arr1[1].compareTo(arr2[1]);
                }
                else if (!isDigit1 && isDigit2)
                    return -1;
                else if (isDigit1 && !isDigit2)
                    return 1;
                else
                    return 0;
            }
        });
        return logs;
    }
}