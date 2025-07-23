package Promgrammers.level2;

import java.util.HashMap;

public class 할인행사 {
    static HashMap<String, Integer> nowMap;
    static HashMap<String, Integer> wantMap;

    public static void main(String[] args) {
        solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1}, new String[]{
                "chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot",
                "banana", "apple", "banana"
        });
    }

    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        nowMap = new HashMap<>();
        wantMap = new HashMap<>();

        //초기화
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        for (int i = 0; i < 10; i++) {
            nowMap.put(discount[i], nowMap.getOrDefault(discount[i], 0) + 1);
        }

        // 맨처음 확인
        if (isPossible()) {
            answer++;
        }

        for (int i = 1; i <= discount.length - 10; i++) {
            String delete = discount[i - 1];
            String add = discount[i + 9];
            nowMap.computeIfPresent(delete, (k, v) -> v == 1 ? null : v - 1);
            nowMap.put(add, nowMap.getOrDefault(add, 0) + 1);
            if (isPossible()) {
                answer++;
            }
        }
        return answer;
    }

    private static boolean isPossible() {
        for (String x : nowMap.keySet()) {
            if (wantMap.get(x) != nowMap.get(x)) {
                return false;
            }
        }
        return true;
    }
}
