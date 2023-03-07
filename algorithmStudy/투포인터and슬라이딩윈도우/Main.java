package algorithmStudy.투포인터and슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }
        int lt = 1;
        int sum = 0;
        for (int rt = 1; rt < n; rt++) {
            sum += arr[rt];
            if (sum == n) {
                ans++;
            }
            while (sum >= n) {
                sum -= arr[lt];
                lt++;
                if (sum == n) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
