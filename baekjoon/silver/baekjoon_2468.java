package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_2468 {
    static class Point{
        int x,y;
        Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[][] board;
    static int[][] ch;
    static int n,min,max;
    static ArrayList<Integer> safeZone = new ArrayList<>();
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<Point> q = new LinkedList<>();
    static void BFS(int rain){
        while(!q.isEmpty()){
            Point temp = q.poll();
            for(int i=0;i<4;i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if(nx >= 0 && ny >=0 && nx < n && ny < n && board[nx][ny] > rain && ch[nx][ny]==0){
                    ch[nx][ny] =1;
                    q.offer(new Point(nx,ny));
                }

            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        board = new int[n][n];

        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                int temp = Integer.parseInt(st.nextToken());
                max = Math.max(max,temp);
                board[i][j] = temp;
            }
        }
        int cnt=0;
        for(int i=0;i<max;i++){
            ch = new int[n][n];
            cnt=0;
            for(int j = 0 ; j<n;j++){
                for(int k = 0;k<n;k++){
                    if(i < board[j][k] && ch[j][k]==0){
                        q.offer(new Point(j,k));
                        ch[j][k]=1;
                        BFS(i);
                        cnt++;
                    }
                }
            }
            safeZone.add(cnt);
        }
        int ans=Integer.MIN_VALUE;
        for(int x : safeZone){
            ans = Math.max(ans,x);
        }
        System.out.println(ans);
    }
}
