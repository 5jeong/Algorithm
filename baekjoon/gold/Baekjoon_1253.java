package baekjoon.gold;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_1253 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int ans =0;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int lt = 0;
            int rt = n - 1;
            while (lt < rt) {
                int temp = nums[lt] + nums[rt];
                // 자기 자신은 포함 x
                if(i == lt ){
                    lt++;
                    continue;
                }
                if(i == rt){
                    rt--;
                    continue;
                }
                if(temp == num){
                    ans++;
                    break;
                }
                else if(temp > num){
                    rt--;
                }
                else {
                    lt++;
                }
            }
        }
        System.out.println(ans);

    }
}
