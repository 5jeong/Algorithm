package Promgrammers.level2;

import java.util.HashMap;
import java.util.Map;

public class 롤케이크자르기 {
    public int solution(int[] topping) {
        int answer = 0;
        int n = topping.length;

        // 초기화 O(n)
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        for (int x : topping) {
            right.put(x, right.getOrDefault(x, 0) + 1);
        }

        for (int i = 0; i < n; i++) {

            int now = topping[i];
            left.put(now, left.getOrDefault(now, 0) + 1);
            right.computeIfPresent(now, (k, v) -> v == 1 ? null : v - 1);
            if (left.size() == right.size()) {
                answer++;
            }
        }

        return answer;
    }

}
