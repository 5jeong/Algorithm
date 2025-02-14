package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/***
 * 신입 사원
 * A의 성적이 B의 성적보다 안좋으면 탈락
 * 서류, 면접 성적 하나라도 월등 해야 선발
 * 선발하는 최대 인원수 출력
 */
public class Baekjoon_1964 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine()); // 지원자 수
            List<int[]> infos = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                infos.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }

            // 1. 서류(A) 성적 오름차순 정렬
            infos.sort((a, b) -> a[0] - b[0]);

            // 2. 면접 성적(B) 기준으로 선발
            int max = infos.get(0)[1];
            int ans = 1;
            for (int i = 1; i < n; i++) {
                if (infos.get(i)[1] < max) { // B 성적이 더 좋으면 선발 가능
                    ans++;
                    max = infos.get(i)[1]; // 최소 면접 점수 갱신
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
