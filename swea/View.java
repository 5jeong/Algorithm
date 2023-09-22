package swea;

import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class View
{
    public static void main(String args[]) throws Exception
    {

        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        Scanner sc = new Scanner(System.in);
        int T;
        T=10;


        for(int test_case = 1; test_case <= T; test_case++)
        {
            int ans=0;
            int n = sc.nextInt();
            int[] building = new int[n];
            for(int i=0;i<n;i++){
                building[i] = sc.nextInt();
            }
            for(int i=2;i<n-2;i++){
                if(building[i] < building[i-1] || building[i] < building[i-2] || building[i] < building[i+1] || building[i] < building[i+2]){
                    continue;
                }
                int min =Integer.MAX_VALUE;
                for(int j =i-2 ;j<=i+2;j++){
                    if( i==j) continue;
                    int temp = building[i] - building[j];
                    min = Math.min(min,temp);
                }
                ans+=min;
            }
            System.out.println("#"+test_case +" "+ans);
        }
    }
}