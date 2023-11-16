package swea.d3;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 모음이보이지않는사람 {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
//        T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            String str = sc.next();
            ArrayList<Character> arr = new ArrayList<>();
            arr.add('a');
            arr.add('e');
            arr.add('i');
            arr.add('o');
            arr.add('u');
            String ans = "";
            for (char x : str.toCharArray()) {
                if (arr.contains(x)) {
                    continue;
                }
                ans += x;
            }
            System.out.println("#" + test_case + " " + ans);

        }
    }
}
