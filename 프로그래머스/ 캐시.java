import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        // 캐쉬
        List<String> cache = new ArrayList<>();
        int time = 0;
        for (int i = 0; i < cities.length; i++) {
            // 대소문자 구별 안하므로 모두 소문자로 처리
            String city = cities[i].toLowerCase();
            boolean cacheHit = false;
            // 캐쉬에 도시들이 있을때만 반복문 적용
            for (int j = 0; j < cache.size(); j++) {
                // 캐쉬 히트, 캐쉬에서 해당 도시를 제거하고 다시 넣어준다
                if (cache.get(j).equals(city)) {
                    cache.remove(j);
                    cache.add(city);
                    cacheHit = true;
                }
            }
            // 캐쉬 미스, 캐쉬 사이즈가 다찼으면 뺴고 최근 도시 넣기, 단 캐쉬 히트면 위에서 넣었으니 제외
            if (!cacheHit && cacheSize != 0) {
                if (cache.size() == cacheSize)
                    cache.remove(0);
                cache.add(city);
            }
            time += (cacheHit) ? 1 : 5;
        }
        return time;
    }
}