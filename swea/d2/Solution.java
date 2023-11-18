package swea.d2;

import java.io.FileInputStream;
import java.util.*;

public class Solution {

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d2\\input.txt"));
        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
        int T=10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            String str = sc.next();
            String ans = "";
            int lt = 0;
            int rt = 1;
            while (rt < str.length()) {
                lt++;
                rt++;
                while (str.charAt(lt) == str.charAt(rt)) {
                    lt--;
                    rt++;
                }
                if(str.charAt(lt) != str.charAt(rt)){
                    ans+=str.charAt(lt);
                    lt = rt;
                    rt += 1;
                }


            }
        }
    }
}
