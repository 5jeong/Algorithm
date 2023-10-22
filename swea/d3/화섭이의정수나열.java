package swea.d3;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 화섭이의정수나열 {

    public static void main(String args[]) throws Exception
    {
//        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            String temp = "";
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
                temp+=arr[i];
            }
            int ans=0;
            boolean flag=true;
            while(flag){
                if(temp.contains(Integer.toString(ans))){
                    ans++;
                }
                else{
                    flag=false;
                }
            }
            System.out.println("#"+test_case+" "+ans);
        }
    }
}