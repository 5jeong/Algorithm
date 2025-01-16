package baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

/***
 * 블루레이에는 n개의 강의가 있음, 강의의 순서는 바뀌면 안됨 (정렬x)
 * i번 강의와 j번 강의를 같은 블루레이에 녹화하려면 i와 j 사이의 모든 강의도 같은 블루레이에 녹화
 * m개의 블루레이는 모두 같은 크기여야함, 블루레이의 최소 크기 구하기
 */
public class Baekjoon_2343 {
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }

        binarySearch(arr,max);

    }

    private static void binarySearch(int[] arr,int max) {
        int lt = 0;
        int rt = n * 10000;
        int ans = 0;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if( mid < max){
                lt = mid +1;
                continue;
            }
            int cnt = 1;
            int temp = 0;
            for (int i = 0; i < n; i++) {

                temp += arr[i];

                if (temp > mid) {
                    cnt++;
                    temp = arr[i];
                }
            }

            if (cnt <= m) {
                rt = mid - 1;
                ans = mid;
            } else {
                lt = mid + 1;

            }
        }
        System.out.println(ans);

    }
}
