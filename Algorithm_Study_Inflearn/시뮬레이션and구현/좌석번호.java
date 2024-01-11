package Algorithm_Study_Inflearn.시뮬레이션and구현;

import java.util.Arrays;

public class 좌석번호 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static int[] solution(int c, int r, int k){
        int[] answer = new int[2];
        int[][] board = new int[c][r];
        int size = c * r;
        if (k > size) {
            return new int[]{0, 0};
        }
        int x = 0;
        int y = 0;
        board[x][y] = 1;
        int dir = 0;
        int cnt = 1;
        while (cnt < size) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || nx >= c || ny < 0 || ny >= r || board[nx][ny] != 0) {
                dir = (dir + 1) % 4;
                continue;
            }
            cnt++;
            board[nx][ny] = cnt;
            x = nx;
            y = ny;
            if (cnt == k) {
                break;
            }
        }
        answer[0] = x + 1;
        answer[1] = y + 1;
        return answer;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(solution(6, 5, 12)));
        System.out.println(Arrays.toString(solution(6, 5, 20)));
        System.out.println(Arrays.toString(solution(6, 5, 30)));
        System.out.println(Arrays.toString(solution(6, 5, 31)));
    }
}
