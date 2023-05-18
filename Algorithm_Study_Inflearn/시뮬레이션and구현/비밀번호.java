package Algorithm_Study_Inflearn.시뮬레이션and구현;

import java.util.Arrays;

public class 비밀번호 {

    public static int solution(int[] keypad, String password){
        int[] dx = {1,0,-1,0,1,1,-1,-1};
        int[] dy = {0,1,0,-1,1,-1,1,-1};
        int answer = 0;
        int[][] arr = new int[3][3];
        int cnt=0;
        for(int i=0;i<3;i++){
            if(cnt==keypad.length) break;
            for(int j=0;j<3;j++){
                arr[i][j] = keypad[cnt];
                cnt++;
            }
        }
        int[][] dist = new int[10][10];
        for(int i=0;i<10;i++){
            Arrays.fill(dist[i],2);
            dist[i][i]=0;
        }
        for(int i=0;i<3;i++){
            int temp=0;
            for(int j=0;j<3;j++){
                for(int dir=0;dir<8;dir++){
                    int nx = i + dx[dir];
                    int ny = j + dy[dir];
                    if(nx >= 0 && ny >= 0 && nx < 3 && ny <3){
                        temp = arr[nx][ny];
                        dist[arr[i][j]][temp]=1;
                    }
                }
            }
        }
        for(int i=0;i<password.length()-1;i++){
            int idx1 = Character.getNumericValue(password.charAt(i));
            int idx2 = Character.getNumericValue(password.charAt(i+1));
            answer+= dist[idx1][idx2];
        }


        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}
