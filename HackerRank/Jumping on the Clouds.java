import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int jumpingOnClouds (int n, String[] cloudList) {
		int answer = 0;
		int idx = 0;
		while (idx < n-1) {
			idx = (idx <= n-3 && cloudList[idx+2].equals("0")) ? idx + 2 : idx + 1;
			answer += 1;
		}
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] cloudList = br.readLine().split(" ");
		System.out.println(jumpingOnClouds(n, cloudList));
	}
}