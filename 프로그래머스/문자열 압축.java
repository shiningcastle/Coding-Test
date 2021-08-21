class Solution {
    public int solution(String s) {
        int min = s.length();
        // 글자수, 절반 위치까지만 판단하면 됨
        for (int i = 1; i <= s.length()/2; i++) {
            // 결과 길이값은 최대가 전체 길이, 위치 인덱스 보관 변수 선언
            int len = s.length(), pos = 0;
            // 위치 인덱스
            while (pos+i <= s.length()) {
                // 반복 포함한 해당 단어 횟수, 비교할 단어 받고 시작하므로 1
                int count = 1;
                // 판단할 임시 단어
                String tmp = s.substring(pos, pos+i);
                pos += i;
                // 뒤의 단어와 비교 반복
                while (pos+i <= s.length()) {
                    if(tmp.equals(s.substring(pos, pos+i))) {
                        count++;
                        pos += i;
                    }
                    // 한번이라도 다르면 바로 다음 케이스 글자로
                    else
                        break;
                }
                // 반복되는 글자 개수만큼 제거 (-1은 반복시작 전 첫단어)
                len -= ((count-1) * i);
                // 숫자 자리 수만큼 길이 더하기, 반복되는 숫자가 0개는 더하지 않는다
                len += (count == 1) ? 0 : Integer.toString(count).length();
            }
            // 최소 길이 갱신해주기
            min = Math.min(min, len);
        }
        return min;
    }
}