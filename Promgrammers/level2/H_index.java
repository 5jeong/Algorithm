package Promgrammers.level2;

import java.util.Arrays;

public class H_index {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        for (int h = len; h >= 1; h--) {
            if (isValid(citations, h)) {
                return h;
            }
        }
        return 0;
    }

    private boolean isValid(int[] citations, int h) {
        int idx = citations.length - h;
        return citations[idx] >= h;
    }
}
