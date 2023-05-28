package algorithmStudy.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int lines;
    static int[][] board;
    static ArrayList<Integer> ans = new ArrayList<>();
    static Queue<Point> queue =new LinkedList<>();
    static class Point{
        int x,y;
        Point(int x,int y){
            this.x = x;
            this.y = y;
        }

    }
    static int BFS(){
        int size =1;
        while(!queue.isEmpty()){
            Point temp = queue.poll();
            for(int i=0;i<4;i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < lines && ny < lines && board[nx][ny] == 1){
                    board[nx][ny]=0;
                    queue.add(new Point(nx,ny));
                    size++;
                }
            }
        }
        return size;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        lines = Integer.parseInt(st.nextToken());
        board = new int[lines][lines];
        int[][] area = new int[lines][lines];
        for(int i=0; i<lines; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<lines;j++){
               board[i][j] = Integer.parseInt(st.nextToken());
           }
        }
        int cnt = 0;
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < lines; j++) {
                if (board[i][j] == 1) {
                    cnt++;
                    board[i][j] = 0;
                    queue.offer(new Point(i, j));
                    ans.add(BFS());
                }
            }
        }

        Collections.sort(ans);
        if(cnt==0){
            System.out.println(cnt);
        }
        else{
            System.out.println(cnt);
            for(int x : ans){
                System.out.print(x+" ");
            }
        }
    }
}
