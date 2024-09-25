package Algorithm_Study_Inflearn.DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 가장가까운큰수 {
    static int len,ans;
    static List<Integer> nums;
    static int[] ch;
    static boolean flag;

    private static void dfs(int L, int num,int n) {
        if (flag) {
            return;
        }
        if (L == len ) {
            if(num > n){
                ans = num;
                flag=true;
            }
        } else {
            for (int i = 0; i < len; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    dfs(L + 1, num * 10 + nums.get(i),n);
                    ch[i] = 0;
                }
            }
        }
    }

    public static int solution(int n) {
        String s = String.valueOf(n);
        len = s.length();
        ans = 0;
        nums = new ArrayList<>();
        flag = false;
        for (char x : s.toCharArray()) {
            nums.add(Integer.parseInt(String.valueOf(x)));
        }
        Collections.sort(nums);
        ch = new int[len];
        dfs(0, 0,n);
        return flag ? ans : -1;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(solution(123));
        System.out.println(solution(321));
        System.out.println(solution(20573));
        System.out.println(solution(27711));
        System.out.println(solution(54312));
    }
}
