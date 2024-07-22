package Promgrammers.Level1;

import java.util.HashSet;
import java.util.Set;

public class 없는숫자더하기 {
    public int solution(int[] numbers) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int x : numbers) {
            set.add(x);
        }
        for (int i = 1; i < 10; i++) {
            if (!set.contains(i)) {
                ans += i;
            }
        }
        return ans;
    }
}
