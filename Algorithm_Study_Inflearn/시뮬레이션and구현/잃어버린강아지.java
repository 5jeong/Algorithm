package Algorithm_Study_Inflearn.시뮬레이션and구현;

public class 잃어버린강아지 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static int solution(int[][] board) {
        int answer = 0;
        int hyunsu_x = 0;
        int hyunsu_y = 0;
        int dog_x = 0;
        int dog_y = 0;
        int n = board.length;
        int time = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    hyunsu_x = i;
                    hyunsu_y = j;
                }
                if (board[i][j] == 3) {
                    dog_x = i;
                    dog_y = j;
                }
            }
        }
        int dir1 = 0, dir2 = 0;
        while (time < 10000) {
            time++;
            int hyunsu_nx = hyunsu_x + dx[dir1];
            int hyunsu_ny = hyunsu_y + dy[dir1];
            int dog_nx = dog_x + dx[dir2];
            int dog_ny = dog_y + dy[dir2];
            if (hyunsu_nx < 0 || hyunsu_nx >= n || hyunsu_ny < 0 || hyunsu_ny >= n
                    || board[hyunsu_nx][hyunsu_ny] == 1) {
                dir1 = (dir1 + 1) % 4;
            } else {
                hyunsu_x = hyunsu_nx;
                hyunsu_y = hyunsu_ny;
            }
            if (dog_nx < 0 || dog_nx >= n || dog_ny < 0 || dog_ny >= n || board[dog_nx][dog_ny] == 1) {
                dir2 = (dir2 + 1) % 4;
            } else {
                dog_x = dog_nx;
                dog_y = dog_ny;
            }
            if (hyunsu_x == dog_x && hyunsu_y == dog_y) {
                break;
            }
        }
        answer = time;
        if (time >= 10000) {
            answer = 0;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(solution(arr2));
    }
}
