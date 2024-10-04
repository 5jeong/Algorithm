package Algorithm_Study_Inflearn.DFS;

import java.util.Stack;

// 순열
// 메모이제이션

public class 줄다리기 {

    static int ans;
    static int[][] relation;
    static int[] ch;


    static void dfs(int L, int pre, int now) {
        // 이전과 현재의 상태를 비교해서 이웃한지 확인
        if (relation[pre][now] == 1) {
            return;
        }
        if (L == 7) {
            ans++;
        } else {
            for (int i = 1; i <= 7; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    dfs(L+1,now,i);
                    ch[i] = 0;
                }
            }
        }
    }

    public static int solution(int[][] fight) {
        ans = 0;
        ch = new int[8];
        relation = new int[8][8];
        // 메모이제이션 : 싫어하는 관계에 1저장
        for (int[] x : fight) {
            int a = x[0];
            int b = x[1];
            relation[a][b] = 1;
            relation[b][a] = 1;
        }
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
