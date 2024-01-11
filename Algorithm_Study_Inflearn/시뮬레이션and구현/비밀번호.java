package Algorithm_Study_Inflearn.시뮬레이션and구현;

import java.util.ArrayList;
import java.util.Arrays;

public class 비밀번호 {

    static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] dy = {1, 0, -1, 0, -1, 1, -1, 1};

    public static int solution(int[] keypad, String password) {
        int answer = 0;
        int[][] board = new int[3][3];
        int[][] dist = new int[10][10];
        ArrayList<Integer> pw = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Arrays.fill(dist[i], 2);
        }
        for (int i = 0; i < 10; i++) {
            dist[i][i] = 0;
        }
        int a = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = keypad[a];
                a++;
            }
        }
        for (char x : password.toCharArray()) {
            pw.add(Integer.parseInt(String.valueOf(x)));
        }
        int x = 0, y = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                x = i;
                y = j;
                int from = board[x][y];
                for (int dir = 0; dir < 8; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
                        int to = board[nx][ny];
                        dist[from][to] = 1;
                    }
                }

            }
        }
        for (int i = 0; i < pw.size() - 1; i++) {
            int from = pw.get(i);
            int to = pw.get(i + 1);
            answer += dist[from][to];
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}
