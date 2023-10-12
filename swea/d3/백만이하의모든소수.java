package swea.d3;

import java.util.Arrays;
import java.util.Scanner;

public class 백만이하의모든소수 {

    public static void main(String args[]) throws Exception {
        //System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
//        T=sc.nextInt();
        T=1;
        //에라토스테네스체
        for (int test_case = 1; test_case <= T; test_case++) {
            int[] arr = new int[1000001];
            for(int i=2;i<=1000000;i++){
                if(arr[i]==0){
                    System.out.print(i+" ");
                }
                for(int j=i;j<=1000000;j+=i){
                    arr[j]=1;
                }
            }
        }
    }
}