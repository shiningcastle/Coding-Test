import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	private static String rotLeft (int n, int d, LinkedList<String> numList) {
		// n번 마다 원래대로 돌아오는 사이클이라 n으로 나눈 나머지만큼 옮겨주면 된다
		int rotate = d % n;
		// 큐를 이용해서 왼쪽에서 빼서 오른쪽에 넣어준다
		for (int i = 0; i < rotate; i++) {
			numList.add(numList.poll());
		}
		// 리스트의 원소를 스트림으로 바꾸고 String 값으로 변환후 문자열로 사이에 공백넣어 join
		return numList.stream().map(String::valueOf).collect(Collectors.joining(" "));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		// 숫자 문자열을 배열로 만들고 그다음 리스트로 만들고 그것을 LinkedList(큐)로 변환
		LinkedList<String> numList = new LinkedList<String>(Arrays.asList(br.readLine().split(" ")));
		System.out.println(rotLeft(n, d, numList));
	}
}