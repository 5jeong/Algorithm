package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_11068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            solution(num);

        }
    }

    private static void solution(int num) {
        for (int j = 2; j <= 64; j++) {
            String temp = convert(num,j);
            if(check(temp)){
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    private static void Solution(){

    }

    private static String convert(int num, int b) {
        String res = "";
        while (num > 0) {
            int temp = num % b;
            if (temp < 10) {
                res += temp;
            } else {
                res += (char) (temp + 55);
            }
            num /= b;
        }
        return new StringBuilder(res).reverse().toString();
    }

    private static boolean check(String str) {
        int lt = 0;
        int rt = str.length() - 1;

        while (lt < rt) {
            if (str.charAt(lt) != str.charAt(rt)) {
                return false;
            }
            lt++;
            rt--;
        }
        return true;

    }
}
