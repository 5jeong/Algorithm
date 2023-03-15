package algorithmStudy.정렬and이분탐색and결정알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] cache = new int[s];
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int cnt=0,temp=0;
        for(int x : arr){
            int idx =-1;
            for(int i=0;i<s;i++){
                if(cache[i]==x){
                    idx = i;
                }
            }
            if(idx==-1){
                for(int j=s-1;j>0;j--){
                    cache[j] = cache[j-1];
                }
                cache[0] = x;
            }
            else{
                for(int j=idx;j>0;j--){
                    cache[j] = cache[j-1];
                }
                cache[0] = x;
            }
        }
        for(int x : cache){
            System.out.print(x+" ");
        }
    }
}