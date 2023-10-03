package swea.d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class 농작물수확하기 {
    public static void main(String args[]) throws Exception {

        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for(int i=0;i<n;i++){
                String str = sc.next();
                for(int j =0; j< n;j++){
                    arr[i][j] = str.charAt(j)-'0';
                }
            }

            int start = n/2;
            int end = n/2;
            int ans=0;
            for(int i=0;i<n;i++){
                for(int j=start;j<=end;j++){
                    ans+=arr[i][j];
                }
                if(i < n/2){
                    start--;
                    end++;
                }
                else{
                    start++;
                    end--;
                }
            }
            System.out.println("#"+test_case + " "+ans);
        }
    }
}
