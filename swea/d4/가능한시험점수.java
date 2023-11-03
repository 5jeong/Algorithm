package swea.d4;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class 가능한시험점수 {

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d4\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            HashSet<Integer> hashSet = new HashSet<>();
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            hashSet.add(0);
            hashSet.add(arr[0]);
            for (int i = 1; i < n; i++) {
                HashSet<Integer> copy = (HashSet<Integer>) hashSet.clone();
                Iterator<Integer> it = copy.iterator();
                while (it.hasNext()){
                    int temp  = it.next() + arr[i];
                    hashSet.add(temp);
                }
            }

            System.out.println("#" + test_case + " " + hashSet.size());
        }
    }
}
