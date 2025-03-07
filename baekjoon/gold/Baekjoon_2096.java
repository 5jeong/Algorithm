package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 내려가기
 */
public class Baekjoon_2096 {

    static final int LEFT = 0;
    static final int MID = 1;
    static final int RIGHT = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] maxDp = new int[n + 1][3];
        int[][] minDp = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                maxDp[i][j] = Integer.parseInt(st.nextToken());
                minDp[i][j] = maxDp[i][j]; // 최소값 DP도 동일하게 초기화
            }
        }

        for (int i = 2; i <= n; i++) {
            // 최댓값 dp
            maxDp[i][LEFT] = Math.max(maxDp[i - 1][LEFT], maxDp[i - 1][MID]) + maxDp[i][LEFT];
            maxDp[i][MID] = Math.max(maxDp[i - 1][LEFT],
                    Math.max(maxDp[i - 1][MID], maxDp[i - 1][RIGHT])) + maxDp[i][MID];
            maxDp[i][RIGHT] = Math.max(maxDp[i - 1][RIGHT], maxDp[i - 1][MID]) + maxDp[i][RIGHT];

            // 최소값 dp
            minDp[i][LEFT] = Math.min(minDp[i - 1][LEFT], minDp[i - 1][MID]) + minDp[i][LEFT];
            minDp[i][MID] = Math.min(minDp[i - 1][LEFT],
                    Math.min(minDp[i - 1][MID], minDp[i - 1][RIGHT])) + minDp[i][MID];
            minDp[i][RIGHT] = Math.min(minDp[i - 1][RIGHT], minDp[i - 1][MID]) + minDp[i][RIGHT];
        }

        // 최댓값과 최솟값 찾기
        int max = Math.max(maxDp[n][LEFT], Math.max(maxDp[n][MID], maxDp[n][RIGHT]));
        int min = Math.min(minDp[n][LEFT], Math.min(minDp[n][MID], minDp[n][RIGHT]));

        System.out.println(max + " " + min);

    }
}
