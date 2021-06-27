import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int countingValleys(int n, String upDown) {
        boolean isValley = false;
        int seaLevel = 0;
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            char step = upDown.charAt(i);
            if (step == 'U') {
                seaLevel += 1;
            } else {
                seaLevel -= 1;
                if (!isValley && seaLevel < 0) {
                    answer += 1;
                }
            }
            isValley = (seaLevel < 0) ? true : false;            
        }
        return answer;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String upDown = br.readLine();
        System.out.println(countingValleys(n, upDown));
    }
}