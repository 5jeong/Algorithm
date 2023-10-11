package swea.d3;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class 암호문1 {

    public static void main(String args[]) throws Exception {
//        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
//        T=sc.nextInt();
        T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            LinkedList<Integer> linkedList = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                linkedList.add(sc.nextInt());
            }
            int cnt = sc.nextInt();
            for (int i = 0; i < cnt; i++) {
                char c = sc.next().charAt(0);
                if (c == 'I') {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    for (int j = x; j < x + y; j++) {
                        linkedList.add(j, sc.nextInt());
                    }
                }
            }
            System.out.print("#" + test_case + " ");
            for (int i = 0; i < 10; i++) {
                System.out.print(linkedList.get(i) + " ");
            }
            System.out.println();
        }
    }
}