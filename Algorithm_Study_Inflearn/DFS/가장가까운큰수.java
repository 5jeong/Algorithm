package Algorithm_Study_Inflearn.DFS;

import java.util.ArrayList;
import java.util.Collections;

public class 가장가까운큰수 {

    static int len, ans;
    static int target;
    static int[] ch;
    static ArrayList<Integer> nums;

    static void dfs(int L, int num) {
        if(ans > target){
            return;
        }
        if (L == len && num > target) {
            ans = num;
        } else {
            for (int i = 0; i < len; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    dfs(L + 1, (num * 10) + nums.get(i));
                    ch[i] = 0;
                }
            }
        }
    }

    public static int solution(int n) {
        nums = new ArrayList<>();
        target = n;
        ans = 0;
        String str = String.valueOf(n);
        len = str.length();
        ch = new int[n];
        for (char x : str.toCharArray()) {
            nums.add(Integer.parseInt(String.valueOf(x)));
        }
        Collections.sort(nums);
        dfs(0, 0);
        return ans == 0 ? -1 : ans;

    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(solution(123));
        System.out.println(solution(321));
        System.out.println(solution(20573));
        System.out.println(solution(27711));
        System.out.println(solution(54312));
    }
}
