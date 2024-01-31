package Algorithm_Study_Inflearn.DFS;

import java.util.Stack;

public class 줄다리기 {
    static int n = 7, answer;
    static int[][] board;
    static int[] ch;
    static Stack<Integer> stack;

    //    static void dfs(int L, int a, int b) {
//        if (board[a][b] == 1 ) {
//            return;
//        }
//        if (L == n) {
//            answer++;
//        } else {
//            for (int i = 1; i <= 7; i++) {
//                if (ch[i] == 0) {
//                    ch[i] = 1;
//                    dfs(L + 1, b, i);
//                    ch[i] = 0;
//                }
//            }
//        }
//
//    }
    static void dfs(int L){
        if(L==n){
            answer++;
        }
        else{
            for(int i=1;i<=7;i++){
                if(!stack.isEmpty() && board[stack.peek()][i]==1) continue;
                if(ch[i]==0){
                    ch[i]=1;
                    stack.push(i);
                    dfs(L+1);
                    ch[i]=0;
                    stack.pop();
                }
            }
        }
    }

    public static int solution(int[][] fight) {
        answer = 0;
        board = new int[8][8];
        ch = new int[8];
        stack = new Stack<>();
        for (int[] x : fight) {
            board[x[0]][x[1]] = 1;
            board[x[1]][x[0]] = 1;
        }
//        dfs(0, 0, 0);
        dfs(0);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(solution(new int[][]{{1, 7}}));
        System.out.println(solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }
}
