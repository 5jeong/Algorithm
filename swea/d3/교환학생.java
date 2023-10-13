package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 교환학생 {
    public static void main(String args[]) throws Exception {
//        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[] arr =new int[7];
            for(int i=0;i<7;i++){
                arr[i] = sc.nextInt();
            }
            int ans=Integer.MAX_VALUE;
            for(int i=0;i<7;i++){
                if(arr[i]==0){
                    continue;
                }
                int start =i;
                int cnt=0;
                while(true){
                    if(arr[start % 7]== 1){
                        cnt++;
                    }
                    start++;
                    if(n==cnt){
                        ans = Math.min(ans,start-i);
                        break;
                    }
                }

            }
            System.out.println("#"+test_case+" "+ ans);
        }
    }
}