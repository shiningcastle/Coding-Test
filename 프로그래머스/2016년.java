import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Solution {
    public String solution(int a, int b) throws ParseException {
        String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        String firstDay = "2016-01-01";
        String lastDay = String.format("2016-%02d-%02d", a, b);
        // 날짜 객체로 변환
        Date firstFormat = new SimpleDateFormat("yyyy-MM-dd").parse(firstDay);
        Date lastFormat = new SimpleDateFormat("yyyy-MM-dd").parse(lastDay);
        // 두 날짜의 일수 차이 계산
        long diffDays = (lastFormat.getTime() - firstFormat.getTime()) / (1000*60*60*24);
        return day[(int) diffDays % 7];
    }
}