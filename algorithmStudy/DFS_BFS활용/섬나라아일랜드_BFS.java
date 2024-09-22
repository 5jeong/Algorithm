//package algorithmStudy.DFS_BFS활용;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class 섬나라아일랜드_BFS {
//    static class Point {
//        int x, y;
//        Point(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//    static int n;
//    static int[][] board = new int[21][21];
//    static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
//    static int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};
//    static Queue<Main.Point> queue = new LinkedList<>();
//
//    static void BFS() {
//        while (!queue.isEmpty()) {
//            Main.Point temp = queue.poll();
//            for (int i = 0; i < 8; i++) {
//                int nx = temp.x + dx[i];
//                int ny = temp.y + dy[i];
//                if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
//                    board[nx][ny] = 0;
//                    queue.offer(new Main.Point(nx, ny));
//                }
//            }
//        }
//    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        n = Integer.parseInt(st.nextToken());
//        for (int i = 0; i < n; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < n; j++) {
//                board[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//        int ans = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (board[i][j] == 1) {
//                    board[i][j] = 0;
//                    queue.offer(new Main.Point(i, j));
//                    BFS();
//                    ans++;
//                }
//            }
//        }
//        System.out.println(ans);
//    }
//}
//
