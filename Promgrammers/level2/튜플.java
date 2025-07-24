package Promgrammers.level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 튜플 {
    public static int[] solution(String s) {

        s = s.substring(2, s.length() - 2);

        String[] split = s.split("},\\{");

        // 오름차순 정렬
        Arrays.sort(split, (a, b) -> a.length() - b.length());

        Set<String> set = new HashSet<>();

        int[] answer = new int[split.length];
        int idx = 0;
        for (String x : split) {
            for (String num : x.split(",")) {
                if (set.add(num)) {
                    answer[idx++] = Integer.parseInt(num);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
    }
}
