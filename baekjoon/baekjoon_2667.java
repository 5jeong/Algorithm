package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon_2667 {
    static class Point{
        int x,y;
        Point(int x,int y){
            this.x = x;
            this.y = y;
        }

    }
    static int[][] board;
    static int n;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static ArrayList<Integer> ans = new ArrayList<>();
    static Queue<Point> q = new LinkedList<>();
    static void BFS(){
        int house_cnt=0;
        while(!q.isEmpty()){
            Point temp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && board[nx][ny] == 1) {
                    board[nx][ny] = 0;
                    house_cnt++;
                    q.offer(new Point(nx, ny));
                }
            }
        }
        if(house_cnt==0){
            ans.add(1);
        }
        else{
            ans.add(house_cnt);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[26][26];
        for(int i=0;i<n;i++){
            String s = br.readLine();
            for(int j =0;j<s.length();j++){
                board[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==1){
                    cnt++;
                    q.add(new Point(i,j));
                    BFS();
                }
            }
        }
        Collections.sort(ans);
        System.out.println(cnt);
        for(int x : ans){

            System.out.println(x);
        }
    }
}
