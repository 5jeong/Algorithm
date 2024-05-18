package baekjoon;

import java.util.Scanner;

public class baekjoon_1543 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String findStr = sc.nextLine();
        int ans = 0;
        while (true) {
            int idx = s1.indexOf(findStr);
            if(idx == -1){
                break;
            }
            s1 = s1.substring(idx + findStr.length(), s1.length());
            ans++;
        }
        System.out.println(ans);
    }
}
