package Algorithm_Study_Inflearn.DFS;

public class 알파코드 {
    static int n, answer;
    static int[] dy;

    static void dfs(int L, String s) {
        if (L == n) {
            answer++;
        } else {
            for (int i = L; i < n; i++) {
                String temp = s.substring(L, i + 1);
                if (check(temp)) {
                    dfs(i + 1, s);
                } else {
                    break;
                }
            }
        }
    }

    static int DFS(int L, String s) {
        if (dy[L] > 0) {
            return dy[L];
        }
        if (L < n && s.charAt(L) == '0') {
            return 0;
        }
        if (L == n - 1 || L == n) {
            return 1;
        } else {
            int a = DFS(L + 1, s);
            int b = Integer.parseInt(s.substring(L, L + 2));
            if (b <= 26) {
                a += DFS(L + 2, s);
            }
            return dy[L] = a;
        }
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
//        dfs(0, s);
        answer = DFS(0, s);
        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution("25114"));
        System.out.println(solution("23251232"));
        System.out.println(solution("21020132"));
        System.out.println(solution("21350"));
        System.out.println(solution("120225"));
        System.out.println(solution("232012521"));
    }
}
