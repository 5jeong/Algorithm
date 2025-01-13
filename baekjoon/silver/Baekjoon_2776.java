package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/***
 * 풀이 방법
 * 1. 이분탐색
 * 2. HashSet 사용
 */
public class Baekjoon_2776 {

    // 이분탐색 풀이
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int t = Integer.parseInt(br.readLine());
//
//        while (t-- > 0) {
//
//            StringBuilder sb = new StringBuilder();
//
//            int n = Integer.parseInt(br.readLine());
//            int[] note1 = new int[n];
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for (int i = 0; i < n; i++) {
//                note1[i] = Integer.parseInt(st.nextToken());
//            }
//
//            st = new StringTokenizer(br.readLine());
//
//            int m = Integer.parseInt(st.nextToken());
//            int[] note2 = new int[m];
//
//            st = new StringTokenizer(br.readLine());
//            for (int i = 0; i < m; i++) {
//                note2[i] = Integer.parseInt(st.nextToken());
//
//            }
//
//            // note1 정렬
//            Arrays.sort(note1);
//            // 이분탐색
//            for (int x : note2) {
//                if (binarySearch(x, note1)) {
//                    sb.append("1").append("\n");
//                } else {
//                    sb.append("0").append("\n");
//                }
//            }
//            System.out.print(sb);
//        }
//    }
//
//    private static boolean binarySearch(int x, int[] note1) {
//        int lt = 0;
//        int rt = note1.length - 1;
//        int mid = 0;
//        while (rt >= lt) {
//            mid = (lt + rt) / 2;
//            int target = note1[mid];
//            if (target == x) {
//                return true;
//
//            } else if (target > x) {
//                rt = mid - 1;
//            } else {
//                lt = mid + 1;
//            }
//        }
//        return false;
//    }

    //HashSet 풀이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        while (t-- > 0) {

            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            HashSet<Integer> note1 = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                note1.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int target = Integer.parseInt(st.nextToken());

                if (note1.contains(target)) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }
            System.out.print(sb);
        }
    }
}
