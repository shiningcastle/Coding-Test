import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
      static int minimumSwaps(int n, int[] arr) {
        int swapCnt = 0, tmp, idx = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] != i + 1) {
                for(int j = i + 1; j < n; j++) {
                    if(arr[j] == i + 1) {
                        idx = j; 
                        break;
                    }
                }
                tmp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = tmp;
                swapCnt++;
            }
        }
        return swapCnt;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(minimumSwaps(n, arr));
    }
}