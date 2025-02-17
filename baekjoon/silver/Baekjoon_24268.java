package baekjoon.silver;

import java.util.Scanner;

/***
 * 2022는 무엇이 특별할까
 * N보다 크면서 d진법으로 바꿨을때 d진법 숫자가 모두 1번식 등장하는 가장 작은수 10진법으로 출력
 */
public class Baekjoon_24268 {
    static int n, d;
    static int[] visited;
    static int[] nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        d = sc.nextInt();
        visited = new int[d];
        nums = new int[d];

        // 1. d진법에서 만들 수 있는 최대값 구하기 (d-1 ~ 0)
        String maxStr = "";
        for (int i = d - 1; i >= 0; i--) {
            maxStr += i;
        }
        int max = Integer.parseInt(maxStr, d);

        // 2. n이 이미 최댓값 이상이면 -1 출력
        if (n >= max) {
            System.out.println(-1);
            return;
        }

        // 3. 백트래킹 탐색 시작
        dfs(0);
    }

    static void dfs(int L) {

        // 첫번째 자리가 0이면 안됨
        if (L == d && nums[0] != 0) {
            // 4. 숫자 조합을 문자열로 변환
            String res = "";
            for (int x : nums) {
                res += x;
            }
            if (n < Integer.parseInt(res)) {
                System.out.println(Integer.parseInt(res, d));
                System.exit(0);
            }
            return;
        }
        // 5. 숫자 순열 생성
        for (int i = 0; i < d; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                nums[L] = i;
                dfs(L + 1);
                visited[i] = 0;
            }
        }
    }
}
