package baekjoon.silver;

import java.util.Scanner;

/***
 * 부등호
 * 부등호 기호 '<' '>' 가 k개 나열된 A가 있다.
 * 서로 다른 한자리 숫자를 넣어 부등호 관계를 만족하는 수중 최댓값, 최솟값 출력
 * dfs + 완전탐색 + 가능한 숫자인지 체크
 */
public class Baekjoon_2529 {
    static int k;
    static int[] num;
    static int[] visited;
    static char[] sign;
    static long min, max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        num = new int[k + 1];
        visited = new int[10]; // 0~9 숫자 방문여부
        sign = new char[k]; // 부등호
        min = Long.MAX_VALUE;
        max = Long.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            sign[i] = sc.next().charAt(0);
        }

        dfs(0);

        StringBuilder sb = new StringBuilder();
        String ans1 = String.valueOf(max);
        if (ans1.length() != k + 1) {
            sb.append(0).append(max).append("\n");
        } else {
            sb.append(max).append("\n");
        }
        String ans2 = String.valueOf(min);
        if (ans2.length() != k + 1) {
            sb.append(0).append(min);
        } else {
            sb.append(min);
        }
        System.out.print(sb);

    }

    static void dfs(int L) {
        if (L == k + 1) {
            if (isPossible(num)) {
                String temp = "";
                for (int x : num) {
                    temp += x;
                }
                // 첫자리가 0이면
                long res = Long.parseLong(temp);
                max = Math.max(max, res);
                min = Math.min(min, res);
            }
        } else {
            for (int i = 0; i < 10; i++) {
                if (visited[i] == 0) {
                    visited[i] = 1;
                    num[L] = i;
                    dfs(L + 1);
                    visited[i] = 0;
                }
            }
        }
    }

    // 부등호를 만족하는지 확인
    static boolean isPossible(int[] num) {
        for (int i = 0; i < k; i++) {
            if (sign[i] == '<' && num[i] > num[i + 1]) {
                return false;
            } else if (sign[i] == '>' && num[i] < num[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
