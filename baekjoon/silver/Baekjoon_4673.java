package baekjoon.silver;

import java.util.Arrays;

public class Baekjoon_4673 {
    public static void main(String[] args) {
        boolean[] isSelfNumber = new boolean[100000];
        Arrays.fill(isSelfNumber, true);
        for (int i = 1; i <= 10000; i++) {
            int temp = i;
            int n = i;
            while (n > 0) {
                temp += n % 10;
                n /= 10;
            }
            if (temp > 10000) {
                isSelfNumber[temp] = true;
            }
            isSelfNumber[temp] = false;
        }
        for (int i = 1; i <= 10000; i++) {
            if (isSelfNumber[i]) {
                System.out.println(i);
            }
        }
    }
}
