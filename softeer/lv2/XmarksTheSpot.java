package softeer.lv2;

import java.util.Scanner;

public class XmarksTheSpot {
    // 모두 대문자로 변환
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String a = sc.next().toUpperCase();
            String b = sc.next().toUpperCase();

            int idx = a.indexOf("X");
            sb.append(b.charAt(idx));
        }
        System.out.println(sb);
    }
}
