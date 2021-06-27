import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static long repeatedString (long n, String s) {
		// 주어진 문자열에서 a의 개수를 구함
		long aCount = s.chars().filter(num -> num == 'a').count();
		// n을 문자열의 길이로 나눈 몫과 처음 문자열의 a의 개수를 곱하면 나누어 떨어지면 전체 a의 개수임
		long answer = ((long) n / s.length()) * aCount;
		// 만약 나누어 떨어지지 않으면 부족한만큼 문자열을 앞에서 잘라서 a의 개수를 구하고 정답에 더해줌
		String remain = s.substring(0, (int) (n % s.length()));
		answer += remain.chars().filter(num -> num == 'a').count();
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		long n = Long.parseLong(br.readLine());
		System.out.println(repeatedString(n, s));
	}
}