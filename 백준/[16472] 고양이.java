import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    private static int findMaxLength(int n, char[] chars) {
        // 최대 길이, 왼쪽 & 오른쪽 인덱스, 알파벳 종류 수
        int answer = 0, left = 0, right = 0, count = 0;
        int[] alpha = new int['z'-'a'+1]; // 알파벳별 개수
        while (left <= right && right < chars.length) {
            char c;
            if (count <= n) { // N이하의 알파벳 종류면 right+1
                c = chars[right];
                if (alpha[c - 'a'] == 0) // 새로운 알파벳이면 카운트+1
                    count++;
                alpha[c - 'a']++; // 해당 알파벳 개수+1
                right++;
            } else { // N이상의 알파벳 종류면 left+1
                c = chars[left];
                alpha[c - 'a']--; // 해당 알파벳 개수-1
                if (alpha[c - 'a'] == 0) // 왼쪽 알파벳 종류 더이상 없으면 카운트-1
                    count--;
                left++;
            }
            if (count <= n) // N이하의 종류 길이 경우만 최대값 갱신
                answer = Math.max(answer, right - left);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] chars = br.readLine().toCharArray();
        br.close();
        System.out.println(findMaxLength(n, chars));
    }
}