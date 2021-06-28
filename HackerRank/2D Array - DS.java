import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[][] arr = new int[6][6];
	private static int hourglassSum (int[][] arr) {
		int large = -64;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
				large = Math.max(sum, large);
			}
		}
		return large;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 6; i++) {			
			String[] numArr = br.readLine().split(" ");
			arr[i] = Arrays.stream(numArr).mapToInt(Integer::parseInt).toArray();
		}
		System.out.println(hourglassSum(arr));
	}
}