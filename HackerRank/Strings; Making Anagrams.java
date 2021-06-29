import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static int makeAnagram(String a, String b) {
		int count = 0;
		char[] arrA = a.toCharArray(), arrB = b.toCharArray();
		int lenA = arrA.length, lenB = arrB.length;
		Arrays.sort(arrA);
		Arrays.sort(arrB);
		
		for (int i = 0; i < lenA; i++) {
			for (int j = 0; j < lenB; j++) {
				if (arrA[i] == arrB[j]) {
					count++;
					// 원소들은 모두 영어 소문자이므로 이미 한번 카운팅한 같은 값들 중복계산 안되게 특수문자로 바꿔줌
					arrA[i] = '!';
					arrB[j] = '@';
					break;
				}
			}
		}
		return lenA + lenB - count * 2;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine(), b = br.readLine();
		System.out.println(makeAnagram(a, b));
		br.close();
	}
}