import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static int sockMerchant(int n, int[] numArray) {
        List<Integer> numList = new ArrayList<Integer>();
        int answer = 0;
        for (Integer num : numArray) {
            if (numList.contains(num)) {
                numList.remove(num);
                answer += 1;
            } else {
                numList.add(num);
            }
        }
        return answer;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numArray = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int answer = sockMerchant(n, numArray);
        System.out.println(answer);
    }
}