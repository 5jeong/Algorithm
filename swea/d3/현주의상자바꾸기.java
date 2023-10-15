package swea.d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class 현주의상자바꾸기 {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
           int n = sc.nextInt();
           int q = sc.nextInt();
           int[] arr = new int[n+1];
           for(int i=1;i<=q;i++){
               int l = sc.nextInt();
               int r = sc.nextInt();
               for(int j=l;j<=r;j++){
                   arr[j]=i;
               }
           }
            System.out.print("#"+test_case);
           for(int i=1;i<=n;i++){
               System.out.print(" " + arr[i]);
           }
           System.out.println();
        }
    }
}