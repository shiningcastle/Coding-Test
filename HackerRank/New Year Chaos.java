import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static void minimumBribes(int n, int[] intArr) {
		int count = 0;
		// 일단 처음부터 2번 이상 뇌물을 준 케이스가 있는지 부터 검사, 있으면 더이상 진행없이 종료
		for (int i = 0; i < n; i++) {
			if (intArr[i] > i + 3) {
				System.out.println("Too chaotic");
				return;
			}
		}
		// 정렬된 배열을 깊은 복사로 만들어서 비교 작업에 쓴다
		int[] copyArr = intArr.clone();
		Arrays.sort(copyArr);
		// 버블 정렬 시행, 서로 위치 바뀔때마다 카운트
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1 - i; j++) {
				if (intArr[j] > intArr[j + 1]) {
					int tmp = intArr[j + 1];
					intArr[j + 1] = intArr[j];
					intArr[j] = tmp;
					count += 1;
				}
			}
			// 버블 정렬 안쪽 for문에서 이미 정렬 완료되었는지 매번 체크해주어 불필요한 반복 줄임
			// 배열의 원소뿐만아니라 원소의 순서까지 같아야 true 반환함
			if (Arrays.equals(intArr, copyArr)) {
				break;
			}
		}
		System.out.println(count);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			// 정수 배열로 만들기
			int[] intArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			minimumBribes(n, intArr);
		}
	}
}