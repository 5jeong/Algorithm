package swea.d3;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class 한빈이의SpotMart {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr=  new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            int ans=0;
            Arrays.sort(arr);
            for(int i=0;i<n-1;i++){
                for(int j=i+1;j<n;j++){
                    int temp = arr[i]+ arr[j];
                    if(temp > m){
                        break;
                    }
                    ans = Math.max(ans,temp);
                }
            }
            if(ans==0){
                ans=-1;
            }
            System.out.println("#"+test_case+" "+ans);


        }
    }
}