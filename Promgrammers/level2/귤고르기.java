package Promgrammers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 귤고르기 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int x : tangerine) {
            hashMap.put(x, hashMap.getOrDefault(x, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> sorted = new ArrayList<>(hashMap.entrySet());

        sorted.sort((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<Integer, Integer> entry : sorted) {
            k -= entry.getValue();
            answer++;
            if (k <= 0) {
                break;
            }
        }
        return answer;
    }
}
