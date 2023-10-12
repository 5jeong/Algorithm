package swea.d3;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 진용이네주차타워 {

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] cost = new int[n + 1];
            int[] weight = new int[m + 1];
            int[] parking = new int[n + 1]; // 주차장
            Queue<Integer> wait = new LinkedList<>(); //대기

            for (int i = 1; i <= n; i++) {
                cost[i] = sc.nextInt();
            }
            for (int i = 1; i <= m; i++) {
                weight[i] = sc.nextInt();
            }
            int ans = 0;
            for (int i = 0; i < m * 2; i++) {
                int motion = sc.nextInt();
                boolean flag = false;
//                System.out.println("motion : "+motion);
                for (int j = 1; j <= n; j++) {
                    if (parking[j] == 0 && motion > 0 && wait.isEmpty()) { // 들어옴
                        parking[j] = motion;
                        ans += (weight[motion] * cost[j]);
                        flag = true;
                        break;
                    }
                    if (motion < 0 && Math.abs(motion) == parking[j]) {
                        if (wait.isEmpty()) {  //대기없을때
                            parking[j] = 0;
                        } else {
                            int temp = wait.poll();
                            parking[j] = temp; //대기 있을때
                            ans += (weight[temp] * cost[j]);
                        }
                        flag = true;
                        break;
                    }
                }
                if(flag==false && motion > 0){
                    wait.add(motion);
                }
            }
            System.out.println("#" + test_case + " " + ans);

        }
    }
}