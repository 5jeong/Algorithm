package baekjoon.bronze;

import java.util.Scanner;

public class Baekjoon_27961 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        if(n==0){
            System.out.println(n);
            return;
        }
        long cnt = 1;
        long ans = 1;
        while (cnt < n) {
            cnt *= 2;
            ans++;
        }
        System.out.println(ans);

    }
}
