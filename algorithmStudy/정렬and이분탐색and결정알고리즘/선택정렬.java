package algorithmStudy.정렬and이분탐색and결정알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 선택정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<n;i++){
            int min = Integer.MAX_VALUE;
            int idx=0;
            for(int j=i;j<n;j++){
                if(arr[j]<min){
                    min = arr[j];
                    idx= j;
                }
            }
            arr[idx] = arr[i];
            arr[i] = min;
        }
        for(int x : arr){
            System.out.print(x+" ");
        }
    }
}
