package Promgrammers;

public class 피로도 {
    static int answer, n;
    static int[] ch;

    static void dfs(int L, int k, int[][] dungeons) {
        answer = Math.max(answer, L);
        for (int i = 0; i < n; i++) {
            if (ch[i] == 0 && k >= dungeons[i][0]) {
                ch[i] = 1;
                dfs(L + 1, k - dungeons[i][1], dungeons);
                ch[i] = 0;
            }
        }
    }

    public static int solution(int k, int[][] dungeons) {
        answer = -1;
        n = dungeons.length;
        ch = new int[n];
        dfs(0, k, dungeons);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
    }
}
