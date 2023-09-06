package Algorithm_Study_Inflearn.그래프;

import Algorithm_Study_Inflearn.해싱and시간파싱.Solution;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 공굴리기 {
    public static int solution(int[][] board, int[] s, int[] e){
        int answer = 0;
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        int n = board.length;
        int m = board[0].length;
        int[][] cost = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(cost[i],Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        cost[s[0]][s[1]] = 0;
        pq.offer(new int[]{s[0],s[1],0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(cur[2] > cost[cur[0]][cur[1]]) continue;
            for(int i=0;i<4;i++){
                int nx = cur[0];
                int ny = cur[1];
                int len = cur[2];
                while (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                    nx += dx[i];
                    ny += dy[i];
                    len++;
                }
                nx-=dx[i];
                ny-=dy[i];
                len--;
                if(cost[nx][ny] > len){
                    cost[nx][ny] = len;
                    pq.offer(new int[]{nx,ny,cost[nx][ny]});
                }

            }
        }
        if(cost[e[0]][e[1]]==Integer.MAX_VALUE){
            answer = -1;
        }
        else{
            answer = cost[e[0]][e[1]];
        }
        return answer;
    }
    public static void main(String[] args){
        System.out.println(solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{1, 0}, new int[]{4, 5}));
        System.out.println(solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 2}));
        System.out.println(solution(new int[][]{{1, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 3}, new int[]{4, 2}));
        System.out.println(solution(new int[][]{{0, 1, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 5}));
        System.out.println(solution(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 3}));
    }
}
