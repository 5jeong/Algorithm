package baekjoon.silver;

import java.util.ArrayList;
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
    static ArrayList<String> ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        num = new int[k + 1];
        visited = new int[10]; // 0~9 숫자 방문여부
        sign = new char[k]; // 부등호
        min = Long.MAX_VALUE;
        max = Long.MIN_VALUE;
        ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            sign[i] = sc.next().charAt(0);
        }
        for (int i = 0; i < 10; i++) {
            visited = new int[10];
            visited[i] = 1;
            dfs(1, "" + i);
        }

        System.out.println(ans.get(ans.size()-1));
        System.out.println(ans.get(0));

    }

    static void dfs(int L, String num) {
        if (L == k + 1) {
            ans.add(num);
        } else {
            for (int i = 0; i < 10; i++) {
                if (visited[i] == 0) {
                    if (isPossible(num.charAt(num.length() - 1)-'0', i, sign[L - 1])) {
                        visited[i] = 1;
                        dfs(L + 1, num + i);
                        visited[i] = 0;
                    }
                }
            }
        }

    }

    // 부등호를 만족하는지 확인
    static boolean isPossible(int pre, int now, char sign) {
        if(sign == '<' && pre > now){
            return false;
        }else if ( sign == '>' && pre < now){
            return false;
        }
        return true;
    }
}
