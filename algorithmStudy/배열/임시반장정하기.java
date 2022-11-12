package algorithmStudy.배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 임시반장정하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr=new int[n+1][6];
        int ans=0;
        int max = Integer.MIN_VALUE;
        for(int i=1;i<n+1;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<6;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1;i<n+1;i++){
            int cnt =0;
            for(int j=1;j<6;j++){
                for(int k=1;k<6;k++){
                    if(arr[i][k] == arr[j][k] && i!=j ){
                        cnt++;
                        break;
                    }
                }
            }
            if(cnt > max){
                max = cnt;
                ans =i;
            }
        }
        System.out.println(ans);
    }
}
