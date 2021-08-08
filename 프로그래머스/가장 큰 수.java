import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] arr = Arrays.stream(numbers).boxed().map(String::valueOf).toArray(String[]::new);
        Arrays.sort(arr, (o1, o2) -> {
            return (o2 + o1).compareTo(o1 + o2);
        });
        StringBuilder sb = new StringBuilder();
        for (String a : arr)
            sb.append(a);
        return (sb.toString().replaceAll("0", "").isEmpty()) ? "0" : sb.toString();
    }
}