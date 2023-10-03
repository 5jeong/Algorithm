package swea.d2;

import java.io.FileInputStream;
import java.util.Scanner;

public class 날짜계산기 {
    public static void main(String args[]) throws Exception
    {

        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int[] date = {0,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            int month1 = sc.nextInt();
            int date1 = sc.nextInt();
            int month2 = sc.nextInt();
            int date2 = sc.nextInt();

            int sum1 = 0, sum2 = 0;
            for (int i = 1; i < month1; i++) {
                sum1 += date[i];
            }
            sum1 += date1;
            for (int i = 1; i < month2; i++) {
                sum2 += date[i];
            }
            sum2 += date2;
            int ans = sum2 - sum1 + 1;
            System.out.println("#" + test_case + " " + ans);
        }
    }
}
