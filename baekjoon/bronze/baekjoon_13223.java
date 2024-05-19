package baekjoon.bronze;

import java.util.Scanner;

public class baekjoon_13223 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String currentTime = sc.next();
        String saltTime = sc.next();

        int h1 = Integer.parseInt(currentTime.split(":")[0]);
        int m1 = Integer.parseInt(currentTime.split(":")[1]);
        int s1 = Integer.parseInt(currentTime.split(":")[2]);

        int h2 = Integer.parseInt(saltTime.split(":")[0]);
        int m2 = Integer.parseInt(saltTime.split(":")[1]);
        int s2 = Integer.parseInt(saltTime.split(":")[2]);

        int second1 = ChangeSecond(h1, m1, s1);
        int second2 = ChangeSecond(h2, m2, s2);
        int needSecond = second2 - second1;
        if (needSecond <= 0) {
            needSecond += 3600 * 24;
        }

        int ansHour = needSecond / 3600;
        int ansMinute = (needSecond % 3600) / 60;
        int ansSecond = needSecond % 60;

        System.out.printf("%02d:%02d:%02d", ansHour, ansMinute, ansSecond);

    }

    private static int ChangeSecond(int h, int m, int s) {
        return h * 3600 + m * 60 + s;
    }

}
