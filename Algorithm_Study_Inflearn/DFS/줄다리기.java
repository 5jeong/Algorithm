package Algorithm_Study_Inflearn.DFS;

import java.util.Stack;

public class 줄다리기 {
    static int[][] relation;
    static int[] ch;
    static int ans;
    static Stack<Integer> stack;

//    private static void dfs(int L) {
//        if (L == 7) {
//            ans++;
//        } else {
//            // 순열
//            for (int i = 1; i <= 7; i++) {
//                if (!stack.isEmpty() && relation[stack.peek()][i] == 1) {
//                    continue;
//                }
//                if (ch[i] == 0) {
//                    ch[i] = 1;
//                    stack.push(i);
//                    dfs(L + 1);
//                    ch[i] = 0;
//                    stack.pop();
//                }
//            }
//        }
//    }

    private static void dfs(int L, int now, int pre) {
        if (relation[now][pre] == 1) {
            return;
        }
        if (L == 7) {
            ans++;
        } else {
            for (int i = 1; i <= 7; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    dfs(L + 1, i, now);
                    ch[i] = 0;
                }
            }
        }
    }

    public static int solution(int[][] fight) {
        ans = 0;
        relation = new int[8][8];
        for (int[] x : fight) {
            relation[x[0]][x[1]] = 1;
            relation[x[1]][x[0]] = 1;
        }
        ch = new int[8];
//        stack = new Stack<>();
        dfs(0, 0, 0);
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(solution(new int[][]{{1, 7}}));
        System.out.println(solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }
}
