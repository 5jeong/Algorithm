package Promgrammers.level2;

import java.util.HashSet;
import java.util.Set;

public class 연속부분수열합의개수 {
    public int solution(int[] elements) {
        int maxLen = elements.length;
        int len = 1;
        Set<Integer> set = new HashSet<>();
        while (len <= maxLen) {
            for (int i = 0; i < maxLen; i++) {
                int num = 0;
                for (int j = i; j < i + len; j++) {
                    num += elements[j % maxLen];
                }
                set.add(num);
            }
            len++;
        }
        return set.size();
    }
}
