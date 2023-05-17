package Algorithm_Study_Inflearn.시뮬레이션and구현;

import java.util.Arrays;

public class 좌석번호 {
    public static int[] solution(int c, int r, int k){
        int[] answer = new int[2];
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int x = 0,y=0,last=c*r;
        if(last < k){
            answer[0] = 0;
            answer[1] = 0;
            return answer;
        }
        int cnt=1;
        int[][] seat = new int[c][r];
        int d=1;
        while(cnt < k){
            int nx = x+dx[d];
            int ny = y+dy[d];
            if(nx < 0 || nx > c-1 || ny <0 || ny > r-1 || seat[nx][ny]>0){
                d = (d+1)%4;
                continue;
            }
            seat[x][y] = cnt;
            cnt++;
            x=nx;
            y=ny;
        }
        answer[0] = x+1;
        answer[1] = y+1;
        return answer;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(solution(6, 5, 12)));
        System.out.println(Arrays.toString(solution(6, 5, 20)));
        System.out.println(Arrays.toString(solution(6, 5, 30)));
        System.out.println(Arrays.toString(solution(6, 5, 31)));
    }
}
