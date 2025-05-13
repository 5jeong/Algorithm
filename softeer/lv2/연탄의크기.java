package softeer.lv2;

import java.util.Arrays;
import java.util.Scanner;

public class 연탄의크기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int ans = 0;
        int temp = 2; // 초기 연탄의 반지름
        int maxLen = arr[n-1];
        while(temp <= maxLen){
            int cnt=0;
            for(int x : arr){
                if(x % temp == 0){
                    cnt++;
                }
            }
            ans = Math.max(ans,cnt);
            temp++;
        }
        System.out.println(ans);
    }
}
