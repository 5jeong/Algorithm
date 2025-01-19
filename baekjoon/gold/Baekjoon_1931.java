package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/***
 * 회의실 배정
 * 각 회의에 대해 시작시간과 끝나는 시간이 주어질때, 겹치지 않는 회의실을 사용하는 회의 최대개수
 * 시작시간과 끝나는 시간이 같으면 시작하자마자 끝남
 *
 */
public class Baekjoon_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        ArrayList<int[]> times = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            times.add(new int[]{s, e});
        }

        times.sort((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        int ans = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            // 끝나는 시간이 회의시작 시간보다 작으면 회의가능 및 end 변경
            if (end <= times.get(i)[0]) {
                ans++;
                end = times.get(i)[1];
            }
        }
        System.out.println(ans);
    }
}
