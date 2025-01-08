package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        String ans = "";
        StringBuffer sb = new StringBuffer();
        // n을 b진법으로 변환
        while (n > 0) {
            int temp = n % b;
            String res = convert(temp);
            sb.append(res);
            n = n / b;
        }

        ans = sb.reverse().toString();
        System.out.println(ans);

    }

    private static String convert(int res) {
        if (res > 9) {
            char c = (char) (res + 55);
            return String.valueOf(c);
        }
        return String.valueOf(res);
    }
}
