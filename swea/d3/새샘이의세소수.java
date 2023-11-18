package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 새샘이의세소수 {
    static int n, ans;
    static ArrayList<Integer> arrayList;

    static void dfs(int L, int s, int sum) {
        if (sum > n) {
            return;
        }
        if (L == 3) {
            if (sum == n) {
                ans++;
            }
        } else {
            for (int i = s; i < arrayList.size(); i++) {
                dfs(L + 1, i, sum + arrayList.get(i));
            }
        }

    }

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
//        T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            int[] arr = new int[n + 1];
            arrayList = new ArrayList<>();
            ans = 0;
            for (int i = 2; i <= n; i++) {
                if (arr[i] == 0) {
                    arrayList.add(i);
                }
                for (int j = i; j <= n; j += i) {
                    arr[j] = 1;
                }
            }
            int len = arrayList.size();
            for (int i = 0; i < len; i++) {
                for (int j = i; j < len; j++) {
                    for (int s = j; s < len; s++) {
                        int temp = arrayList.get(i)+arrayList.get(j)+arrayList.get(s);
                        if(temp == n){
                            ans++;
                        }
                    }
                }
            }
//            dfs(0, 0, 0);
            System.out.println("#" + test_case + " " + ans);
        }
    }
}