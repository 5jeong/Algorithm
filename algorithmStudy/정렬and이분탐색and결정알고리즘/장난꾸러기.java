package algorithmStudy.정렬and이분탐색and결정알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 장난꾸러기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] temp = new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i =0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            temp[i] = arr[i];
        }
        Arrays.sort(temp);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(arr[i] !=temp[i]){
                ans.add(i+1);
            }
        }
        for(int x :ans){
            System.out.print(x+" ");
        }
    }
}
