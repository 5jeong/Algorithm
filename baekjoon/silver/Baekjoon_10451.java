package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 순열사이클
 */
public class Baekjoon_10451 {

    static int n, ans;
    static int[] nums;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            ans = 0;
            nums = new int[n + 1];
            visited = new int[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                nums[i] = Integer.parseInt(st.nextToken()); // 순열 입력 받기
            }

            for (int i = 1; i <= n; i++) {
                if (visited[i] == 0) { // 방문하지 않은 노드에서 DFS 시작
                    dfs(i);
                }
            }

            sb.append(ans).append('\n'); // 결과 저장
        }
        System.out.println(sb);
    }

    static void dfs(int now) {
        visited[now] = 1; // 현재 노드 방문 처리

        if (visited[nums[now]] == 1) { // 다음 방문할 노드가 이미 방문된 경우
            ans++; // 하나의 사이클 발견
        } else {
            dfs(nums[now]); // 다음 노드 탐색
        }
    }
}
