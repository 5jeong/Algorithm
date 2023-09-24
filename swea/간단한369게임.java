package swea;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class 간단한369게임 {
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T=1;
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            String[] arr=  new String[n];
            String[] ans  = new String[n];
            for(int i=0;i<n;i++){
                arr[i] = String.valueOf(i+1);
                ans[i] = arr[i];
            }
            String temp=" ";
            for(int i=0;i<n;i++){
                temp ="";
                for(char x : arr[i].toCharArray()){
                    if(x=='3' || x=='6'|| x=='9'){
                        temp+="-";
                    }
                }
                if(temp !=""){
                    ans[i]=temp;
                }
            }
            for(String x : ans){
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }
}
