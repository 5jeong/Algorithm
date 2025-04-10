package Promgrammers.level3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 퍼즐조각채우기 {
    static int n, ans;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<List<Point>> puzzles;
    static List<List<Point>> blanks;

    class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] game_board, int[][] table) {
        blanks = new ArrayList<>(); // 빈칸 모양 좌표
        puzzles = new ArrayList<>(); // 퍼즐조각 좌표
        n = game_board.length;
        // 빈칸 상대좌표로 채우기
        int idx = 0;
        ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (game_board[i][j] == 0) {
                    bfs(i, j, game_board, 0, blanks);
                }
                if (table[i][j] == 1) {
                    bfs(i, j, table, 1, puzzles);
                }
            }
        }

        int[] visited = new int[puzzles.size()];

        for (int i = 0; i < blanks.size(); i++) {
            for (int j = 0; j < puzzles.size(); j++) {
                if (visited[j] == 0 && isPossible(blanks.get(i), puzzles.get(j))) {
                    ans += puzzles.get(j).size();
                    visited[j] = 1;
                    break;
                }
            }
        }
        return ans;
    }

    // 빈칸,퍼즐  위치 찾기
    private void bfs(int x, int y, int[][] board, int target, List<List<Point>> res) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        board[x][y] = -1;
        List<Point> temp = new ArrayList<>();
        temp.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = now.x + dx[dir];
                int ny = now.y + dy[dir];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == target) {
                    board[nx][ny] = -1;
                    temp.add(new Point(nx, ny));
                    queue.add(new Point(nx, ny));
                }
            }
        }

        res.add(normalize(temp));

    }

    // 퍼즐 맞출수 있는지 확인
    private boolean isPossible(List<Point> blank, List<Point> puzzle) {
        List<Point> target = new ArrayList<>();
        for (Point p : puzzle) {
            target.add(new Point(p.x, p.y));
        }

        // 퍼즐을 4번 회전해보면서 확인
        for (int i = 0; i < 4; i++) {
            target = rotate(target);
            if (match(blank, target)) {
                return true;
            }
        }
        return false;
    }

    private boolean match(List<Point> blank, List<Point> target) {
        if (blank.size() != target.size()) {
            return false;
        }

        for (int i = 0; i < blank.size(); i++) {
            Point b = blank.get(i);
            Point t = target.get(i);
            if (b.x != t.x || b.y != t.y) {
                return false;
            }
        }
        return true;
    }

    // 90도 회전 후 정규화.
    private List<Point> rotate(List<Point> puzzle) {
        List<Point> res = new ArrayList<>();
        for (Point p : puzzle) {
            int nx = p.y;
            int ny = -p.x;
            res.add(new Point(nx, ny));
        }
        return normalize(res);
    }

    // 정규화 및 상대좌표 변환
    private List<Point> normalize(List<Point> list) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for (Point p : list) {
            minX = Math.min(minX, p.x);
            minY = Math.min(minY, p.y);
        }
        List<Point> res = new ArrayList<>();
        for (Point p : list) {
            res.add(new Point(p.x - minX, p.y - minY));
        }

        //정렬
        res.sort((a, b) -> a.x != b.x ? a.x - b.x : a.y - b.y);

        return res;
    }

}
