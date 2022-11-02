package algorithmStudy.배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 보이는학생 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int cnt=1;
        int max=0;
        int[] height = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            height[i] = Integer.parseInt(st.nextToken());
        }
        max = height[0];
        for(int i=1;i<n;i++){
            if(max<height[i]){
                max = height[i];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
