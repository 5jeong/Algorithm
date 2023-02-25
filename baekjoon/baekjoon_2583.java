package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class baekjoon_2583 {
    static class Point{
        int x,y;
        Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[][] board;
    static int m,n,k;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static ArrayList<Integer> ans = new ArrayList<>();
    static Queue<Point> q =new LinkedList<>();
    static void BFS(){
        int width=0;
        while(!q.isEmpty()){
            Point temp = q.poll();
            for(int i=0;i<4;i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if (nx >=0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    width++;
                    q.offer(new Point(nx,ny));
                }
            }
        }
        if(width==0){
            ans.add(1);
        }
        else{
            ans.add(width);
        }

        return;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new int[101][101];
        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for(int j = y1;j<y2;j++){
                for(int s =x1;s<x2;s++){
                    board[j][s] = 1;
                }
            }
        }
        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==0){
                    cnt++;
                    q.offer(new Point(i,j));
                    BFS();
                }
            }
        }
        System.out.println(cnt);
        Collections.sort(ans);
        for(int x : ans){
            System.out.print(x+" ");
        }

    }
}
