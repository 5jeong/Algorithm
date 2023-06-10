package Algorithm_Study_Inflearn.DFS;

import Algorithm_Study_Inflearn.해싱and시간파싱.Solution;

import java.util.Stack;

public class 줄다리기 {
    static int m,n,answer;
    static int[] arr,ch;
    static int[][] relation;
    static Stack<Integer> stack;
    static void DFS(int L){
        if(L==7) {
            answer++;
        }
        else{
            for(int i=1;i<8;i++){
                if(!stack.isEmpty() && relation[stack.peek()][i]==1){
                    continue;
                }
                if(ch[i] == 0){
                    ch[i]=1;
                    stack.push(i);
                    DFS(L+1);
                    ch[i]=0;
                    stack.pop();
                }
            }
        }

    }
    public static int solution(int[][] fight){
        answer = 0;
        m = fight.length;
        n = fight[0].length;
        relation= new int[8][8];
        arr=new int[8];
        ch =new int[8];
        stack=new Stack<>();
        for(int i = 0; i < m; i++) {
            int a = fight[i][0];
            int b = fight[i][1];
            relation[a][b] = 1;
            relation[b][a] = 1;
        }
        DFS(0);
        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(solution(new int[][]{{1, 7}}));
        System.out.println(solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }
}
