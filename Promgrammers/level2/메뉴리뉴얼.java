package Promgrammers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 메뉴리뉴얼 {
    static List<String> res = new ArrayList<>();
    static Map<String, Integer> hashMap = new HashMap<>();

    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        // 각 order를 정렬
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }

        // order 기준으로 courseLength만큼 조합
        for (int courseLength : course) {
            for (String order : orders) {
                combination("", order, courseLength);
            }
            // 가장 많은 조합을 answer에 저장
            if (!hashMap.isEmpty()) {
                List<Integer> countList = new ArrayList<>(hashMap.values());
                int max = Collections.max(countList);
                if (max > 1) {
                    for (String x : hashMap.keySet()) {
                        if (hashMap.get(x) == max) {
                            res.add(x);
                        }
                    }
                }
            }
            hashMap = new HashMap<>();
            Collections.sort(res);
        }
        return res.toArray(String[]::new);
    }

    private static void combination(String order, String others, int count) {
        // 종료조건 count = 0
        if (count == 0) {
            hashMap.put(order, hashMap.getOrDefault(order, 0) + 1);
            return;
        }
        // 0부터 others 길이만큼 조함
        for (int i = 0; i < others.length(); i++) {
            combination(order + others.charAt(i), others.substring(i + 1), count-1);
        }
    }

    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        System.out.println(Arrays.toString(solution(orders, course)));
    }
}
