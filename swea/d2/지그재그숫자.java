package swea.d2;

import java.io.FileInputStream;
import java.util.Scanner;

public class 지그재그숫자 {
    public static void main(String args[]) throws Exception
    {

        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();


        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n =sc.nextInt();
            int a =0;
            int b=0;
            for(int i=1;i<=n;i++){
                if(i%2==0){
                    b-=i;
                }
                if(i%2==1){
                    a+=i;
                }
            }
            int ans = a+b;

            System.out.println("#"+test_case +" " + ans);
        }
    }
}
