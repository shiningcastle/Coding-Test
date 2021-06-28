import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static void countSwaps(int n, int[] arr) {
		int count = 0;
		for (int i = 0; i < n; i++) {
            // i 반복 한번 할때마다 뒤에 고정 최대값이 한자리씩 차지하므로 n-i-1 
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = tmp;
					count++;
				}
			}
		}
		System.out.println(String.format("Array is sorted in %d swaps.", count));
		System.out.println(String.format("First Element: %d", arr[0]));
		System.out.println(String.format("Last Element: %d", arr[n-1]));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		countSwaps(n, arr);
	}
}