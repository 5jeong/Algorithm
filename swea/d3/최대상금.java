package swea.d3;

import java.io.FileInputStream;
import java.util.*;

class 최대상금 {
    static int cnt, ans;
    static int[] arr;

    static void dfs(int start, int change) {
        if (change == cnt) {
            String temp = "";
            for (int x : arr) {
                temp += x;
            }
            ans = Math.max(ans, Integer.parseInt(temp));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                swap(i, j);
                dfs(i, change + 1);
                swap(i, j);
            }
        }
    }

    static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
//        int T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            String str = sc.next();
            cnt = sc.nextInt();
            ans = Integer.MIN_VALUE;
            arr = new int[str.length()];
            for (int i = 0; i < str.length(); i++) {
                arr[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
            }
            if (cnt > str.length()) {
                cnt = str.length();
            }
            dfs(0, 0);
            System.out.println("#" + test_case + " " + ans);

        }
    }
}