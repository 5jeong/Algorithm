package Promgrammers.level2;

import java.util.ArrayList;
import java.util.Arrays;

/*
<문제 풀이 흐름>
1. 2차원 배열 생성
2. (0,0) 좌표부터 시작
3. 방향에 따랑 이동할수 없을때 까지 반복
    a. 아래로 이동
    b. 오른쪽으로 이동
    c. 왼쪽 위로 이동
4. 배열 출력.
 */
public class 삼각달팽이 {
    private static final int[] dx = {1, 0, -1};
    private static final int[] dy = {0, 1, -1};

    public static void main(String[] args) {
        int[] ans = solution(4);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] solution(int n) {
        int[] answer = {};
        int[][] arr = new int[n][n];
        int cnt = 1;
        int x = 0, y = 0;
        int d = 0;
        while (true) {
            arr[x][y] = cnt++;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || arr[nx][ny] != 0) {
                d = (d + 1) % 3;
                nx = x + dx[d];
                ny = y + dy[d];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || arr[nx][ny] != 0) {
                    break;
                }
            }
            x = nx;
            y = ny;
        }
        int idx = 0;
        answer = new int[cnt-1];

        for (int[] a : arr) {
            for (int b : a) {
                if (b != 0) {
                    answer[idx++] = b;
                }
            }
        }
        return answer;
    }
}
