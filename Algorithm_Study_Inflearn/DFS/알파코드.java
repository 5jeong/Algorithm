package Algorithm_Study_Inflearn.DFS;

public class 알파코드 {
    static int n, answer;
    static int[] dy;

    static int dfs(int L, String s) {
        if (dy[L] > 0) {
            return dy[L];
        }
        if (L == n) {
            return 1;
        }
        for (int i = L; i < n; i++) {
            String temp = s.substring(L, i + 1);
            if (check(temp)) {
                dy[L] += dfs(i + 1, s);
            } else {
                break;
            }
        }
        return dy[L];
    }

    static boolean check(String str) {
        if (str.charAt(0) == '0') {
            return false;
        }
        int num = Integer.parseInt(str);
        return num >= 1 && num <= 26;
    }

    public static int solution(String s) {
        answer = 0;
        dy = new int[101];
        n = s.length();
        return dfs(0, s);
    }

    public static void main(String[] args) {
        System.out.println(solution("25114"));
        System.out.println(solution("23251232"));
        System.out.println(solution("21020132"));
        System.out.println(solution("21350"));
        System.out.println(solution("120225"));
        System.out.println(solution("232012521"));
    }
}
