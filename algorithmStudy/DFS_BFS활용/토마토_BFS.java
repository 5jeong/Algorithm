package algorithmStudy.DFS_BFS활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;


public class 토마토_BFS {
    static class Point{
        int x,y;
        Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    static int[][] board = new int[1001][1001];
    static int[][] dis = new int[1001][1001];
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int m,n;
    static Queue<Point> queue = new LinkedList<>();

    static void BFS() {
        while(!queue.isEmpty()){
            Point temp = queue.poll();
            for(int i=0;i<4;i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if(nx>=0 && nx < n && ny >=0 && ny < m && board[nx][ny]==0){
                    board[nx][ny] =1;
                    dis[nx][ny] = dis[temp.x][temp.y] +1;
                    queue.offer(new Point(nx,ny));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j]==1){
                    queue.offer(new Point(i,j));
                }
            }
        }
        BFS();
        int ans= Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==0){
                    System.out.println(-1);
                    return;
                }
                ans = Math.max(ans,dis[i][j]);
            }
        }
        System.out.println(ans);
    }
}
