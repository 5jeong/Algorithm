package baekjoon.bronze;

import java.util.Scanner;

/**
 * 8진수
 */
public class Baekjoon_2998 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int len = s.length();
        while (len % 3 != 0) {
            s = "0" + s;
            len = s.length();
        }
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < len; i += 3) {
            String temp = s.substring(i,i+3);
            ans.append(Integer.parseInt(temp, 2));
        }
        System.out.println(ans);
    }
}
