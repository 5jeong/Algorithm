package Promgrammers.level2;

import java.util.Arrays;

public class Solution {
    static int[] dx={-1,0,0,1};
    static int[] dy={0,-1,1,0};
    static int n = 5;
    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {
                "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {
                "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        int[] ans = solution(places);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] solution(String[][] places) {
        int[] ans = new int[n];
        int idx=0;
        for(String[] place : places){
            char[][] room = new char[n][n];
            for(int i=0;i<n;i++){
                room[i] = place[i].toCharArray();
            }
            //대기실 모든 응시자(P) 위치반복
            for(int x=0;x<n;x++){
                for(int y=0;y<n;y++){
                    if(room[x][y]=='P'){
                        if(!isDistanced(room,x,y)){
                            ans[idx] = 0;
                        }else{
                            ans[idx] = 1;
                        }
                    }
                }
            }
            idx++;
        }
        return ans;
    }
    // 응시자 위치 기준 거리두기 확인
    public static boolean isDistanced(char[][] room,int x,int y){
        for(int dir = 0 ; dir < 4;dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(nx >=0 && nx < n && ny >= 0 && ny < n){
                if(room[nx][ny] == 'P'){
                    return false;
                }
                if(room[nx][ny] == 'O'){
                    if(!isNextDistanced(room,nx,ny,3-dir)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //응시자 주변이 빈테이블일때 거리두기 확인
    public static boolean isNextDistanced(char[][] room,int x,int y, int exclude){
        for(int dir=0;dir<4;dir++){
            if(dir == exclude){
                continue;
            }
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(nx >=0 && nx < n && ny >= 0 && ny < n && room[nx][ny]=='P'){
                return false;
            }
        }
        return true;
    }
}
