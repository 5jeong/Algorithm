package algorithmStudy.배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 2][n + 2];
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        int ans=0;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int cnt = 0;
                for (int dir = 0; dir < 4; dir++) {
                    int temp = arr[i + dx[dir]][j + dy[dir]];
                    if (arr[i][j] > temp) {
                        cnt++;
                    }
                }
                if (cnt == 4) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
