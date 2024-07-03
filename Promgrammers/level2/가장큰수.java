package Promgrammers.level2;

import java.util.Arrays;

public class 가장큰수 {
    public static String solution(int[] numbers) {
        String[] str = new String[numbers.length];
        int idx = 0;
        for (int x : numbers) {
            str[idx++] = String.valueOf(x);
        }
        Arrays.sort(str, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        if (str[0].equals("0")) {
            return "0";
        }
        System.out.println(Arrays.toString(str));
        return String.join("", str);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{6, 10, 2}));
        System.out.println(solution(new int[]{3, 30, 34, 5, 9}));
    }
}
