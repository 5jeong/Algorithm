package algorithmStudy.배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 멘토링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][n];
        int ans=0;
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int cnt = 0;
                for (int s = 0; s < m; s++) {
                    int temp = 0, temp2 = 0;
                    for (int k = 0; k < n; k++) {
                        if (arr[s][k] == i) {
                            temp = k;
                        }
                        if (arr[s][k] == j) {
                            temp2 = k;
                        }
                    }
                    if (temp < temp2) {
                        cnt++;
                    }
                }
                if (cnt == m) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
