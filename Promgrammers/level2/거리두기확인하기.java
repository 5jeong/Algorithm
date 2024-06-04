package Promgrammers.level2;

import java.util.Arrays;

/*
문제 풀이 흐름
1. 대기실의 모든 응시자(P)의 위치에 대해 반복
    A. 상하좌우 중 빈 테이블(O)이 있는 방향에 대해 체크
    B. 빈 테이블과 인접한 위치 중 응시자가 있다면 거리두기 x
2. 거리 두기를 지키지 않은 경우를 발견하지 못하면 거리두기를 지킨것으로 (1) 출력 / 한명이라도 거리두기를 지키지 않으면(0) 출력
 */
public class 거리두기확인하기 {
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int n = 5;
    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {
        "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {
        "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        int[] ans = solution(places);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] solution(String[][] places) {
        int[] answer = new int[n];
        int idx = 0;
        for (String[] place : places) {
            char[][] room = new char[n][n];
            for (int i = 0; i < n; i++) {
                room[i] = place[i].toCharArray();
            }
            if (isDistanced(room)) {
                answer[idx] = 1;
            } else {
                answer[idx] = 0;
            }
            idx++;
        }
        return answer;
    }

    private static boolean isDistanced(char[][] room) {
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (room[x][y] == 'P') {
                    if (!isDistanced(room, x, y)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean isDistanced(char[][] room, int x, int y) {
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (room[nx][ny] == 'P') {
                    return false;
                }
                if (room[nx][ny] == 'O') {
                    if (!isNextDistanced(room, nx, ny, 3 - dir)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean isNextDistanced(char[][] room, int x, int y, int exclude) {
        for (int dir = 0; dir < 4; dir++) {
            if (dir == exclude) {
                continue;
            }
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && room[nx][ny] == 'P') {
                return false;
            }
        }
        return true;
    }
}
