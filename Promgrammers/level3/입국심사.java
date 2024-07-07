package Promgrammers.level3;

import java.util.Arrays;

public class 입국심사 {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long start = 0L;
        long end = times[times.length - 1] * (long) n;

        //정답 검사, 범위좁히기
        while (end > start) {
            long t = (start + end) / 2;
            if (isValid(t, n, times)) {
                end = t;
            } else {
                start = t + 1;
            }
        }
        return start;
    }

    private boolean isValid(long t, int n, int[] times) {
        long c = 0;
        for (int time : times) {
            c += t / time;
        }
        return c >= n;
    }
}
