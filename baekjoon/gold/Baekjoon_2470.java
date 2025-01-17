package baekjoon.gold;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/***
 * 용액 특성값 = 혼합에 사용된 각 용액의 합
 * 특성값이 0에 가장 가까운 용액(최솟값)
 * 0에 제일 가깝다 = 절댓값이 제일 작은것
 *
 */
public class Baekjoon_2470 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // 정렬
        Arrays.sort(nums);

        ArrayList<Integer> ans = new ArrayList<>();
        int lt = 0;
        int rt = n - 1;
        int min = Integer.MAX_VALUE;
        int ansIdx1=0, ansIdx2=0;
        while (lt < rt) {
            // 같을때는 답
            if(Math.abs(nums[lt]) == Math.abs(nums[rt])){
                System.out.println(nums[lt] + " " + nums[rt]);
                return;
            }
            int sum = Math.abs(nums[lt] + nums[rt]);
            if (min > sum) {
                ansIdx1 = lt;
                ansIdx2 = rt;
                min = sum;
            }
            if (Math.abs(nums[lt]) < Math.abs(nums[rt])) {
                rt--;
            } else if (Math.abs(nums[lt]) > Math.abs(nums[rt])) {
                lt++;
            }
        }

        // 합이 min인 값 출력
        System.out.println(nums[ansIdx1] + " " + nums[ansIdx2]);

    }
}
