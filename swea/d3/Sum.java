package swea.d3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Sum
{
    public static void main(String args[]) throws Exception
    {
//        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=10;


        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int[][] arr = new int[100][100];
            for(int i=0;i<100;i++){
                for(int j=0;j<100;j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            ArrayList<Integer> arrayList = new ArrayList<>();
            int num1=0;
            int num2=0;
            for(int i=0;i<100;i++){
                int temp=0;
                int temp2=0;
                for(int j=0;j<100;j++){
                    temp+=arr[i][j];
                    temp2+=arr[j][i];
                    if(i==j){
                        num1+=arr[i][j];
                    }
                    if(i+j==99){
                        num2 += arr[i][j];
                    }
                }
                arrayList.add(temp);
                arrayList.add(temp2);
            }
            arrayList.add(num1);
            arrayList.add(num2);

            Collections.sort(arrayList,Collections.reverseOrder());

            int ans = arrayList.get(0);
            System.out.println("#"+test_case +" "+ans);
        }
    }
}