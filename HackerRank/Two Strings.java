import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static String twoStrings(String s1, String s2) {
		char[] s1Arr = s1.toCharArray();
		char[] s2Arr = s2.toCharArray();
		Arrays.sort(s1Arr);
		Arrays.sort(s2Arr);
		// 비교당하는 문자 리스트에서 비교하는 문자 리스트에서 어디 인덱스까지 비교해봤는지 기록하는 인덱스 
		int idx = 0;
		// 비교 당하는 배열 원소를 모두 비교해봤는데 비교하는 배열의 앞의 원소보다 작았으면
		// 비교하는 배열의 그 뒤의 모든 원소는 더 볼 필요없으니 for문 종료
		for (int i = 0; i < s1Arr.length && idx < s2Arr.length; i++) {
			while (idx < s2Arr.length) {
				// 비교하는 배열의 원소가 비교 당하는 배열의 원소보다 작으면 뒤는 더 볼필요 없으니 중단하고 다음 문자로
				if (s1Arr[i] < s2Arr[idx]) {
					break;
				}
				if (s1Arr[i] == s2Arr[idx]) {
					return "YES";
				}
				idx++;
			}
		}
		return "NO";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String s1 = br.readLine();
			String s2 = br.readLine();			
			System.out.println(twoStrings(s1, s2));
		}
		br.close();
	}
}