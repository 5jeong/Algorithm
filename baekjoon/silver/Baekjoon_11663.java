package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/***
 * N : 점의 개수 , M : 선분의 개수
 * 각 선분위의 점이 몇개 있는지 출력
 * 이분탐색
 */
public class Baekjoon_11663 {
    static int n, m;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        list.sort((a, b) -> a - b);
        int max = list.get(n - 1);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if (end > max) {
                end = max;
            }

            System.out.println(binarySearch(start, end));

        }
    }

    private static int binarySearch(int start, int end) {
        int lt = 0;
        int rt = n - 1;

        // x위치 구하기
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int temp =list.get(mid);
            if (temp < start) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        int xIndex = lt;

        lt = 0;
        rt = n - 1;

        // y좌표 구하기
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int temp =list.get(mid);
            if (temp > end) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        int yIndex = rt + 1;
        return yIndex - xIndex;
    }
}
