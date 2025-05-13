package Promgrammers.level2;

import java.util.HashSet;
import java.util.Set;

public class 비밀코드해독 {
    static int[] nums;
    static int len, answer, m;
    static int[] res;

    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        nums = new int[5];
        len = n;
        m = q.length;
        dfs(0, 1, q, ans);
        return answer;
    }

    // 조합
    private void dfs(int L, int s, int[][] q, int[] ans) {
        if (L == 5) {
            if (isPossible(q, ans)) {
                answer++;
            }
        } else {
            for (int i = s; i <= len; i++) {
                nums[L] = i;
                dfs(L + 1, i + 1, q, ans);
            }
        }
    }

    // 비밀코드 확인
    private boolean isPossible(int[][] q, int[] ans) {
        Set<Integer> set;
        for (int i = 0; i < m; i++) {
            set = new HashSet<>();

            // q, 조합 숫자 다넣기
            for (int j = 0; j < 5; j++) {
                set.add(q[i][j]);
                set.add(nums[j]);
            }

            if (10 - set.size() != ans[i]) {
                return false;
            }
        }
        return true;
    }
}
