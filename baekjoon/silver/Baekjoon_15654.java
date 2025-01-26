package baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

/***
 * N과 M(5)
 * N개 자연수중 M개를 고른 수열
 * 중복x
 * 오름차순으로 출력
 */
public class Baekjoon_15654 {
    static int n, m;
    static int[] num;
    static int[] ch;
    static int[] res;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sb = new StringBuilder();
        num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        ch = new int[n];
        Arrays.sort(num);
        res = new int[m];

        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int L) {
        if(L == m){
            for(int x : res){
                sb.append(x).append(" ");
            }
            sb.append("\n");
        }else{
            for (int i = 0; i < n; i++) {
                if(ch[i] ==0){
                    ch[i] = 1;
                    res[L] = num[i];
                    dfs(L+1);
                    ch[i] = 0;
                }
            }
        }
    }

}
