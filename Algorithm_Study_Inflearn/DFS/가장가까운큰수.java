package Algorithm_Study_Inflearn.DFS;

import java.util.ArrayList;
import java.util.Collections;

public class 가장가까운큰수 {
    static ArrayList<Integer> nums;
    static int[] ch;
    static int answer, target;
    static boolean flag;

    static void dfs(int L, int num) {
        if (flag) {
            return;
        }
        if (L == nums.size()) {
            if (num > target) {
                answer = num;
                flag = true;
            }
        } else {
            for (int i = 0; i < nums.size(); i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    dfs(L + 1, num * 10 + nums.get(i));
                    ch[i] = 0;
                }
            }
        }

    }

    public static int solution(int n) {
        target = n;
        answer = 0;
        nums = new ArrayList<>();
        flag = false;
        while (n > 0) {
            nums.add(n % 10);
            n /= 10;
        }
        ch = new int[nums.size()];
        Collections.sort(nums);
        dfs(0, 0);
        if (!flag) {
            answer = -1;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(123));
        System.out.println(solution(321));
        System.out.println(solution(20573));
        System.out.println(solution(27711));
        System.out.println(solution(54312));
    }
}
