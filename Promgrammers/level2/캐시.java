package Promgrammers.level2;

import java.util.ArrayDeque;
import java.util.Deque;

public class 캐시 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        // 대소문자 구분x
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toUpperCase();
        }

        // 캐시사이즈가 0이면 항상 미스
        if (cacheSize == 0) {
            return 5 * cities.length;
        }

        Deque cache = new ArrayDeque();

        for (String city : cities) {

            // 캐시 적중
            if (cache.contains(city)) {
                cache.remove(city);
                cache.addFirst(city);
                answer += 1;
            } else { // 캐시 미스
                if(cache.size() == cacheSize){
                    cache.pollLast();
                }
                cache.addFirst(city);
                answer += 5;
            }

        }
        return answer;
    }
}
