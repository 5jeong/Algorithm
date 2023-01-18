package algorithmStudy.정렬and이분탐색and결정알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 삽입정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr= new int[n];
        st= new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<n;i++){
            int temp=arr[i];
            for(int j=i-1;j>=0;j--){
                if(temp < arr[j]){
                    arr[j+1] = arr[j];
                    arr[j]=temp;
                }
            }
        }
        for(int x : arr){
            System.out.print(x+" ");
        }
    }
}
