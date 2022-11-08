package algorithmStudy.배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 봉우리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int ans=0;
        int[][] arr = new int[n+2][n+2];
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        for(int i=1;i<n+1;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<n+1;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int nx,ny;

        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                boolean flag = true;
                for(int k=0;k<4;k++){
                  nx = i+dx[k];
                  ny = j+dy[k];
                  if(arr[i][j] <= arr[nx][ny]){
                      flag = false;
                      break;
                  }
                }
                if(flag){
                    ans++;
                }
//                if(arr[i][j] > arr[i-1][j] && arr[i][j] > arr[i][j-1] && arr[i][j] > arr[i+1][j] && arr[i][j] > arr[i][j+1]){
//                    ans++;
//
//                }
            }
        }
        System.out.println(ans);

    }
}

