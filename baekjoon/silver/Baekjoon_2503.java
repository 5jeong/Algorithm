package baekjoon.silver;

import java.util.Scanner;

/***
 * 동일한 자리면 스트라이크, 숫자가 있고 다른자리면 볼
 */
public class Baekjoon_2503 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }
        int ans = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    if (i == j || j == k || i == k) {
                        continue;
                    }
                    boolean flag = true;
                    // 후보
                    for (int s = 0; s < n; s++) {
                        int iTemp = arr[s][0] / 100;
                        int jTemp = (arr[s][0] / 10) % 10;
                        int kTemp = arr[s][0] % 10;

                        int strike = 0;
                        int ball = 0;

                        if (i == iTemp) {
                            strike++;
                        } else if (i == jTemp || i == kTemp) {
                            ball++;
                        }

                        if (j == jTemp) {
                            strike++;
                        } else if (j == iTemp || j == kTemp) {
                            ball++;
                        }

                        if (k == kTemp) {
                            strike++;
                        } else if (k == iTemp || k == jTemp) {
                            ball++;
                        }

                        if (strike != arr[s][1] || ball != arr[s][2]) {
                            flag = false;
                        }
                    }
                    if(flag){
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
