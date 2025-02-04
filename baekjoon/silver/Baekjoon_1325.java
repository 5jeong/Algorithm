package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/***
 * 효율적인 해킹
 * A가 B를 신뢰할때, B를 해킹하면 A도 해킹 가능
 * 한번에 가장 많은 컴퓨터를 해킹하는 번호 오름차순으로 출력
 * 비 연결 그래프 + dfs
 */
public class Baekjoon_1325 {

    static int n, m;
    static int visited[];
    static ArrayList<ArrayList<Integer>> trustInfo;
    static int[] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        trustInfo = new ArrayList<>();
        res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            trustInfo.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            trustInfo.get(a).add(b);
        }
        // 완전탐색 + dfs
        for (int i = 1; i <= n; i++) {
            visited = new int[n + 1]; // 방문 초기화
//            dfs(i);
            bfs(i);
        }

        int max = Integer.MIN_VALUE;
        // 최대값 찾기
        for (int x : res) {
            max = Math.max(max, x);
        }

        // 최대값 찾기 및 출력
        for (int i = 1; i <= n; i++) {
            if (max == res[i]) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    static void dfs(int s) {
        visited[s] = 1;
        for (int x : trustInfo.get(s)) {
            if (visited[x] == 0) {
                visited[x] = 1;
                res[x]++;
                dfs(x);
            }
        }
    }

    // 왜시간초과?
    static void bfs(int s){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        visited[s] = 1;
        while(!queue.isEmpty()){
            int temp = queue.poll();
            for(int x : trustInfo.get(temp)){
                if(visited[x]==0){
                    visited[x]=1;
                    queue.offer(x);
                    res[x]++;
                }
            }
        }
    }


}
