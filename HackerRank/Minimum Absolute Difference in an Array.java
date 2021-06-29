import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static int minimumAbsoluteDifference(int[] arr) {
		int min = 2000000000;
		Arrays.sort(arr);
		for (int i = 0; i < arr.length-1; i++) {
			min = Math.min(min, Math.abs(arr[i] - arr[i+1]));
		}
		return min;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		System.out.println(minimumAbsoluteDifference(arr));
		br.close();
	}
}