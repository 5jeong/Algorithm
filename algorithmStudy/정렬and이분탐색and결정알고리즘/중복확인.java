package algorithmStudy.정렬and이분탐색and결정알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

// 해쉬맵 시간복잡도 = n
// 정렬 시간복작도 = n*logn

public class 중복확인 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i =0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        String ans = "U";
        for(int i=0;i<n-1;i++){
            if(arr[i]==arr[i+1]){
                ans="D";
                break;
            }
        }
        System.out.println(ans);
        /*
        해쉬맵 알고리즘
        for(int i : arr){
            hashMap.put(i,hashMap.getOrDefault(i,0)+1);
            if(hashMap.get(i)>1){
                System.out.println("D");
                return;
            }
        }
        System.out.println("U");

         */
    }
}
