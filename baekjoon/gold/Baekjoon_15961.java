package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 임의의 위치에서 k개의 접시를 연속해서 먹으면 할인
 * 쿠폰에 적힌 초밥하나를 무료로 제공하고, 없으면 새로만들어서 제공
 *
 */
public class Baekjoon_15961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 접시수
        int d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[d + 1];
        int kind = 0;
        // 초기 셋팅
        for (int i = 0; i < k - 1; i++) {
            if (count[arr[i]]++ == 0) {
                kind++;
            }
        }

        int ans = kind;

        for (int i = 0; i < n; i++) {
            int left = arr[i]; // 나가는 초밥
            int right = arr[(i + k - 1) % n]; // 들어오는 초밥
            // 새로운 초밥 추가
            if (count[right] == 0) {
                kind++;
            }
            count[right]++;

            if (count[c] == 0) {
                ans = Math.max(ans, kind + 1);
            } else {
                ans = Math.max(ans, kind);
            }

            // 나가는 초밥 제거
            count[left]--;
            if (count[left] == 0) {
                kind--;
            }
        }
        System.out.println(ans);

    }
}
