package algorithmStudy.배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 등수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] ans = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<n;i++){
            int cnt=1;
            for(int j=0;j<n;j++){
                if(i==j){
                    continue;
                }
                else if(arr[i] <arr[j]){
                    cnt++;
                }
            }
            ans[i] = cnt;
        }
        for(int i=0;i<n;i++){
            System.out.print(ans[i]+ " ");
        }

    }
}
