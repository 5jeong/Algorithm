package Promgrammers.Level1;

import java.util.ArrayList;
import java.util.List;

public class 모의고사 {
    static List<int[]> people = new ArrayList<>();

    private int matchCount(int[] answers, int[] match) {
        int cnt = 0;
        int len = match.length;
        int idx = 0;
        for (int x : answers) {
            if (x == match[idx]) {
                cnt++;
            }
            idx = (idx + 1) % len;
        }
        return cnt;

    }

    public int[] solution(int[] answers) {
        int[] answer = {};
        int max = Integer.MIN_VALUE;
        people.add(new int[]{1, 2, 3, 4, 5});
        people.add(new int[]{2, 1, 2, 3, 2, 4, 2, 5});
        people.add(new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5});

        List<Integer> matchCounts = new ArrayList<>();
        for (int[] x : people) {
            int matchCount = matchCount(answers, x);
            matchCounts.add(matchCount);
            max = Math.max(max, matchCount);
        }

        List<Integer> res = new ArrayList<>();
        // final int temp = max;
        // return IntStream.range(0,3)
        //     .filter(i-> matchCounts.get(i)== temp)
        //     .map(i->i+1)
        //     .toArray();

        for (int i = 0; i < 3; i++) {
            if (max == matchCounts.get(i)) {
                res.add(i + 1);
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
