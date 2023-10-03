package swea.d2;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class 최빈수구하기
{
    public static void main(String args[]) throws Exception
    {

        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int[] score = new int[1000];
            HashMap<Integer,Integer> hashMap = new HashMap<>();
            for(int i=0;i<1000;i++){
                int a = sc.nextInt();
                hashMap.put(a,hashMap.getOrDefault(a,0)+1);
            }

            int temp = Integer.MIN_VALUE;
            int ans=0;
            for(int x : hashMap.keySet()){
                if (temp < hashMap.get(x)){
                    temp = hashMap.get(x);
                    ans = x;
                }
                if(temp == hashMap.get(x) && ans < x){
                    ans = x;
                }
            }
            System.out.println("#"+n+" "+ans);
        }
    }
}