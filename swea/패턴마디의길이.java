package swea;

import java.io.FileInputStream;
import java.util.Scanner;

public class 패턴마디의길이 {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            String str = sc.next();
            int n = str.length();
            for (int i = 1; i <= n; i++) {
                String a = str.substring(0, i);
                String b = str.substring(i, i *2);
                if (a.equals(b)) {
                    System.out.println("#" + test_case + " " + a.length());
                    break;
                }
            }
        }
    }
}

