package swea.d3;

import java.io.FileInputStream;
import java.util.*;

public class 안경이없어 {

    public static void main(String args[]) throws Exception {
//        System.setIn(new FileInputStream("C:\\Users\\82109\\Desktop\\정훈\\알고리즘 공부\\Algorithm_Java\\swea\\d3\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            String a = "CEFGHIJKLMNSTUVWXYZ";
            String b = "ADOPQR";
            LinkedList<Character> zero = new LinkedList<>();
            LinkedList<Character> one = new LinkedList<>();

            for (Character x : a.toCharArray()) {
                zero.add(x);
            }
            for (Character x : b.toCharArray()) {
                one.add(x);
            }
            String s1 = sc.next();
            String s2 = sc.next();
            String ans = "SAME";
            if (s1.length() != s2.length()) {
                System.out.println("#" + test_case + " " + "DIFF");
                break;
            }
            for (int i = 0; i < s1.length(); i++) {
                if(zero.contains(s1.charAt(i))){
                    s1 = s1.replace(s1.charAt(i),'0');
                }
                if(one.contains(s1.charAt(i))){
                    s1 = s1.replace(s1.charAt(i),'1');
                }
                if(zero.contains(s2.charAt(i))){
                    s2 = s2.replace(s2.charAt(i),'0');
                }
                if(one.contains(s2.charAt(i))){
                    s2 = s2.replace(s2.charAt(i),'1');
                }
            }
            if(!s1.equals(s2)){
                ans="DIFF";
            }
            System.out.println("#" + test_case + " " + ans);
        }
    }
}