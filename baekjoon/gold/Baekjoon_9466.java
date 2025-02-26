package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 텀프로젝트
 */
public class Baekjoon_9466 {
    static int n, cnt;
    static int[] nums;
    static int[] visited;
    static int[] finished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            nums = new int[n + 1];
            visited = new int[n + 1];
            finished = new int[n + 1];
            cnt = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i <= n; i++) {
                if (visited[i] == 0) {
                    dfs(i);
                }
            }
            sb.append(n - cnt).append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int now) {
        visited[now] = 1;
        int next = nums[now];

        if (visited[next] == 0) { // 아직 방문하지 않은 경우 탐색 진행
            dfs(next);
        } else if (finished[next] == 0) {  // 방문한 적은 있지만 탐색이 끝나지 않은 경우 (사이클 발생)
            int temp = next;
            cnt++;
            while (temp != now) { // 사이클을 이루는 학생 수를 카운트
                temp = nums[temp];
                cnt++;
            }
        }
        finished[now] = 1; // 현재 학생의 탐색 완료
    }
}
