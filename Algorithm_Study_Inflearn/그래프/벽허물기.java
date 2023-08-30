package Algorithm_Study_Inflearn.그래프;

import Algorithm_Study_Inflearn.해싱and시간파싱.Solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 벽허물기 {
    public static int solution(int[][] board) {
        int answer = 0;
        int[] dx= {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        int n = board.length;
        int m = board[0].length;
        int[][] cost = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(cost[i],Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[2]-b[2]);
        pq.add(new int[]{0,0,0});
        cost[0][0]= 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(cost[cur[0]][cur[1]] < cur[2]) continue;
            for(int i=0;i<4;i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                if(nx < 0 || nx >=n || ny <0 || ny >=m) continue;
                if(board[nx][ny]==0 && cost[nx][ny] > cur[2]){
                    cost[nx][ny] = cur[2];
                    pq.offer(new int[]{nx,ny,cur[2]});
                }
                else if(board[nx][ny]==1 && cost[nx][ny] > cur[2]+1){
                    cost[nx][ny] = cur[2]+1;
                    pq.offer(new int[]{nx,ny,cur[2]+1});
                }
            }
        }
        answer = cost[n-1][m-1];
        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[][]{{0, 1, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 0}}));
        System.out.println(solution(new int[][]{{0, 1, 1, 0},{1, 1, 0, 1},{0, 0, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 0}}));
        System.out.println(solution(new int[][]{{0, 1, 1, 0, 1, 1},{0, 1, 1, 1, 1, 1},{1, 0, 0, 0, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 0}}));
        System.out.println(solution(new int[][]{{0, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 0}}));
        System.out.println(solution(new int[][]{{0, 0, 1, 0, 1, 1, 1},{1, 1, 0, 0, 1, 1, 1},{1, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1, 0}}));
    }
}
