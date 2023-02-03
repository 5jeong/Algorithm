package algorithmStudy.DFS_BFS활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;


public class 토마토_BFS {
    static int m,n,ans= Integer.MIN_VALUE;
    static int[] dx ={1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] board;
    static int[][] dis;
    static Queue<Point> q = new LinkedList<>();
    static void BFS(){
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int dir=0;dir<4;dir++){
                int nx = p.x + dx[dir];
                int ny = p.y + dy[dir];
                if(nx>= 0 && ny >= 0 && nx <= n && ny <= m  && board[nx][ny] == 0){
                    board[nx][ny] =1;
                    dis[nx][ny] = dis[p.x][p.y] +1;
                    q.offer(new Point(nx,ny));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new int[1001][1001];
        dis = new int[1001][1001];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j]==1){
                    q.offer(new Point(i,j));
                }
            }
        }
        BFS();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans = Math.max(ans,dis[i][j]);
               if(board[i][j]==0){
                   System.out.println(-1);
                   return;
               }
            }
        }
        System.out.println(ans);
    }
}
