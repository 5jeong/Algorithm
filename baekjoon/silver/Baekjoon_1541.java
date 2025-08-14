package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Baekjoon_1541 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        String[] split = s.split("-");

        int ans = 0;
        boolean flag = false;

        for (String x : split) {
            String[] temp = x.split("\\+");
            int num = 0;
            for (String str : temp) {
                num += Integer.parseInt(str);
            }
            if (!flag) {
                ans += num;
            } else {
                ans -= num;
            }
            flag = true;
        }

        System.out.println(ans);
    }
}
