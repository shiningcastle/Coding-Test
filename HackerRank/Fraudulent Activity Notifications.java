import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static double CalMedian(int[] medianArr, int d, boolean isOdd) {
        double median = 0;
        int idx = 0;

        if (isOdd) {
            for (int i = 0; i < medianArr.length; i++) {
                idx += medianArr[i];
                if (idx > d / 2) {
                    median = i;
                    break;
                }
            }
        } else {
            int first = 0;
            int second = 0;

            for (int i = 0; i < medianArr.length; i++) {
                idx += medianArr[i];
                if (first == 0 && idx >= d / 2) {
                    first = i;
                }
                if (second == 0 && idx >= d / 2 + 1) {
                    second = i;
                    break;
                }
            }
            median = (first + second) / 2.0;
        }
        return median * 2;
    }

    private static int activityNotifications(int n, int d, int[] data) {
        int count = 0;
        int[] medianArr = new int[201];
        boolean isOdd = (d % 2 == 0) ? false : true;

        for (int i = 0; i < d; i++) {
            medianArr[data[i]]++;
        }

        for (int i = d; i < n; i++) {
            double median = CalMedian(medianArr, d, isOdd);
            if (median <= data[i]) {
                count++;
            }
            medianArr[data[i]]++;
            medianArr[data[i - d]]--;
        }
        return count;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(activityNotifications(n, d, data));
        br.close();
    }
}